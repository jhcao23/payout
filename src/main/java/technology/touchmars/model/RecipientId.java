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


}
