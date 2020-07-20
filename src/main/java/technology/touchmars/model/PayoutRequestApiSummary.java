package technology.touchmars.model;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("api")
public class PayoutRequestApiSummary extends PayoutRequestSummary {

    @Column(name = "sender_bat_id")
    private String senderBatchId;

    @Column(name = "recipient_type")
    private String recipientType;

    public String getSenderBatchId() {
        return senderBatchId;
    }

    public void setSenderBatchId(String senderBatchId) {
        this.senderBatchId = senderBatchId;
    }

    public String getRecipientType() {
        return recipientType;
    }

    public void setRecipientType(String recipientType) {
        this.recipientType = recipientType;
    }
}
