package technology.touchmars.model;

import javax.persistence.*;
import java.time.Instant;

@Entity
@Table(name = "payout_rpt")
public class PayoutReport extends HasId {

    @ManyToOne(optional = false, fetch = FetchType.EAGER, targetEntity = PayoutRequest.class)
    @JoinColumn(name = "payout_req_id", referencedColumnName = "id")
    private PayoutRequest payoutRequest;

    @Column(name = "filename")
    private String filename;

    // numbers are good for comparison.
    // 90% confident this value won't be changed in future,
    // however, considering partitioning on historical records
    // using STRING is better - esp. when adding a new STAGE many years later.
    @Enumerated(EnumType.ORDINAL)
    private ReportStage reportStage;

    @Column(name = "note")
    private String note;

    @Column(name = "created_dt")
    private Instant createdDt;

    public String getFilename() {
        return filename;
    }

    public void setFilename(String filename) {
        this.filename = filename;
    }

    public ReportStage getReportStage() {
        return reportStage;
    }

    public void setReportStage(ReportStage reportStage) {
        this.reportStage = reportStage;
    }

    public Instant getCreatedDt() {
        return createdDt;
    }

    public void setCreatedDt(Instant createdDt) {
        this.createdDt = createdDt;
    }

    public PayoutRequest getPayoutRequest() {
        return payoutRequest;
    }

    public void setPayoutRequest(PayoutRequest payoutRequest) {
        this.payoutRequest = payoutRequest;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }
}
