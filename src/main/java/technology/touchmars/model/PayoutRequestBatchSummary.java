package technology.touchmars.model;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@DiscriminatorValue("batch")
public class PayoutRequestBatchSummary extends PayoutRequestSummary {

    @Column(name = "total_amt")
    private BigDecimal total;

    @ManyToOne(optional = false, fetch = FetchType.EAGER, targetEntity = Currency.class)
    @JoinColumn(name = "currency_id", referencedColumnName = "id")
    private Currency currency;

    @Column(name = "num_items")
    private Integer count;

    public BigDecimal getTotal() {
        return total;
    }

    public void setTotal(BigDecimal total) {
        this.total = total;
    }

    public Currency getCurrency() {
        return currency;
    }

    public void setCurrency(Currency currency) {
        this.currency = currency;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

}
