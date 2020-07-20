package technology.touchmars.model;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class Mobile implements Serializable {

    @Column(name = "phone_no")
    private String phoneNo;
    @Column(name = "phone_country_code")
    private Integer countryCode;

    public String getPhoneNo() {
        return phoneNo;
    }
    public void setPhoneNo(String phoneNo) {
        this.phoneNo = phoneNo;
    }
    public Integer getCountryCode() {
        return countryCode;
    }
    public void setCountryCode(Integer countryCode) {
        this.countryCode = countryCode;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Mobile mobile = (Mobile) o;
        return Objects.equals(phoneNo, mobile.phoneNo) &&
                Objects.equals(countryCode, mobile.countryCode);
    }

    @Override
    public int hashCode() {
        return Objects.hash(phoneNo, countryCode);
    }
}
