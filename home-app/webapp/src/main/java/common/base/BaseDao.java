package common.base;

import java.util.List;
import java.util.Map;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

public class BaseDao<T> {
	@Autowired
	private SessionFactory sessionFactory;

	/**
	 * 获得当前事物的session
	 * 
	 * @return org.hibernate.Session
	 */
	public Session getSession() {
		return sessionFactory.getCurrentSession();
	}

	/**
	 * 获得对象列表
	 * 
	 * @param HQL语句
	 * @return List<T>
	 */
	public List<T> find(String hql) {
		Query q = this.getSession().createQuery(hql);
		return q.list();
	}

	/**
	 * 通过HQL语句获取一个对象
	 * 
	 * @param HQL语句
	 * @return 对象
	 */
	public T get(String hql) {
		Query q = this.getSession().createQuery(hql);
		List<T> l = q.list();
		if (l != null && l.size() > 0) {
			return l.get(0);
		}
		return null;
	}

	/**
	 * 通过HQL语句获取一个对象
	 * 
	 * @param HQL语句
	 * @param params
	 *            参数
	 * @return 对象
	 */
	public T get(String hql, Map<String, Object> params) {
		List<T> l = find(hql,params);
		if (l != null && l.size() > 0) {
			return l.get(0);
		}
		return null;
	}

	/**
	 * 获得对象列表
	 * 
	 * @param HQL语句
	 * @param params
	 *            参数
	 * @return List
	 */
	public List<T> find(String hql, Map<String, Object> params) {
		Query q = this.getSession().createQuery(hql);
		if (params != null && !params.isEmpty()) {
			for (String key : params.keySet()) {
				q.setParameter(key, params.get(key));
			}
		}
		return q.list();
	}
	/**
	 * 获得分页后的对象列表
	 * 
	 * @param HQL语句
	 * @param page
	 *            要显示第几页
	 * @param rows
	 *            每页显示多少条
	 * @return List
	 */
	public List<T> findByPage(String hql, int page,int rows) {
		return findByPage(hql, page, rows, null);
	}
	/**
	 * 获得分页后的对象列表
	 * 
	 * @param HQL语句
	 * @param page
	 *            要显示第几页
	 * @param rows
	 *            每页显示多少条
	 * @param params
	 *            参数
	 * @return List
	 */
	@SuppressWarnings("unchecked")
	public List<T> findByPage(String hql, int page,int rows, Map<String, Object> params) {
		Query q = this.getSession().createQuery(hql);
		if (params != null && !params.isEmpty()) {
			for (String key : params.keySet()) {
				q.setParameter(key, params.get(key));
			}
		}
		if (page == 0 && rows == 0) {
			return find(hql);
		}
		return q.setFirstResult((page - 1) * rows).setMaxResults(rows).list();
	}
	

	/**
	 * 统计数目
	 * 
	 * @param HQL语句
	 *            (select count(*) from T)
	 * @return long
	 */
	public Long count(String hql) {
		return count(hql,null);
	}

	/**
	 * 统计数目
	 * 
	 * @param HQL语句
	 *            (select count(*) from T where xx = :xx)
	 * @param params
	 *            参数
	 * @return long
	 */
	public Long count(String hql, Map<String, Object> params) {
		Query q = this.getSession().createQuery(hql);
		if (params != null && !params.isEmpty()) {
			for (String key : params.keySet()) {
				q.setParameter(key, params.get(key));
			}
		}
		return (Long) q.uniqueResult();
	}

	/**
	 * 执行一条HQL语句
	 * 
	 * @param HQL语句
	 * @return 响应结果数目
	 */
	public int executeHql(String hql) {
		return executeHql(hql,null);
	}

	/**
	 * 执行一条HQL语句
	 * 
	 * @param HQL语句
	 * @param params
	 *            参数
	 * @return 响应结果数目
	 */
	public int executeHql(String hql, Map<String, Object> params) {
		Query q = this.getSession().createQuery(hql);
		if (params != null && !params.isEmpty()) {
			for (String key : params.keySet()) {
				q.setParameter(key, params.get(key));
			}
		}
		return q.executeUpdate();
	}

}
