package sood.gourav.config;

import com.mongodb.MongoClient;
import com.mongodb.MongoCredential;
import com.mongodb.ServerAddress;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.autoconfigure.mongo.MongoProperties;
import org.springframework.cloud.config.java.AbstractCloudConfig;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.data.mongodb.MongoDbFactory;
import org.springframework.data.mongodb.core.SimpleMongoDbFactory;

import javax.inject.Inject;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by gouravsood on 1/01/2016.
 */
@Configuration
@Profile(Constants.SPRING_PROFILE_CLOUD)
public class CloudDatabaseConfiguration extends AbstractCloudConfig {

    private final Logger log = LoggerFactory.getLogger(CloudDatabaseConfiguration.class);

    @Inject
    private MongoProperties mongoProperties;

    @Bean
    public MongoDbFactory mongoDbFactory() throws Exception {

        //TODO Need to check how to avoid the dupicate MongoDB initiation

        ServerAddress addr = new ServerAddress(mongoProperties.getHost(), mongoProperties.getPort());
        MongoCredential mongoCredential = MongoCredential.createMongoCRCredential(
                mongoProperties.getUsername(),
                mongoProperties.getDatabase(),
                mongoProperties.getPassword());

        List<MongoCredential> credentialsList = new ArrayList<MongoCredential>();
        credentialsList.add(mongoCredential);

        return new SimpleMongoDbFactory(new MongoClient(addr, credentialsList),
                mongoProperties.getDatabase());
    }
}
