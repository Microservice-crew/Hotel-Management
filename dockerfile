FROM openjdk:8
EXPOSE 8084
ADD target/HotelManagementService-0.0.1-SNAPSHOT.jar Hotel.jar
ENTRYPOINT ["java", "-jar" ,"Hotel.jar"]
