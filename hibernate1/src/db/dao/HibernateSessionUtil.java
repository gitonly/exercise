package db.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateSessionUtil {
	private static final ThreadLocal<Session> sessionLocal = new ThreadLocal<Session>();
	
	public static Session getSession(){
		Session session = sessionLocal.get();
		if(session == null || !session.isOpen()){
			Configuration conf = new Configuration();
			conf.configure();//����hibernate.cfg.xml�����ļ�
			SessionFactory sf = conf.buildSessionFactory();//��ȡSessionFactoryʵ��
			session = sf.openSession();
			sessionLocal.set(session);
		}
		return session;
	}
	
	public static void closeSession(){
		Session session = sessionLocal.get();
		sessionLocal.set(null);
		if(session != null){
			session.close();
		}
	}
	
}
