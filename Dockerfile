FROM openjdk:8
WORKDIR /home/ec2-user/
COPY tricountapi-0.0.1-SNAPSHOT.jar .
CMD java -jar tricountapi-0.0.1-SNAPSHOT.jar
