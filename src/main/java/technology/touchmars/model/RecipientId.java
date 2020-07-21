package technology.touchmars.model;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Embedded;

@Embeddable
public class RecipientId {

    @Column(name = "email")
    private String email;

    @Embedded
    private Mobile mobile;

    @Column(name = "pp_id")
    private String paypalId; //paypal account id

    @Column(name = "venmo_id")
    private String venmoId;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Mobile getMobile() {
        return mobile;
    }

    public void setMobile(Mobile mobile) {
        this.mobile = mobile;
    }

    public String getPaypalId() {
        return paypalId;
    }

    public void setPaypalId(String paypalId) {
        this.paypalId = paypalId;
    }

    public String getVenmoId() {
        return venmoId;
    }

    public void setVenmoId(String venmoId) {
        this.venmoId = venmoId;
    }
}
