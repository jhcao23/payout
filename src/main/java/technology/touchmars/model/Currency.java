package technology.touchmars.model;

import javax.persistence.Column;
import javax.persistence.Entity;

/**
 * currency code should be loaded into cache system such as Redis, when app starts.
 */
@Entity
public class Currency extends HasId {

    @Column(length = 3, name = "code", unique = true)
    private String code;

    // a currency might be disabled for some reason
    @Column(name = "active")
    private Boolean active = true;

    public String getCode() {
        return code;
    }
    public void setCode(String code) {
        this.code = code;
    }

    public Boolean getActive() {
        return active;
    }
    public void setActive(Boolean active) {
        this.active = active;
    }
}
