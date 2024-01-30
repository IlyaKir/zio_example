FROM sbtscala/scala-sbt:eclipse-temurin-jammy-11.0.22_7_1.9.8_2.12.18

WORKDIR /app

# copy all the files to the container
COPY . /app

# define the port number the container should expose
EXPOSE 9000/tcp

# run the command
CMD [ "sh", "-c", "sbt update compile && sbt run" ]
