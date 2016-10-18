package com.tour.dao;

import com.tour.model.TOrder;
import org.hibernate.LockOptions;
import org.hibernate.Query;
import org.hibernate.criterion.Example;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * A data access object (DAO) providing persistence and search support for
 * TOrder entities. Transaction control of the save(), update() and delete()
 * operations can directly support Spring container-managed transactions or they
 * can be augmented to handle user-managed Spring transactions. Each of these
 * methods provides additional information for how to configure it for the
 * desired type of transaction control.
 * 
 * @see com.tour.model.TOrder
 * @author MyEclipse Persistence Tools
 */
@Repository("tOrderDAO")
public class TOrderDAO extends BaseHibernateDAOImpl<TOrder> {
	private static final Logger log = LoggerFactory.getLogger(TOrderDAO.class);
	// property constants
	public static final String TYPE = "type";
	public static final String ASSISTANT_ID = "assistantId";
	public static final String PRICE = "price";
	public static final String STATE = "state";

	public void save(TOrder transientInstance) {
		log.debug("saving TOrder instance");
		try {
			getSession().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(TOrder persistentInstance) {
		log.debug("deleting TOrder instance");
		try {
			getSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public TOrder findById(Long id) {
		log.debug("getting TOrder instance with id: " + id);
		try {
			TOrder instance = (TOrder) getSession().get(
					"com.tour.model.TOrder", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List findByExample(TOrder instance) {
		log.debug("finding TOrder instance by example");
		try {
			List results = getSession().createCriteria("com.tour.model.TOrder")
					.add(Example.create(instance)).list();
			log.debug("find by example successful, result size: "
					+ results.size());
			return results;
		} catch (RuntimeException re) {
			log.error("find by example failed", re);
			throw re;
		}
	}

	public List findByProperty(String propertyName, Object value) {
		log.debug("finding TOrder instance with property: " + propertyName
				+ ", value: " + value);
		try {
			String queryString = "from TOrder as model where model."
					+ propertyName + "= ?";
			Query queryObject = getSession().createQuery(queryString);
			queryObject.setParameter(0, value);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List findByType(Object type) {
		return findByProperty(TYPE, type);
	}

	public List findByAssistantId(Object assistantId) {
		return findByProperty(ASSISTANT_ID, assistantId);
	}

	public List findByPrice(Object price) {
		return findByProperty(PRICE, price);
	}

	public List findByState(Object state) {
		return findByProperty(STATE, state);
	}

	public List findAll() {
		log.debug("finding all TOrder instances");
		try {
			String queryString = "from TOrder";
			Query queryObject = getSession().createQuery(queryString);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public TOrder merge(TOrder detachedInstance) {
		log.debug("merging TOrder instance");
		try {
			TOrder result = (TOrder) getSession().merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(TOrder instance) {
		log.debug("attaching dirty TOrder instance");
		try {
			getSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(TOrder instance) {
		log.debug("attaching clean TOrder instance");
		try {
			getSession().buildLockRequest(LockOptions.NONE).lock(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}
}
