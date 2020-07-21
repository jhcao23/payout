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

    // indicate its draft or officially finalized passing validation
    @Column(name = "official")
    private Boolean official = false;

    public List<PayoutRequestItem> getItems() {
        return items;
    }
    public void setItems(List<PayoutRequestItem> items) {
        this.items = items;
    }

    public Boolean getOfficial() {
        return official;
    }

    public void setOfficial(Boolean official) {
        this.official = official;
    }
}

