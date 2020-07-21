package technology.touchmars.api.pojo;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;


@XmlRootElement
public class ApiPayoutResponse {

    @XmlElement(name = "sender_batch_header")
    ApiPayoutRequest.SenderBatchHeader senderBatchHeader;

    @XmlAttribute(name = "payout_batch_id")
    String payoutBatchId;

    @XmlAttribute(name = "batch_status")
    String batchStatus;
}
