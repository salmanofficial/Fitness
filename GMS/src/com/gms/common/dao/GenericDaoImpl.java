package com.gms.common.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GenericDaoImpl<T> implements GenericDao<T> {
	
	@Autowired
	SessionFactory sessionFactory;

	@Override
	public void save(T entity) {
		Session session = null;
		Transaction transaction = null;
		try {
			session = sessionFactory.openSession();
			transaction = session.beginTransaction();
			session.saveOrUpdate(entity);
			
			transaction.commit();
		}catch (Exception e) {
			transaction.rollback();
			e.printStackTrace();
		}finally {
			if(session != null)
				session.close();
		}
	}

	public void findById(T entity,T id){
		Session session = null;
		Transaction transaction = null;
		try {
			session = sessionFactory.openSession();
			transaction = session.beginTransaction();
			
			
			
			
			transaction.commit();
		}catch (Exception e) {
			transaction.rollback();
			e.printStackTrace();
		}finally {
			if(session != null)
				session.close();
		}
	}

	

}
