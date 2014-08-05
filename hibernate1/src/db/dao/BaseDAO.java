package db.dao;

import org.hibernate.Session;

public class BaseDAO {
	public Session openSession(){
		return HibernateSessionUtil.getSession();
	}
	
	public void closeSession(){
		HibernateSessionUtil.closeSession();
	}
	
}
