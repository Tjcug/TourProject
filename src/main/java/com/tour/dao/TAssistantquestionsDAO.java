package com.tour.dao;

import com.tour.model.TAssistantquestions;
import org.hibernate.LockOptions;
import org.hibernate.Query;
import org.hibernate.criterion.Example;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * A data access object (DAO) providing persistence and search support for
 * TAssistantquestions entities. Transaction control of the save(), update() and
 * delete() operations can directly support Spring container-managed
 * transactions or they can be augmented to handle user-managed Spring
 * transactions. Each of these methods provides additional information for how
 * to configure it for the desired type of transaction control.
 * 
 * @see com.tour.model.TAssistantquestions
 * @author MyEclipse Persistence Tools
 */
@Repository("tAssistantquestionsDAO")
public class TAssistantquestionsDAO extends BaseHibernateDAOImpl<TAssistantquestions> {
	private static final Logger log = LoggerFactory
			.getLogger(TAssistantquestionsDAO.class);
	// property constants
	public static final String CONTENT = "content";
	public static final String STATE = "state";
	public static final String REWARD = "reward";

	public void save(TAssistantquestions transientInstance) {
		log.debug("saving TAssistantquestions instance");
		try {
			getSession().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(TAssistantquestions persistentInstance) {
		log.debug("deleting TAssistantquestions instance");
		try {
			getSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public TAssistantquestions findById(Long id) {
		log.debug("getting TAssistantquestions instance with id: " + id);
		try {
			TAssistantquestions instance = (TAssistantquestions) getSession()
					.get("com.tour.model.TAssistantquestions", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List findByExample(TAssistantquestions instance) {
		log.debug("finding TAssistantquestions instance by example");
		try {
			List results = getSession()
					.createCriteria("com.tour.model.TAssistantquestions")
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
		log.debug("finding TAssistantquestions instance with property: "
				+ propertyName + ", value: " + value);
		try {
			String queryString = "from TAssistantquestions as model where model."
					+ propertyName + "= ?";
			Query queryObject = getSession().createQuery(queryString);
			queryObject.setParameter(0, value);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List findByContent(Object content) {
		return findByProperty(CONTENT, content);
	}

	public List findByState(Object state) {
		return findByProperty(STATE, state);
	}

	public List findByReward(Object reward) {
		return findByProperty(REWARD, reward);
	}

	public List findAll() {
		log.debug("finding all TAssistantquestions instances");
		try {
			String queryString = "from TAssistantquestions";
			Query queryObject = getSession().createQuery(queryString);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public TAssistantquestions merge(TAssistantquestions detachedInstance) {
		log.debug("merging TAssistantquestions instance");
		try {
			TAssistantquestions result = (TAssistantquestions) getSession()
					.merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(TAssistantquestions instance) {
		log.debug("attaching dirty TAssistantquestions instance");
		try {
			getSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(TAssistantquestions instance) {
		log.debug("attaching clean TAssistantquestions instance");
		try {
			getSession().buildLockRequest(LockOptions.NONE).lock(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}
}
