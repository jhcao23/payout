package technology.touchmars.model;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name = "payout_req_sum")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "sum_type")
public abstract class PayoutRequestSummary extends HasId {

    @Column(name = "email_sub", length = 256)
    private String emailSubject;

    @Column(name = "email_txt", length = 100)
    private String emailContent;

    @ManyToOne(optional = false, fetch = FetchType.LAZY, targetEntity = PayoutRequest.class)
    @JoinColumn(name = "payout_request_id", referencedColumnName = "id")
    private PayoutRequest payoutRequest;

    public String getEmailSubject() {
        return emailSubject;
    }

    public void setEmailSubject(String emailSubject) {
        this.emailSubject = emailSubject;
    }

    public String getEmailContent() {
        return emailContent;
    }

    public void setEmailContent(String emailContent) {
        this.emailContent = emailContent;
    }

    public PayoutRequest getPayoutRequest() {
        return payoutRequest;
    }

    public void setPayoutRequest(PayoutRequest payoutRequest) {
        this.payoutRequest = payoutRequest;
    }
}
