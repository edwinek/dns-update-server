package uk.edwinek.dnsupdateserver.config;

import com.mongodb.Mongo;
import com.mongodb.MongoClient;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.config.AbstractMongoConfiguration;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;
import uk.edwinek.dnsupdateserver.persistence.DnsRecordRepository;

@Configuration
@EnableMongoRepositories(basePackageClasses = {DnsRecordRepository.class})
public class MongoConfig extends AbstractMongoConfiguration {

    @Override
    protected String getDatabaseName() {
        return "DnsRecordRepository";
    }

    @Override
    public Mongo mongo() throws Exception {
        return new MongoClient();
    }

}