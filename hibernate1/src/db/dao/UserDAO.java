package db.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import db.domain.User;

public class UserDAO extends BaseDAO{
	
	public void add(User user){
		Configuration conf = new Configuration();
		conf.configure();//���������ļ�,Ĭ��src�µ�hibernate.cfg.xml
		SessionFactory sf = conf.buildSessionFactory();//��ȡSessionFactoryʵ��
		Session session = sf.openSession();
		Transaction txt = session.beginTransaction();//Ĭ�ϲ��Զ��ύ,��ȡ����
		session.save(user);
		txt.commit();
		session.close();
	}
	
//	public void add(User user){
//		Session session = this.openSession();
//		session.save(user);
//	}
	
	public User findById(int id){
		Session session = this.openSession();
		//get���̼�������;
		//load���ӳټ���,�ڵ�������get����ʱ�ż�������
		User user = (User)session.get(User.class, id);
		return user;
	}
	
	public void update(User user){
		Session session = this.openSession();
		session.update(user);
	}
	
	public void delete(int id){
		User user = findById(4);
//		User user = new User();
//		user.setId(id);
		Session session = this.openSession();
		session.delete(user);
	}
	

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		User user = new User();
		user.setEmail("lisi@tom.com");
		user.setNickName("lisi");
		user.setPassword("asdfasdfweras23sdfa");
		user.setUserIntegral(10);
		user.setEmailVerify(true);
		user.setVerifyCode("dsdfdswewewer");
		user.setLastLoginTime(System.currentTimeMillis());
		user.setLastLoginIP("127.0.0.1");
		new UserDAO().add(user);
		
//		UserDAO userDAO = new UserDAO();
//		User user = userDAO.findById(5);
//		user.setNickName("rose");
//		user.setEmail("rose@163.com");
//		userDAO.update(user);
//		userDAO.delete(5);
	}

}
