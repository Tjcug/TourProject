package com.tour.dao;

import com.tour.model.TUserlocation;
import org.hibernate.LockOptions;
import org.hibernate.Query;
import org.hibernate.criterion.Example;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * A data access object (DAO) providing persistence and search support for
 * TUserlocation entities. Transaction control of the save(), update() and
 * delete() operations can directly support Spring container-managed
 * transactions or they can be augmented to handle user-managed Spring
 * transactions. Each of these methods provides additional information for how
 * to configure it for the desired type of transaction control.
 * 
 * @see TUserlocation
 * @author MyEclipse Persistence Tools
 */
@Repository("tUserlocationDAO")
public class TUserlocationDAO extends BaseHibernateDAOImpl<TUserlocation> {
	private static final Logger log = LoggerFactory
			.getLogger(TUserlocationDAO.class);

	public void save(TUserlocation transientInstance) {
		log.debug("saving TUserlocation instance");
		try {
			getSession().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(TUserlocation persistentInstance) {
		log.debug("deleting TUserlocation instance");
		try {
			getSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public TUserlocation findById(com.tour.model.TUserlocationId id) {
		log.debug("getting TUserlocation instance with id: " + id);
		try {
			TUserlocation instance = (TUserlocation) getSession().get(
					"com.tour.model.TUserlocation", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List findByExample(TUserlocation instance) {
		log.debug("finding TUserlocation instance by example");
		try {
			List results = getSession()
					.createCriteria("com.tour.model.TUserlocation")
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
		log.debug("finding TUserlocation instance with property: "
				+ propertyName + ", value: " + value);
		try {
			String queryString = "from TUserlocation as model where model."
					+ propertyName + "= ?";
			Query queryObject = getSession().createQuery(queryString);
			queryObject.setParameter(0, value);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List findAll() {
		log.debug("finding all TUserlocation instances");
		try {
			String queryString = "from TUserlocation";
			Query queryObject = getSession().createQuery(queryString);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public TUserlocation merge(TUserlocation detachedInstance) {
		log.debug("merging TUserlocation instance");
		try {
			TUserlocation result = (TUserlocation) getSession().merge(
					detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(TUserlocation instance) {
		log.debug("attaching dirty TUserlocation instance");
		try {
			getSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(TUserlocation instance) {
		log.debug("attaching clean TUserlocation instance");
		try {
			getSession().buildLockRequest(LockOptions.NONE).lock(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}
}
