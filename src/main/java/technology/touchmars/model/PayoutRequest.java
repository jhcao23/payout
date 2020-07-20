package technology.touchmars.model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "payout_request")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "req_type")
public abstract class PayoutRequest extends HasId {

    @OneToMany(cascade=CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "payoutRequest")
    private List<PayoutRequestItem> items =  new ArrayList<>();

    public List<PayoutRequestItem> getItems() {
        return items;
    }
    public void setItems(List<PayoutRequestItem> items) {
        this.items = items;
    }

}

