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
	
	public void add2(User user){
		Session session = this.openSession();
		session.save(user);
		this.closeSession();
	}
	
	public User findById(int id){//��������ѯ��hql��䣬�Ժ�
		Configuration conf = new Configuration();
		conf.configure();
		SessionFactory sf = conf.buildSessionFactory();
		Session session = sf.openSession();
		User user = (User)session.get(User.class, id);//User.class���������ࡣ
		session.close();
		return user;
		
	}
	
	public User findById2(int id){
		Session session = this.openSession();
		//get���̼�������;
		//load���ӳټ���,�ڵ�������get����ʱ�ż�������
		User user = (User)session.get(User.class, id);
		this.closeSession();
		return user;
	}
	

	
	public void update(User user){
		Session session = this.openSession();
		Transaction tran = session.beginTransaction();
		session.update(user);
		tran.commit();
		this.closeSession();
	}
	
	public void delete(int id){
//		User user = this.findById(id);//������ܷ������棬��Ϊ������������и��ر�session��ָ������session�ر�����Ժ�����session����
		User user = new User();
		user.setId(id);
		Session session = this.openSession();
		Transaction tran = session.beginTransaction(); 
		session.delete(user);
		tran.commit();
		this.closeSession();
	}
	

	/**
	 * @param args
	 */
	public static void main(String[] args) {
//		User user = new User();
//		user.setEmail("lisi@tom.com");
//		user.setNickName("lisi");
//		user.setPassword("asdfasdfweras23sdfa");
//		user.setUserIntegral(10);
//		user.setEmailVerify(true);
//		user.setVerifyCode("dsdfdswewewer");
//		user.setLastLoginTime(System.currentTimeMillis());
//		user.setLastLoginIP("127.0.0.1");
//		new UserDAO().add(user);
		
		UserDAO userDAO = new UserDAO();
//		User user = userDAO.findById(1);
////		System.out.println(user.getNickName());
//		user.setNickName("rose");
//		user.setEmail("rose@163.com");
//		userDAO.update(user);
		userDAO.delete(1);
	}

}
