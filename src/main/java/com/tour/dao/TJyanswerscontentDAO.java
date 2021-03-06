package com.tour.dao;

import com.tour.model.TJyanswerscontent;
import org.hibernate.LockOptions;
import org.hibernate.Query;
import org.hibernate.criterion.Example;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * A data access object (DAO) providing persistence and search support for
 * TJyanswerscontent entities. Transaction control of the save(), update() and
 * delete() operations can directly support Spring container-managed
 * transactions or they can be augmented to handle user-managed Spring
 * transactions. Each of these methods provides additional information for how
 * to configure it for the desired type of transaction control.
 * 
 * @see TJyanswerscontent
 * @author MyEclipse Persistence Tools
 */
@Repository
public class TJyanswerscontentDAO extends BaseHibernateDAOImpl<TJyanswerscontent> {
	private static final Logger log = LoggerFactory
			.getLogger(TJyanswerscontentDAO.class);

	public void save(TJyanswerscontent transientInstance) {
		log.debug("saving TJyanswerscontent instance");
		try {
			getSession().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(TJyanswerscontent persistentInstance) {
		log.debug("deleting TJyanswerscontent instance");
		try {
			getSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public TJyanswerscontent findById(Long id) {
		log.debug("getting TJyanswerscontent instance with id: " + id);
		try {
			TJyanswerscontent instance = (TJyanswerscontent) getSession().get(
					"com.tour.model.TJyanswerscontent", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List findByExample(TJyanswerscontent instance) {
		log.debug("finding TJyanswerscontent instance by example");
		try {
			List results = getSession()
					.createCriteria("com.tour.model.TJyanswerscontent")
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
		log.debug("finding TJyanswerscontent instance with property: "
				+ propertyName + ", value: " + value);
		try {
			String queryString = "from TJyanswerscontent as model where model."
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
		log.debug("finding all TJyanswerscontent instances");
		try {
			String queryString = "from TJyanswerscontent";
			Query queryObject = getSession().createQuery(queryString);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public TJyanswerscontent merge(TJyanswerscontent detachedInstance) {
		log.debug("merging TJyanswerscontent instance");
		try {
			TJyanswerscontent result = (TJyanswerscontent) getSession().merge(
					detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(TJyanswerscontent instance) {
		log.debug("attaching dirty TJyanswerscontent instance");
		try {
			getSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(TJyanswerscontent instance) {
		log.debug("attaching clean TJyanswerscontent instance");
		try {
			getSession().buildLockRequest(LockOptions.NONE).lock(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}
}
