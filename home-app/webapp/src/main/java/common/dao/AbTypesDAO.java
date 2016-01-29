package common.dao;

import common.base.BaseDao;
import common.models.AbTypes;

import java.util.List;
import org.hibernate.LockMode;
import org.hibernate.Query;
import org.hibernate.criterion.Example;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

/**
 * A data access object (DAO) providing persistence and search support for
 * AbTypes entities. Transaction control of the save(), update() and delete()
 * operations can directly support Spring container-managed transactions or they
 * can be augmented to handle user-managed Spring transactions. Each of these
 * methods provides additional information for how to configure it for the
 * desired type of transaction control.
 * 
 * @see common.models.AbTypes
 * @author MyEclipse Persistence Tools
 */
@Repository("abTypesDAO")
public class AbTypesDAO extends BaseDao<AbTypes> {
	private static final Logger log = LoggerFactory.getLogger(AbTypesDAO.class);
	// property constants
	public static final String PID = "pid";
	public static final String NAME = "name";

	public void save(AbTypes transientInstance) {
		log.debug("saving AbTypes instance");
		try {
			getSession().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(AbTypes persistentInstance) {
		log.debug("deleting AbTypes instance");
		try {
			getSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public AbTypes findById(java.lang.Integer id) {
		log.debug("getting AbTypes instance with id: " + id);
		try {
			AbTypes instance = (AbTypes) getSession().get("common.AbTypes", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List findByExample(AbTypes instance) {
		log.debug("finding AbTypes instance by example");
		try {
			List results = getSession().createCriteria("common.AbTypes")
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
		log.debug("finding AbTypes instance with property: " + propertyName
				+ ", value: " + value);
		try {
			String queryString = "from AbTypes as model where model."
					+ propertyName + "= ?";
			Query queryObject = getSession().createQuery(queryString);
			queryObject.setParameter(0, value);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List findByPid(Object pid) {
		return findByProperty(PID, pid);
	}

	public List findByName(Object name) {
		return findByProperty(NAME, name);
	}

	public List findAll() {
		log.debug("finding all AbTypes instances");
		try {
			String queryString = "from AbTypes";
			Query queryObject = getSession().createQuery(queryString);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public AbTypes merge(AbTypes detachedInstance) {
		log.debug("merging AbTypes instance");
		try {
			AbTypes result = (AbTypes) getSession().merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(AbTypes instance) {
		log.debug("attaching dirty AbTypes instance");
		try {
			getSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(AbTypes instance) {
		log.debug("attaching clean AbTypes instance");
		try {
			getSession().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}
}