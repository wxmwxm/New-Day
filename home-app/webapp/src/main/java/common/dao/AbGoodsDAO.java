package common.dao;

import common.base.BaseDao;
import common.models.AbGoods;

import java.util.List;
import org.hibernate.LockMode;
import org.hibernate.Query;
import org.hibernate.criterion.Example;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

/**
 * A data access object (DAO) providing persistence and search support for
 * AbGoods entities. Transaction control of the save(), update() and delete()
 * operations can directly support Spring container-managed transactions or they
 * can be augmented to handle user-managed Spring transactions. Each of these
 * methods provides additional information for how to configure it for the
 * desired type of transaction control.
 * 
 * @see common.models.AbGoods
 * @author MyEclipse Persistence Tools
 */
@Repository("abGoodsDAO")
public class AbGoodsDAO extends BaseDao<AbGoods> {
	private static final Logger log = LoggerFactory.getLogger(AbGoodsDAO.class);
	// property constants
	public static final String NAME = "name";
	public static final String EFFECT = "effect";
	public static final String SPEC = "spec";
	public static final String AREA = "area";
	public static final String PACKING = "packing";

	public void save(AbGoods transientInstance) {
		log.debug("saving AbGoods instance");
		try {
			getSession().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(AbGoods persistentInstance) {
		log.debug("deleting AbGoods instance");
		try {
			getSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public AbGoods findById(java.lang.String id) {
		log.debug("getting AbGoods instance with id: " + id);
		try {
			AbGoods instance = (AbGoods) getSession().get("common.AbGoods", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List findByExample(AbGoods instance) {
		log.debug("finding AbGoods instance by example");
		try {
			List results = getSession().createCriteria("common.AbGoods")
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
		log.debug("finding AbGoods instance with property: " + propertyName
				+ ", value: " + value);
		try {
			String queryString = "from AbGoods as model where model."
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

	public List findByEffect(Object effect) {
		return findByProperty(EFFECT, effect);
	}

	public List findBySpec(Object spec) {
		return findByProperty(SPEC, spec);
	}

	public List findByArea(Object area) {
		return findByProperty(AREA, area);
	}

	public List findByPacking(Object packing) {
		return findByProperty(PACKING, packing);
	}

	public List findAll() {
		log.debug("finding all AbGoods instances");
		try {
			String queryString = "from AbGoods";
			Query queryObject = getSession().createQuery(queryString);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public AbGoods merge(AbGoods detachedInstance) {
		log.debug("merging AbGoods instance");
		try {
			AbGoods result = (AbGoods) getSession().merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(AbGoods instance) {
		log.debug("attaching dirty AbGoods instance");
		try {
			getSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(AbGoods instance) {
		log.debug("attaching clean AbGoods instance");
		try {
			getSession().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}
}