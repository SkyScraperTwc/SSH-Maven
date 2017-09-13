package indi.twc.spring.struts.utils;
 
import indi.twc.spring.struts.beans.User;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class HibernateUtils {
	
	@Autowired
	private SessionFactory sessionFactory;

	public boolean save(User user) {
		Session session = null; 
		Transaction tran = null;  
		boolean result = false;       
		try {  
			session = sessionFactory.getCurrentSession();
			tran = session.beginTransaction();  
			session.save(user);
			tran.commit();
			result = true;  
		} catch (Exception e) {
			if (tran != null) {  
				tran.rollback();
			} 
		}   
		return result;
	}

	public  boolean update(Object object) {
		Session session = null;
		Transaction tran = null;
		boolean result = false;
		try {
			session = sessionFactory.getCurrentSession(); 
			tran = session.beginTransaction();
			session.update(object);  
			tran.commit();
			result = true;
		} catch (Exception e) {
			if (tran != null) {
				tran.rollback();
			} 
		}  
		return result;
	}

	public Object get(Class c, int obj) {
		Session session = null;
		Transaction tran = null;
		Object object = null;
		try {
			session = sessionFactory.getCurrentSession(); 
			tran = session.beginTransaction();
			object = session.get(c, obj);
			tran.commit(); 
		} catch (Exception e) {
			if (tran != null) {
				tran.rollback();
			} 
		} 
		return object;
	}

	public boolean delete(Object obj) {
		Session session = null;
		Transaction tran = null;
		boolean result = false;
		try {
			session = sessionFactory.getCurrentSession(); 
			tran = session.beginTransaction();
			session.delete(obj);
			tran.commit();
			result = true;
		} catch (Exception e) {
			if (tran != null) {
				tran.rollback();
			}
		}  
		return result;
	}

	public <T> List<T> queryList(String hql, Object[] param) {
		List<T> list = new ArrayList<T>();
		Session session = null;
		Transaction tran = null;
		try {  
			session = sessionFactory.getCurrentSession();
			tran = session.beginTransaction();
			Query query = session.createQuery(hql);
			if (null != param && param.length > 0) {
				for (int i = 0; i < param.length; i++) {
					query.setParameter(i, param[i]);
				}
			}
			list = query.list();
			tran.commit();
		} catch (Exception e) {
			if (tran != null) {
				tran.rollback();
			}
		} 
		return list;
	}

	public Object queryOne(String hql, Object[] param) {
		Object object = null;
		Session session = null;
		Transaction tran = null;
		try {
			session = sessionFactory.getCurrentSession(); 
			tran = session.beginTransaction();
			Query query = session.createQuery(hql); 
			if (null != param && param.length > 0) {
				for (int i = 0; i < param.length; i++) {
					query.setParameter(i, param[i]);
				}
			}  
			object = query.uniqueResult();
			tran.commit();
		} catch (Exception e) {
			if (tran != null) {
				tran.rollback();
			}
		} 
		return object;
	}

	public <T> List<T> queryByPage(String hql, Object[] param, int pageNo,
			int pageSize) {
		List<T> list = new ArrayList<T>();
		Session session = null;
		Transaction tran = null;
		try {
			session = sessionFactory.getCurrentSession(); 
			tran = session.beginTransaction();
			Query query = session.createQuery(hql);
			if (null != param && param.length > 0) {
				for (int i = 0; i < param.length; i++) {
					query.setParameter(i, param[i]);
				}
			} 
			query.setFirstResult((pageNo-1) * pageSize);
			query.setMaxResults(pageSize); 
			list = query.list();
			tran.commit(); 
		} catch (Exception e) {
			if (tran != null) {
				tran.rollback();
			}
		}
		return list;
	}

}

