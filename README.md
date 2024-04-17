# examenTecnico
Examen técnico para plaza backend para gestion de entidades WasteManagerEntity

### Descripcion ###
Esta es una arquitectura microservicios encargada de la gestion de las entidades
WasteManagerEntity y WasteManagerEntityAddress. El mismo implementa los patrones arquitectónicos Domain Driven Design, Clean Arch en una Arquitectura hexagonal. Las cuales ofrecen como ventajas el facil mantenimiento del codigo y su migracion a otros framework de manera transparente  También cuenta con su archivo docker-compose para un rápido inicio de la nube de microservicios.

### Estructura del proyecto ###

<img src="https://github.com/RivasB/TTeams/blob/main/project.png"/>

### Instalacion ###

``` bash
mkdir examenTecnico
cd examenTecnico
git clone https://github.com/oneldeltoro/examenTecnico.git

mvn clean install -DskipTest 

docker-compose up -d
```
la aplicacion se iniciaria http://localhost:9091


La configuración por defecto para la base de datos, es la siguiente:

```yaml
spring.datasource.url=jdbc:h2:mem:pruebatecnica #Ubicacion de la Tabla Tareas
spring.datasource.driverClassName=org.h2.Driver
spring.datasource.username=sa #Nombre del usuario
spring.datasource.password=   #Password del Usuario
spring.jpa.database-platform=org.hibernate.dialect.H2Dialect
spring.h2.console.enabled=true # Enabling H2 Console
spring.h2.console.path=/h2 # Custom H2 Console URL

## Hibernate Propiedades
jpa.hibernate.ddl-auto: update # Hibernate ddl auto (create, create-drop, validate, update)
jpa.properties.hibernate.dialect: org.hibernate.dialect.H2Dialect # The SQL dialect makes Hibernate generate better SQL for the chosen database
jpa.generate-ddl: true

```