package technology.touchmars.model;

import javax.persistence.*;

@Entity
@DiscriminatorValue("batch")
public class PayoutRequestBatch extends PayoutRequest {

    @OneToOne(cascade= CascadeType.ALL, fetch = FetchType.LAZY, targetEntity = PayoutRequestBatchSummary.class, mappedBy = "payoutRequest")
    private PayoutRequestBatchSummary summary;

    public PayoutRequestBatchSummary getSummary() {
        return summary;
    }
    public void setSummary(PayoutRequestBatchSummary summary) {
        this.summary = summary;
    }

}
