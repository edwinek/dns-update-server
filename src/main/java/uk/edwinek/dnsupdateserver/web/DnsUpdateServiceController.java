package uk.edwinek.dnsupdateserver.web;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import uk.edwinek.dnsupdateserver.model.DnsRecord;
import uk.edwinek.dnsupdateserver.persistence.DnsRecordRepository;

@RestController
public class DnsUpdateServiceController {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private DnsRecordRepository dnsRecordRepository;

    @RequestMapping(value = "update", method = RequestMethod.POST, produces = "application/json")
    public ResponseEntity<DnsRecord> update(@RequestBody DnsRecord newDnsRecord) {
        logger.info("Attempting to update hostname {}'s IP to {}.", newDnsRecord.getHostName(), newDnsRecord.getIp());
        dnsRecordRepository.updateIpRecord(newDnsRecord);
        return new ResponseEntity<>(newDnsRecord, HttpStatus.OK);
    }

    @RequestMapping(value = "query", method = RequestMethod.GET, produces = "application/json")
    public DnsRecord get(@RequestParam(value="hostName") String hostName) {
        DnsRecord byHostName = dnsRecordRepository.findByHostName(hostName);
        if (byHostName == null) {
            logger.info("No record exists for hostname {}.", hostName);
            return new DnsRecord();
        } else {
            logger.info("Returning IP of {}, for hostname {}.", byHostName.getIp(), hostName);
            return byHostName;
        }
    }

}
