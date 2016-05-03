# ${appName} (${appKey}) installation steps

## Database configuration and initialization

### Launching MongoDB
The application relies on MongoDB, you need to install it and start it before going deeper.
```sh
mongod --dbpath <your_db_path>
```

### Importing initial data in MongoDB
Open a new terminal in the _database folder and type the following command:
```sh
mongoimport --db ${databaseName} -c ${collectionName} --jsonArray --file init.json --drop
```

### Creating indexes using Mongo shell
Open a new terminal in the _database folder and type the following command:

```sh
mongo ${databaseName} functions.js --shell
```

Once connected to the MongoDB, type the following command:
```sh
createIndexes();
```

## Building the application with Maven
Building the application is straightforward. In the application folder type:
```sh
mvn clean install
```

## Launching the application

### using the spring-boot maven plugin
```sh
mvn spring-boot:run -Dspring.profiles.active=DEV
```

### using the built JAR file
```sh
cd target
java -Dspring.profiles.active=DEV -jar *.war
```

## Checking the application
Once the application has been started, you can test it by clicking[this link](http://localhost:${serverPort}${contextPath}/swagger-ui.html)
