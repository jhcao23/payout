package technology.touchmars.repository;

import technology.touchmars.model.SimpleProperty;

import javax.ejb.Stateless;
import javax.persistence.Query;
import javax.transaction.Transactional;
import java.util.List;

@Stateless
public class ServiceBean extends SimpleRepository<SimpleProperty>   {

//	@PersistenceContext
//	private EntityManager em;

	public void put(String key, String value){
        SimpleProperty p = new SimpleProperty();
        p.setKey(key);
        p.setSimpleValue(value);
//		em.persist(p);
		this.persist(p);
	}

	@Transactional
	public void delete(SimpleProperty p){

		Query query = getEm().createQuery("delete FROM SimpleProperty p where p.key='"+p.getKey()+"'");

		query.executeUpdate();

	}

	public List<SimpleProperty> findAll(){

		Query query = getEm().createQuery("FROM SimpleProperty");

		List <SimpleProperty> list = query.getResultList();
		return list;

	}

	public SimpleProperty findById(String id){

		SimpleProperty p = findById(id, SimpleProperty.class); //em.find(SimpleProperty.class, id);
		return p;

	}

}