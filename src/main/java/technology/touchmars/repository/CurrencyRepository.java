package technology.touchmars.repository;

import technology.touchmars.model.Currency;

import javax.ejb.Stateless;
import javax.persistence.Query;

// in practical, this should be read into a cache database such as Redis
@Stateless
public class CurrencyRepository extends SimpleRepository<Currency> {

    public Currency findByCode(String code) {
        return this.findByUniqueProperty(Currency.class, "code", code);

//        Query query = getEm().createQuery("FROM Currency c where c.code = :code", Currency.class);
//        query.setParameter("code", code);
//        return (Currency)query.getSingleResult();
    }

}
