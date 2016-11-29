package com.tour.dao;

import com.tour.model.TReplay;
import org.hibernate.LockOptions;
import org.hibernate.Query;
import org.hibernate.criterion.Example;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * A data access object (DAO) providing persistence and search support for
 * TReplay entities. Transaction control of the save(), update() and delete()
 * operations can directly support Spring container-managed transactions or they
 * can be augmented to handle user-managed Spring transactions. Each of these
 * methods provides additional information for how to configure it for the
 * desired type of transaction control.
 * 
 * @see TReplay
 * @author MyEclipse Persistence Tools
 */
@Repository
public class TReplayDAO extends BaseHibernateDAOImpl<TReplay> {
	private static final Logger log = LoggerFactory.getLogger(TReplayDAO.class);

	public void save(TReplay transientInstance) {
		log.debug("saving TReplay instance");
		try {
			getSession().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(TReplay persistentInstance) {
		log.debug("deleting TReplay instance");
		try {
			getSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public TReplay findById(Long id) {
		log.debug("getting TReplay instance with id: " + id);
		try {
			TReplay instance = (TReplay) getSession().get(
					"com.tour.model.TReplay", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List findByExample(TReplay instance) {
		log.debug("finding TReplay instance by example");
		try {
			List results = getSession()
					.createCriteria("com.tour.model.TReplay")
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
		log.debug("finding TReplay instance with property: " + propertyName
				+ ", value: " + value);
		try {
			String queryString = "from TReplay as model where model."
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
		log.debug("finding all TReplay instances");
		try {
			String queryString = "from TReplay";
			Query queryObject = getSession().createQuery(queryString);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public TReplay merge(TReplay detachedInstance) {
		log.debug("merging TReplay instance");
		try {
			TReplay result = (TReplay) getSession().merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(TReplay instance) {
		log.debug("attaching dirty TReplay instance");
		try {
			getSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(TReplay instance) {
		log.debug("attaching clean TReplay instance");
		try {
			getSession().buildLockRequest(LockOptions.NONE).lock(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}
}
