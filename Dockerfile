FROM openjdk:8-jre-slim

#create folder with tests
RUN mkdir -p /tests

#copy all files to the new direct.
#COPY . /tests/
#WORKDIR /tests
#/////////////////////////////////////////////
# Add the project jar & copy dependencies

ADD  target/container-test.jar /usr/share/tag/container-test.jar
ADD  target/libs /usr/share/tag/libs

# Add the suite xmls
#ADD order-module.xml /usr/share/tag/order-module.xml
ADD search-module.xml /usr/share/tag/search-module.xml
#////////////////////////////////////////////
# Install maven
#RUN apt-get update
#RUN apt-get install -y maven
#start mvn test
#RUN ["mvn", "test"]

# Command line to execute the test
# Expects below ennvironment variables
# BROWSER = chrome / firefoxde
# MODULE  = order-module / search-module
# GRIDHOST = selenium hub hostname / ipaddress

#////////////////////////////////////////
ENTRYPOINT /usr/bin/java -cp /usr/share/tag/container-test.jar:/usr/share/tag/libs/* -DseleniumHubHost=$SELENIUM_HUB -Dbrowser=$BROWSER org.testng.TestNG /usr/share/tag/$MODULE