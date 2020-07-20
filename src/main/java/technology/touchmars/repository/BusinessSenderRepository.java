package technology.touchmars.repository;

import technology.touchmars.model.BusinessSender;

import javax.ejb.Stateless;

@Stateless
public class BusinessSenderRepository extends SimpleRepository<BusinessSender> {

    public BusinessSender findByPaypalId(String paypalId) {
        return this.findByUniqueProperty(BusinessSender.class, paypalId, paypalId);
    }
}
