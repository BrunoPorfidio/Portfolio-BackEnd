<<<<<<< HEAD

# Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
# Click nbfs://nbhost/SystemFileSystem/Templates/Other/Dockerfile to edit this template

FROM alpine:latest

CMD ["/bin/sh"]
=======
FROM amazoncorretto:19

MAINTAINER brunoporfidio

COPY target/apiportfolio-0.0.1-SNAPSHOT.jar apiportfolio.jar

ENTRYPOINT ["java","-jar","/apiportfolio.jar"]

>>>>>>> 1386cb22fbd6046cc38dde5fd0c142b6c9b3ab47
