package technology.touchmars.api.pojo;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.math.BigDecimal;

@XmlRootElement
public class ApiPayoutRequest {

    @XmlElement(name = "sender_batch_header")
    SenderBatchHeader senderBatchHeader;
    Item[] items;

    public class SenderBatchHeader {
        @XmlAttribute(name = "sender_batch_id")
        String senderBatchId;
        @XmlAttribute(name = "email_subject")
        String emailSubject;
        @XmlAttribute(name = "email_message", required = false)
        String emailMessage;
    }

    public class Item {

        @XmlAttribute(name = "recipient_type")
        String recipientType;

        Amount amount;
        String note;

        @XmlAttribute(name = "sender_item_id")
        String senderItemId;
        String receiver;

    }

    public class Amount {
        String currency;
        BigDecimal value;
    }

}
