package common.dao;

import common.base.BaseDao;
import common.models.AFiles;

import java.util.List;
import org.hibernate.LockMode;
import org.hibernate.Query;
import org.hibernate.criterion.Example;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

/**
 * A data access object (DAO) providing persistence and search support for
 * AFiles entities. Transaction control of the save(), update() and delete()
 * operations can directly support Spring container-managed transactions or they
 * can be augmented to handle user-managed Spring transactions. Each of these
 * methods provides additional information for how to configure it for the
 * desired type of transaction control.
 * 
 * @see common.AFiles
 * @author MyEclipse Persistence Tools
 */
@Repository("aFilesDAO")
public class AFilesDAO extends BaseDao<AFiles> {
	private static final Logger log = LoggerFactory.getLogger(AFilesDAO.class);
	// property constants
	public static final String FILENAME = "filename";
	public static final String DIR = "dir";
	public static final String TYPE = "type";

	public void save(AFiles transientInstance) {
		log.debug("saving AFiles instance");
		try {
			getSession().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(AFiles persistentInstance) {
		log.debug("deleting AFiles instance");
		try {
			getSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public AFiles findById(java.lang.String id) {
		log.debug("getting AFiles instance with id: " + id);
		try {
			AFiles instance = (AFiles) getSession().get("common.AFiles", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List findByExample(AFiles instance) {
		log.debug("finding AFiles instance by example");
		try {
			List results = getSession().createCriteria("common.AFiles")
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
		log.debug("finding AFiles instance with property: " + propertyName
				+ ", value: " + value);
		try {
			String queryString = "from AFiles as model where model."
					+ propertyName + "= ?";
			Query queryObject = getSession().createQuery(queryString);
			queryObject.setParameter(0, value);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List findByFilename(Object filename) {
		return findByProperty(FILENAME, filename);
	}

	public List findByDir(Object dir) {
		return findByProperty(DIR, dir);
	}

	public List findByType(Object type) {
		return findByProperty(TYPE, type);
	}

	public List findAll() {
		log.debug("finding all AFiles instances");
		try {
			String queryString = "from AFiles";
			Query queryObject = getSession().createQuery(queryString);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public AFiles merge(AFiles detachedInstance) {
		log.debug("merging AFiles instance");
		try {
			AFiles result = (AFiles) getSession().merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(AFiles instance) {
		log.debug("attaching dirty AFiles instance");
		try {
			getSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(AFiles instance) {
		log.debug("attaching clean AFiles instance");
		try {
			getSession().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}
}