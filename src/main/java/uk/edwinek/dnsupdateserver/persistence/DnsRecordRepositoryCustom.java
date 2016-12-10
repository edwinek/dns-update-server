package uk.edwinek.dnsupdateserver.persistence;

import uk.edwinek.dnsupdateserver.model.DnsRecord;

public interface DnsRecordRepositoryCustom {

    void updateIpRecord(DnsRecord ipRecord);
}