package br.com.pedront.expensemanager.core.config;

import static java.util.Collections.singletonList;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.config.AbstractMongoConfiguration;

import com.mongodb.Mongo;
import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;
import com.mongodb.MongoCredential;
import com.mongodb.ServerAddress;

@Configuration
public class MongoConfigurator extends AbstractMongoConfiguration {

    private static final Logger LOGGER = LoggerFactory.getLogger(MongoConfigurator.class);

    @Value("${mongodb.host}")
    private String host;

    @Value("${mongodb.port}")
    private int port;

    @Value("${mongodb.database}")
    private String database;

    @Value("${mongodb.username}")
    private String username;

    @Value("${mongodb.password}")
    private String password;

    @Override
    protected String getDatabaseName() {
        return database;
    }

    @Override
    public Mongo mongo() throws Exception {
        String mongoDBURI = System.getenv("MONGODB_URI");

        MongoClientURI mongoClientURI = null;

        if (mongoDBURI != null) {
            LOGGER.info("Using ENV MONGODB_URI for connection");

            mongoClientURI = new MongoClientURI(mongoDBURI);
        } else {
            LOGGER.info("Using properties for connection");

            return new MongoClient(singletonList(new ServerAddress(host, port)),
                    singletonList(
                            MongoCredential.createCredential(username, database, password.toCharArray())));
        }

        return new MongoClient(mongoClientURI);
    }
}
