package technology.touchmars.model;

import javax.persistence.*;

@Entity
@DiscriminatorValue("api")
public class PayoutRequestApi extends PayoutRequest {

    @OneToOne(cascade= CascadeType.ALL, fetch = FetchType.LAZY, targetEntity = PayoutRequestApiSummary.class, mappedBy = "payoutRequest")
    private PayoutRequestApiSummary summary;

    public PayoutRequestApiSummary getSummary() {
        return summary;
    }
    public void setSummary(PayoutRequestApiSummary summary) {
        this.summary = summary;
    }
}
