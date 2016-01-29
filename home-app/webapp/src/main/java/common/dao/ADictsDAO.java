package common.dao;

import common.base.BaseDao;
import common.models.ADicts;

import java.util.List;
import java.util.Set;
import org.hibernate.LockMode;
import org.hibernate.Query;
import org.hibernate.criterion.Example;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

/**
 * A data access object (DAO) providing persistence and search support for
 * ADicts entities. Transaction control of the save(), update() and delete()
 * operations can directly support Spring container-managed transactions or they
 * can be augmented to handle user-managed Spring transactions. Each of these
 * methods provides additional information for how to configure it for the
 * desired type of transaction control.
 * 
 * @see common.models.ADicts
 * @author MyEclipse Persistence Tools
 */
@Repository("aDictsDAO")
public class ADictsDAO extends BaseDao<ADicts> {
	private static final Logger log = LoggerFactory.getLogger(ADictsDAO.class);
	// property constants
	public static final String NAME = "name";
	public static final String DETAILINFO = "detailinfo";

	public void save(ADicts transientInstance) {
		log.debug("saving ADicts instance");
		try {
			getSession().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(ADicts persistentInstance) {
		log.debug("deleting ADicts instance");
		try {
			getSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public ADicts findById(java.lang.String id) {
		log.debug("getting ADicts instance with id: " + id);
		try {
			ADicts instance = (ADicts) getSession().get("common.ADicts", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List findByExample(ADicts instance) {
		log.debug("finding ADicts instance by example");
		try {
			List results = getSession().createCriteria("common.ADicts")
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
		log.debug("finding ADicts instance with property: " + propertyName
				+ ", value: " + value);
		try {
			String queryString = "from ADicts as model where model."
					+ propertyName + "= ?";
			Query queryObject = getSession().createQuery(queryString);
			queryObject.setParameter(0, value);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List findByName(Object name) {
		return findByProperty(NAME, name);
	}

	public List findByDetailinfo(Object detailinfo) {
		return findByProperty(DETAILINFO, detailinfo);
	}

	public List findAll() {
		log.debug("finding all ADicts instances");
		try {
			String queryString = "from ADicts";
			Query queryObject = getSession().createQuery(queryString);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public ADicts merge(ADicts detachedInstance) {
		log.debug("merging ADicts instance");
		try {
			ADicts result = (ADicts) getSession().merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(ADicts instance) {
		log.debug("attaching dirty ADicts instance");
		try {
			getSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(ADicts instance) {
		log.debug("attaching clean ADicts instance");
		try {
			getSession().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}
}