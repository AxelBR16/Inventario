# Utiliza una imagen base de Java
FROM openjdk:17-jdk-slim

# Especifica el directorio de trabajo dentro del contenedor
WORKDIR /app

# Copia el archivo JAR generado (ajusta el nombre del archivo a tu proyecto)
COPY target/inventario-0.0.1-SNAPSHOT.jar app.jar

# Expone el puerto en el que la aplicación Spring Boot está escuchando
EXPOSE 8080

# Define el comando para ejecutar la aplicación
ENTRYPOINT ["java", "-jar", "app.jar"]
