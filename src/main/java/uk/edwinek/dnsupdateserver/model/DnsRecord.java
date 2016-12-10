package uk.edwinek.dnsupdateserver.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class DnsRecord extends BaseModel {

    @Id
    private String hostName;
    private String ip;

    public DnsRecord() {}

    public String getHostName() {
        return hostName;
    }

    public String getIp() {
        return ip;
    }
}
