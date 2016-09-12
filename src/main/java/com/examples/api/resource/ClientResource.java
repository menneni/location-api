package com.examples.api.resource;

import com.examples.api.entity.Location;
import com.examples.api.entity.LocationList;
import com.examples.api.entity.ResponseTuple;
import com.examples.api.response.LocApiResponse;
import com.examples.api.response.LocByCityResponse;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVPrinter;
import org.glassfish.jersey.client.ClientResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.ws.rs.*;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.Invocation;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.*;
import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created by thej on 12/9/16.
 */

@Path("/client")
@Produces(MediaType.APPLICATION_JSON)
public class ClientResource {

    private static final Logger LOGGER =
            LoggerFactory.getLogger(ClientResource.class);

    private Client client;
    private final String apiURL;


    public ClientResource(String apiURL, Client client) {
        this.apiURL = apiURL;
        this.client = client;
    }

    @GET
    @Path("/city/{cityName}")

    public LocApiResponse getApiResponse(@PathParam("cityName") String cityName) {

        List<ResponseTuple> result = new ArrayList<ResponseTuple>();
        ObjectMapper objectMapper = new ObjectMapper();


        List locationList = client
                .target(apiURL)
                .path(cityName)
                .request(MediaType.APPLICATION_JSON)
                .get(List.class);

        for (int i = 0; i < locationList.size(); i++) {
            Location location = objectMapper.convertValue(locationList.get(i), Location.class);
            result.add(new ResponseTuple(location));
        }


        writeToCsv(result);


        return new LocApiResponse(new LocByCityResponse(result));
    }

    private void writeToCsv(List<ResponseTuple> result) {
        final String NEW_LINE_SEPARATOR = "\n";
        final Object[] FILE_HEADER = {"_id", "name", "type", "latitude", "longitude"};
        FileWriter fileWriter = null;
        String fileName = System.getProperty("user.home") + "/city-info.csv";
        System.out.printf("file name" + fileName);
        CSVPrinter csvFilePrinter = null;
        CSVFormat csvFileFormat = CSVFormat.DEFAULT.withRecordSeparator(NEW_LINE_SEPARATOR);

        try {
            fileWriter = new FileWriter(fileName);
            csvFilePrinter = new CSVPrinter(fileWriter, csvFileFormat);
            csvFilePrinter.printRecord(FILE_HEADER);
            for (ResponseTuple responseTuple : result) {
                List locInfoRecord = new ArrayList();
                locInfoRecord.add(String.valueOf(responseTuple.get_id()));
                locInfoRecord.add(String.valueOf(responseTuple.getName()));
                locInfoRecord.add(String.valueOf(responseTuple.getType()));
                locInfoRecord.add(String.valueOf(responseTuple.getLatitude()));
                locInfoRecord.add(String.valueOf(responseTuple.getLongitude()));
                csvFilePrinter.printRecord(locInfoRecord);
            }
        } catch (IOException e) {
            LOGGER.error("Error while creating/writing to file", e);
        } catch (Exception e) {
            LOGGER.error("Error in CsvFileWriter !!!", e);
        } finally {
            try {
                fileWriter.flush();
                fileWriter.close();
                csvFilePrinter.close();
            } catch (IOException e) {
                LOGGER.error("Error while flushing/closing fileWriter/csvPrinter !!!", e);
            }
        }
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public String getApiURL() {
        return apiURL;
    }
}
