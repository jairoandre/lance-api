package br.com.vah.lance.api.service;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import br.com.vah.lance.api.service.utils.Filter;

/**
 * A abstract representation of a service, with commons methods.
 * 
 * @author jairo
 *
 * @param <T>
 */
@SuppressWarnings("unchecked")
public abstract class AbstractService<T extends Serializable> {

	@PersistenceContext
	private EntityManager em;

	private Class<T> clazz;

	public AbstractService(Class<T> clazz) {
		this.clazz = clazz;
	}

	/**
	 * Persists the entity in the database.
	 * 
	 * @param entity
	 */
	public T persist(T entity) {
		em.persist(entity);
		em.flush();
		return entity;
	}

	/**
	 * Returns all records for a entity.
	 * 
	 * @param orderBys
	 * @return
	 */
	public List<T> findAll(String... orderBys) {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("select e from " + clazz.getSimpleName() + " e");

		if (orderBys != null && orderBys.length > 0) {
			strBuilder.append(" order by ");
			for (int i = 0; i < orderBys.length; i++) {
				strBuilder.append("e." + orderBys[i]);
				if (i < orderBys.length - 1) {
					strBuilder.append(", ");
				}

			}

		}
		return em.createQuery(strBuilder.toString()).getResultList();
	}

	/**
	 * Load a record by id.
	 * 
	 * @param id
	 * @return
	 */
	public T load(Long id) {
		return em.find(clazz, id);
	}

	/**
	 * Load a record by id.
	 * 
	 * @param id
	 * @return
	 */
	public T load(Integer id) {
		return em.find(clazz, id);
	}
	
	/**
	 * Filter by the given filters
	 * 
	 * @param filters
	 * @return
	 */
	public List<T> filter(Filter... filters) {

		CriteriaBuilder cb = em.getCriteriaBuilder();

		CriteriaQuery<T> query = cb.createQuery(clazz);
		
		Root<T> root = query.from(clazz);
		
		List<Predicate> predicates = new ArrayList<Predicate>();

		for (Filter filter : filters) {
			switch (filter.getType()) {
			case EQ:
				predicates.add(cb.equal(root.get(filter.getProperty()),filter.getFirstParam()));
				break;
			case NE:
				predicates.add(cb.notEqual(root.get(filter.getProperty()),filter.getFirstParam()));
				break;
			case LIKE:
				predicates.add(cb.like(root.get(filter.getProperty()),"%" + String.valueOf(filter.getFirstParam()) + "%"));
				break;
			case LT:
				break;
			case LE:
				break;
			case GT:
				break;
			case GE:
				break;
			case BETWEEN:
				break;
			default:
				break;
			}
		}
		
		if(predicates.size() > 0){
			Predicate o  = cb.and(predicates.toArray(new Predicate[predicates.size()]));
			query.where(o);
		}
		
		return em.createQuery(query).getResultList();
	}
	
	/**
	 * 
	 * @param entity
	 * @return
	 */
	public T remove(Long id) {
		T entity = load(id);
		em.remove(entity);
		em.flush();
		return entity;
	}

}