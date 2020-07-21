package technology.touchmars.service;

import technology.touchmars.model.PayoutRequest;
import technology.touchmars.model.PayoutRequestWeb;
import technology.touchmars.repository.PayoutRequestWebRepository;

import javax.ejb.Local;
import javax.ejb.Stateless;
import javax.inject.Inject;

@Stateless
public class PayoutRequestService {
    @Inject
    PayoutRequestWebRepository payoutRequestWebRepository;

    public PayoutRequestWeb persistPayoutRequestWeb(PayoutRequestWeb payoutRequestWeb){
        return payoutRequestWebRepository.persist(payoutRequestWeb);
    }

}
