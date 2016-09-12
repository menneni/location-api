# location-api

Steps to run

1) Do "mvn clean package"

2) Run following command on console -  "java -jar target/location-goeuro-1.0-SNAPSHOT.jar server config.yaml"

3) Hit following url for health check - "http://localhost:9901/healthcheck?pretty=true"

4) Use browser or curl to enter following url - "http://localhost:9900/client/city/berlin" (city name as path param)

5) JSON response will be printed on the browser along with output to file 'city-info.csv' on 'user' home directory ("~/city-info.csv") 
