FROM java:8
EXPOSE 8088
ADD calf.jar app.jar
RUN bash -c 'touch /app.jar'
ENTRYPOINT ["java", "-jar", "/app.jar"]