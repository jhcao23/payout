package technology.touchmars.model;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("web")
public class PayoutRequestWeb extends PayoutRequest {
}
