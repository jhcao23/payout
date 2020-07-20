package technology.touchmars.model;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name = "payout_req_item")
public class PayoutRequestItem extends HasId {

    @Column(name = "payout_item_code", unique = true)
    private String payoutRequestItemCode;

    @Enumerated(EnumType.STRING)
    private WalletType walletType;

    @Column(name = "amt")
    private BigDecimal amount;

    @Column(name = "ref_id", unique = true)
    private String customerId;

    @Column(name="note", length = 400)
    private String note;

    @Column(name = "lang")
    private String language;

    @ManyToOne(optional = false, fetch = FetchType.EAGER, targetEntity = Currency.class)
    @JoinColumn(name = "currency_id", referencedColumnName = "id")
    private Currency currency;

    @Embedded
    private RecipientId recipientId;

    @ManyToOne(cascade = CascadeType.PERSIST, optional = false, fetch = FetchType.LAZY, targetEntity = PayoutRequest.class)
    @JoinColumn(name = "payout_request_id", referencedColumnName = "id")
    private PayoutRequest payoutRequest;

    public WalletType getWalletType() {
        return walletType;
    }

    public void setWalletType(WalletType walletType) {
        this.walletType = walletType;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public Currency getCurrency() {
        return currency;
    }

    public void setCurrency(Currency currency) {
        this.currency = currency;
    }

    public RecipientId getRecipientId() {
        return recipientId;
    }

    public void setRecipientId(RecipientId recipientId) {
        this.recipientId = recipientId;
    }

    public PayoutRequest getPayoutRequest() {
        return payoutRequest;
    }

    public void setPayoutRequest(PayoutRequest payoutRequest) {
        this.payoutRequest = payoutRequest;
    }

    public String getPayoutRequestItemCode() {
        return payoutRequestItemCode;
    }

    public void setPayoutRequestItemCode(String payoutRequestItemCode) {
        this.payoutRequestItemCode = payoutRequestItemCode;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }
}
