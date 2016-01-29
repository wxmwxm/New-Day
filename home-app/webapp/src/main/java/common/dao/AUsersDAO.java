package common.dao;

import common.base.BaseDao;
import common.models.AUsers;

import java.util.List;
import org.hibernate.LockMode;
import org.hibernate.Query;
import org.hibernate.criterion.Example;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

/**
 * A data access object (DAO) providing persistence and search support for
 * AUsers entities. Transaction control of the save(), update() and delete()
 * operations can directly support Spring container-managed transactions or they
 * can be augmented to handle user-managed Spring transactions. Each of these
 * methods provides additional information for how to configure it for the
 * desired type of transaction control.
 * 
 * @see common.models.AUsers
 * @author MyEclipse Persistence Tools
 */
@Repository("aUsersDAO")
public class AUsersDAO extends BaseDao<AUsers> {
	private static final Logger log = LoggerFactory.getLogger(AUsersDAO.class);
	// property constants
	public static final String PASSWORD = "password";
	public static final String NAME = "name";

	public void save(AUsers transientInstance) {
		log.debug("saving AUsers instance");
		try {
			getSession().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(AUsers persistentInstance) {
		log.debug("deleting AUsers instance");
		try {
			getSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public AUsers findById(java.lang.String id) {
		log.debug("getting AUsers instance with id: " + id);
		try {
			AUsers instance = (AUsers) getSession().get("common.AUsers", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List findByExample(AUsers instance) {
		log.debug("finding AUsers instance by example");
		try {
			List results = getSession().createCriteria("common.AUsers")
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
		log.debug("finding AUsers instance with property: " + propertyName
				+ ", value: " + value);
		try {
			String queryString = "from AUsers as model where model."
					+ propertyName + "= ?";
			Query queryObject = getSession().createQuery(queryString);
			queryObject.setParameter(0, value);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List findByPassword(Object password) {
		return findByProperty(PASSWORD, password);
	}

	public List findByName(Object name) {
		return findByProperty(NAME, name);
	}

	public List findAll() {
		log.debug("finding all AUsers instances");
		try {
			String queryString = "from AUsers";
			Query queryObject = getSession().createQuery(queryString);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public AUsers merge(AUsers detachedInstance) {
		log.debug("merging AUsers instance");
		try {
			AUsers result = (AUsers) getSession().merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(AUsers instance) {
		log.debug("attaching dirty AUsers instance");
		try {
			getSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(AUsers instance) {
		log.debug("attaching clean AUsers instance");
		try {
			getSession().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}
}