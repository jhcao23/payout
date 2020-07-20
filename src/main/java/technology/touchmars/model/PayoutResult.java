package technology.touchmars.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Enumerated;
import javax.persistence.Table;
import java.time.Instant;

@Entity
@Table(name = "payout_result")
public class PayoutResult extends HasId {

    @Column(name = "payout_batch_id")
    private String payoutBatchCode;

    @Column(name = "created_dt")
    private Instant createdDt;

    @Enumerated
    @Column(name = "batch_status")
    private BatchStatus batchStatus;

    public BatchStatus getBatchStatus() {
        return batchStatus;
    }

    public void setBatchStatus(BatchStatus batchStatus) {
        this.batchStatus = batchStatus;
    }

}
