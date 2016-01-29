package common.dao;

import common.base.BaseDao;
import common.models.AcMallActivityGoods;

import java.util.Date;
import java.util.List;
import org.hibernate.LockMode;
import org.hibernate.Query;
import org.hibernate.criterion.Example;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

/**
 * A data access object (DAO) providing persistence and search support for
 * AcMallActivityGoods entities. Transaction control of the save(), update() and
 * delete() operations can directly support Spring container-managed
 * transactions or they can be augmented to handle user-managed Spring
 * transactions. Each of these methods provides additional information for how
 * to configure it for the desired type of transaction control.
 * 
 * @see common.models.AcMallActivityGoods
 * @author MyEclipse Persistence Tools
 */
@Repository("acMallActivityGoodsDAO")
public class AcMallActivityGoodsDAO extends BaseDao<AcMallActivityGoods> {
	private static final Logger log = LoggerFactory
			.getLogger(AcMallActivityGoodsDAO.class);
	// property constants
	public static final String STATE = "state";

	public void save(AcMallActivityGoods transientInstance) {
		log.debug("saving AcMallActivityGoods instance");
		try {
			getSession().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(AcMallActivityGoods persistentInstance) {
		log.debug("deleting AcMallActivityGoods instance");
		try {
			getSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public AcMallActivityGoods findById(java.lang.Integer id) {
		log.debug("getting AcMallActivityGoods instance with id: " + id);
		try {
			AcMallActivityGoods instance = (AcMallActivityGoods) getSession()
					.get("common.AcMallActivityGoods", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List findByExample(AcMallActivityGoods instance) {
		log.debug("finding AcMallActivityGoods instance by example");
		try {
			List results = getSession()
					.createCriteria("common.AcMallActivityGoods")
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
		log.debug("finding AcMallActivityGoods instance with property: "
				+ propertyName + ", value: " + value);
		try {
			String queryString = "from AcMallActivityGoods as model where model."
					+ propertyName + "= ?";
			Query queryObject = getSession().createQuery(queryString);
			queryObject.setParameter(0, value);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List findByState(Object state) {
		return findByProperty(STATE, state);
	}

	public List findAll() {
		log.debug("finding all AcMallActivityGoods instances");
		try {
			String queryString = "from AcMallActivityGoods";
			Query queryObject = getSession().createQuery(queryString);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public AcMallActivityGoods merge(AcMallActivityGoods detachedInstance) {
		log.debug("merging AcMallActivityGoods instance");
		try {
			AcMallActivityGoods result = (AcMallActivityGoods) getSession()
					.merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(AcMallActivityGoods instance) {
		log.debug("attaching dirty AcMallActivityGoods instance");
		try {
			getSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(AcMallActivityGoods instance) {
		log.debug("attaching clean AcMallActivityGoods instance");
		try {
			getSession().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}
}