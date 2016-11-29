package com.tour.dao;

import com.tour.model.TJyquestionsimage;
import org.hibernate.LockOptions;
import org.hibernate.Query;
import org.hibernate.criterion.Example;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * A data access object (DAO) providing persistence and search support for
 * TJyquestionsimage entities. Transaction control of the save(), update() and
 * delete() operations can directly support Spring container-managed
 * transactions or they can be augmented to handle user-managed Spring
 * transactions. Each of these methods provides additional information for how
 * to configure it for the desired type of transaction control.
 * 
 * @see com.tour.model.TJyquestionsimage
 * @author MyEclipse Persistence Tools
 */
@Repository
public class TJyquestionsimageDAO extends BaseHibernateDAOImpl<TJyquestionsimage> {
	private static final Logger log = LoggerFactory
			.getLogger(TJyquestionsimageDAO.class);

	public void save(TJyquestionsimage transientInstance) {
		log.debug("saving TJyquestionsimage instance");
		try {
			getSession().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(TJyquestionsimage persistentInstance) {
		log.debug("deleting TJyquestionsimage instance");
		try {
			getSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public TJyquestionsimage findById(Long id) {
		log.debug("getting TJyquestionsimage instance with id: " + id);
		try {
			TJyquestionsimage instance = (TJyquestionsimage) getSession().get(
					"com.tour.model.TJyquestionsimage", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List findByExample(TJyquestionsimage instance) {
		log.debug("finding TJyquestionsimage instance by example");
		try {
			List results = getSession()
					.createCriteria("com.tour.model.TJyquestionsimage")
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
		log.debug("finding TJyquestionsimage instance with property: "
				+ propertyName + ", value: " + value);
		try {
			String queryString = "from TJyquestionsimage as model where model."
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
		log.debug("finding all TJyquestionsimage instances");
		try {
			String queryString = "from TJyquestionsimage";
			Query queryObject = getSession().createQuery(queryString);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public TJyquestionsimage merge(TJyquestionsimage detachedInstance) {
		log.debug("merging TJyquestionsimage instance");
		try {
			TJyquestionsimage result = (TJyquestionsimage) getSession().merge(
					detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(TJyquestionsimage instance) {
		log.debug("attaching dirty TJyquestionsimage instance");
		try {
			getSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(TJyquestionsimage instance) {
		log.debug("attaching clean TJyquestionsimage instance");
		try {
			getSession().buildLockRequest(LockOptions.NONE).lock(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}
}
