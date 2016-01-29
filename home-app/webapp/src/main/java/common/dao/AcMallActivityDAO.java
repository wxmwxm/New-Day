package common.dao;

import common.base.BaseDao;
import common.models.AcMallActivity;

import java.util.Date;
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
 * AcMallActivity entities. Transaction control of the save(), update() and
 * delete() operations can directly support Spring container-managed
 * transactions or they can be augmented to handle user-managed Spring
 * transactions. Each of these methods provides additional information for how
 * to configure it for the desired type of transaction control.
 * 
 * @see common.models.AcMallActivity
 * @author MyEclipse Persistence Tools
 */
@Repository("acMallActivityDAO")
public class AcMallActivityDAO extends BaseDao<AcMallActivity> {
	private static final Logger log = LoggerFactory
			.getLogger(AcMallActivityDAO.class);
	// property constants
	public static final String TITLE = "title";
	public static final String NAME = "name";
	public static final String DICTCODE = "dictcode";
	public static final String DETAILINFO = "detailinfo";

	public void save(AcMallActivity transientInstance) {
		log.debug("saving AcMallActivity instance");
		try {
			getSession().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(AcMallActivity persistentInstance) {
		log.debug("deleting AcMallActivity instance");
		try {
			getSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public AcMallActivity findById(java.lang.Integer id) {
		log.debug("getting AcMallActivity instance with id: " + id);
		try {
			AcMallActivity instance = (AcMallActivity) getSession().get(
					"common.AcMallActivity", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List findByExample(AcMallActivity instance) {
		log.debug("finding AcMallActivity instance by example");
		try {
			List results = getSession().createCriteria("common.AcMallActivity")
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
		log.debug("finding AcMallActivity instance with property: "
				+ propertyName + ", value: " + value);
		try {
			String queryString = "from AcMallActivity as model where model."
					+ propertyName + "= ?";
			Query queryObject = getSession().createQuery(queryString);
			queryObject.setParameter(0, value);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List findByTitle(Object title) {
		return findByProperty(TITLE, title);
	}

	public List findByName(Object name) {
		return findByProperty(NAME, name);
	}

	public List findByDictcode(Object dictcode) {
		return findByProperty(DICTCODE, dictcode);
	}

	public List findByDetailinfo(Object detailinfo) {
		return findByProperty(DETAILINFO, detailinfo);
	}

	public List findAll() {
		log.debug("finding all AcMallActivity instances");
		try {
			String queryString = "from AcMallActivity";
			Query queryObject = getSession().createQuery(queryString);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public AcMallActivity merge(AcMallActivity detachedInstance) {
		log.debug("merging AcMallActivity instance");
		try {
			AcMallActivity result = (AcMallActivity) getSession().merge(
					detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(AcMallActivity instance) {
		log.debug("attaching dirty AcMallActivity instance");
		try {
			getSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(AcMallActivity instance) {
		log.debug("attaching clean AcMallActivity instance");
		try {
			getSession().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}
}