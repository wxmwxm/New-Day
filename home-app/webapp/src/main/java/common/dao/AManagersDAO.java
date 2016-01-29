package common.dao;

import common.base.BaseDao;
import common.models.AManagers;

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
 * AManagers entities. Transaction control of the save(), update() and delete()
 * operations can directly support Spring container-managed transactions or they
 * can be augmented to handle user-managed Spring transactions. Each of these
 * methods provides additional information for how to configure it for the
 * desired type of transaction control.
 * 
 * @see common.models.AManagers
 * @author MyEclipse Persistence Tools
 */
@Repository("aManagersDAO")
public class AManagersDAO extends BaseDao<AManagers> {
	private static final Logger log = LoggerFactory
			.getLogger(AManagersDAO.class);
	// property constants
	public static final String PASSWORD = "password";
	public static final String NAME = "name";

	public void save(AManagers transientInstance) {
		log.debug("saving AManagers instance");
		try {
			getSession().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(AManagers persistentInstance) {
		log.debug("deleting AManagers instance");
		try {
			getSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public AManagers findById(java.lang.String id) {
		log.debug("getting AManagers instance with id: " + id);
		try {
			AManagers instance = (AManagers) getSession().get(
					"common.AManagers", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List findByExample(AManagers instance) {
		log.debug("finding AManagers instance by example");
		try {
			List results = getSession().createCriteria("common.AManagers")
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
		log.debug("finding AManagers instance with property: " + propertyName
				+ ", value: " + value);
		try {
			String queryString = "from AManagers as model where model."
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
		log.debug("finding all AManagers instances");
		try {
			String queryString = "from AManagers";
			Query queryObject = getSession().createQuery(queryString);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public AManagers merge(AManagers detachedInstance) {
		log.debug("merging AManagers instance");
		try {
			AManagers result = (AManagers) getSession().merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(AManagers instance) {
		log.debug("attaching dirty AManagers instance");
		try {
			getSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(AManagers instance) {
		log.debug("attaching clean AManagers instance");
		try {
			getSession().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}
}