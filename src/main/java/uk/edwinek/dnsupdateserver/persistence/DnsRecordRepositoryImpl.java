package uk.edwinek.dnsupdateserver.persistence;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import uk.edwinek.dnsupdateserver.model.DnsRecord;

public class DnsRecordRepositoryImpl implements DnsRecordRepositoryCustom {

    @Autowired
    private MongoOperations mongoOperations;

    @Override
    public void updateIpRecord(DnsRecord ipRecord) {
        Query query = new Query();
        query.addCriteria(Criteria.where("hostName").is(ipRecord.getHostName()));

        Update update = new Update();
        update.set("ip", ipRecord.getIp());

        mongoOperations.upsert(query, update, DnsRecord.class);

    }

}
