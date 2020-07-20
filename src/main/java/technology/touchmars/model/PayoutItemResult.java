package technology.touchmars.model;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.Instant;

@Entity
@Table(name = "payout_item_result")
public class PayoutItemResult extends HasId {

    @ManyToOne(optional = false, fetch = FetchType.EAGER, targetEntity = PayoutReport.class)
    @JoinColumn(name = "rpt_id", referencedColumnName = "id")
    private PayoutReport payoutReport;

    // without O/R mapping here,
    // assuming result might reside in another folder
    // as not all developers/support should have access to both request and result
    // for this reason, bunch of duplicate values are copied to result as well
    // such as ref_id etc.
    @Column(name = "payout_item_code")
    private String payoutRequestItemCode;

    @Column(name = "ref_id")
    private String refId;

    @Column(name = "tx_id")
    private String txId;

    @Column(name = "recipient_name")
    private String recipientName;

    @Column(name = "paypal_email")
    private String paypalEmail;

    @Column(name = "currency_code")
    private String currencyCode;

    @Column(name = "payout_amt")
    private BigDecimal payoutAmount;

    @Column(name = "payout_fee")
    private BigDecimal payoutFee;

    @Column(name = "payout_total")
    private BigDecimal payoutTotal;

    @Enumerated(EnumType.STRING)
    @Column(name = "tx_status")
    private TransactionStatus txStatus;

    @Column(name = "err_code")
    private String errCode;

    @Column(name = "err_msg")
    private String errMsg;

//    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "ts_processed")
    private Instant timeProcessed;

    @Column(name = "ts_claimed")
    private Instant timeClaimed;

    public PayoutReport getPayoutReport() {
        return payoutReport;
    }

    public void setPayoutReport(PayoutReport payoutReport) {
        this.payoutReport = payoutReport;
    }

    public String getPayoutRequestItemCode() {
        return payoutRequestItemCode;
    }

    public void setPayoutRequestItemCode(String payoutRequestItemCode) {
        this.payoutRequestItemCode = payoutRequestItemCode;
    }

    public String getRefId() {
        return refId;
    }

    public void setRefId(String refId) {
        this.refId = refId;
    }

    public String getTxId() {
        return txId;
    }

    public void setTxId(String txId) {
        this.txId = txId;
    }

    public String getRecipientName() {
        return recipientName;
    }

    public void setRecipientName(String recipientName) {
        this.recipientName = recipientName;
    }

    public String getPaypalEmail() {
        return paypalEmail;
    }

    public void setPaypalEmail(String paypalEmail) {
        this.paypalEmail = paypalEmail;
    }

    public String getCurrencyCode() {
        return currencyCode;
    }

    public void setCurrencyCode(String currencyCode) {
        this.currencyCode = currencyCode;
    }

    public BigDecimal getPayoutAmount() {
        return payoutAmount;
    }

    public void setPayoutAmount(BigDecimal payoutAmount) {
        this.payoutAmount = payoutAmount;
    }

    public BigDecimal getPayoutFee() {
        return payoutFee;
    }

    public void setPayoutFee(BigDecimal payoutFee) {
        this.payoutFee = payoutFee;
    }

    public BigDecimal getPayoutTotal() {
        return payoutTotal;
    }

    public void setPayoutTotal(BigDecimal payoutTotal) {
        this.payoutTotal = payoutTotal;
    }

    public TransactionStatus getTxStatus() {
        return txStatus;
    }

    public void setTxStatus(TransactionStatus txStatus) {
        this.txStatus = txStatus;
    }

    public String getErrCode() {
        return errCode;
    }

    public void setErrCode(String errCode) {
        this.errCode = errCode;
    }

    public String getErrMsg() {
        return errMsg;
    }

    public void setErrMsg(String errMsg) {
        this.errMsg = errMsg;
    }

    public Instant getTimeProcessed() {
        return timeProcessed;
    }

    public void setTimeProcessed(Instant timeProcessed) {
        this.timeProcessed = timeProcessed;
    }

    public Instant getTimeClaimed() {
        return timeClaimed;
    }

    public void setTimeClaimed(Instant timeClaimed) {
        this.timeClaimed = timeClaimed;
    }
}
