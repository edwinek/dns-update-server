package uk.edwinek.dnsupdateserver.persistence;

import org.springframework.data.mongodb.repository.MongoRepository;
import uk.edwinek.dnsupdateserver.model.DnsRecord;

public interface DnsRecordRepository extends MongoRepository<DnsRecord, String>, DnsRecordRepositoryCustom {

    DnsRecord findByHostName(String hostName);
}