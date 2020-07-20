package technology.touchmars.repository;

import technology.touchmars.model.Currency;
import technology.touchmars.model.SimpleProperty;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;
import java.util.List;

public abstract class SimpleRepository<T> {
    @PersistenceContext
    private EntityManager em;

    public T persist(T t) {
        em.persist(t);
        return t;
    }

    public <B extends T> B findById(Object id, Class<B> clazz) {
        return em.find(clazz, id);
    }

    public <B extends T> B findByUniqueProperty(Class<B> clazz, String propertyName, String propertyValue) {
        String q = String.format("FROM $%s t where t.%s = :%s", clazz.getSimpleName(), propertyName, propertyName);
        Query query = getEm().createQuery(q, clazz);
        query.setParameter(propertyName, propertyValue);
        return (B)query.getSingleResult();
    }

    public <B extends T> List<B> findByProperty(Class<B> clazz, String propertyName, String propertyValue) {
        String q = String.format("FROM $%s t where t.%s = :%s", clazz.getSimpleName(), propertyName, propertyName);
        Query query = getEm().createQuery(q, clazz);
        query.setParameter(propertyName, propertyValue);
        return (List<B>)query.getResultList();
    }

    @Transactional
    public <B extends T> int deleteById(Class<B> clazz, B p, Long id){
        String q = String.format("DELETE FROM %s b where b.id = :id", clazz.getSimpleName());
        Query query = getEm().createQuery(q);
        query.setParameter("id", id);
        return query.executeUpdate();
    }

    public EntityManager getEm() {
        return em;
    }
    public void setEm(EntityManager em) {
        this.em = em;
    }

}