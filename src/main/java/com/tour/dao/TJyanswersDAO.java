package com.tour.dao;

import com.tour.model.TJyanswers;
import org.hibernate.LockOptions;
import org.hibernate.Query;
import org.hibernate.criterion.Example;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * A data access object (DAO) providing persistence and search support for
 * TJyanswers entities. Transaction control of the save(), update() and delete()
 * operations can directly support Spring container-managed transactions or they
 * can be augmented to handle user-managed Spring transactions. Each of these
 * methods provides additional information for how to configure it for the
 * desired type of transaction control.
 * 
 * @see com.tour.model.TJyanswers
 * @author MyEclipse Persistence Tools
 */
@Repository
public class TJyanswersDAO extends BaseHibernateDAOImpl<TJyanswers> {
	private static final Logger log = LoggerFactory
			.getLogger(TJyanswersDAO.class);

	public void save(TJyanswers transientInstance) {
		log.debug("saving TJyanswers instance");
		try {
			getSession().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(TJyanswers persistentInstance) {
		log.debug("deleting TJyanswers instance");
		try {
			getSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public TJyanswers findById(Long id) {
		log.debug("getting TJyanswers instance with id: " + id);
		try {
			TJyanswers instance = (TJyanswers) getSession().get(
					"com.tour.model.TJyanswers", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List findByExample(TJyanswers instance) {
		log.debug("finding TJyanswers instance by example");
		try {
			List results = getSession()
					.createCriteria("com.tour.model.TJyanswers")
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
		log.debug("finding TJyanswers instance with property: " + propertyName
				+ ", value: " + value);
		try {
			String queryString = "from TJyanswers as model where model."
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
		log.debug("finding all TJyanswers instances");
		try {
			String queryString = "from TJyanswers";
			Query queryObject = getSession().createQuery(queryString);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public TJyanswers merge(TJyanswers detachedInstance) {
		log.debug("merging TJyanswers instance");
		try {
			TJyanswers result = (TJyanswers) getSession().merge(
					detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(TJyanswers instance) {
		log.debug("attaching dirty TJyanswers instance");
		try {
			getSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(TJyanswers instance) {
		log.debug("attaching clean TJyanswers instance");
		try {
			getSession().buildLockRequest(LockOptions.NONE).lock(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}
}
