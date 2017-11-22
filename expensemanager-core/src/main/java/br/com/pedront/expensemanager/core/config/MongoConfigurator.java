package br.com.pedront.expensemanager.core.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.config.AbstractMongoConfiguration;

import com.mongodb.Mongo;
import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;

@Configuration
public class MongoConfigurator extends AbstractMongoConfiguration {

    @Value("${MONGODB_URI}")
    private String mongodbUri;

    @Override
    protected String getDatabaseName () {
        return new MongoClientURI(mongodbUri).getDatabase();
    }

    @Override
    public Mongo mongo() throws Exception {
        final String mongodb_uri = System.getProperty("MONGODB_URI", mondoDefaultUri);

        return new MongoClient(new MongoClientURI(mongodbUri));
    }
}
