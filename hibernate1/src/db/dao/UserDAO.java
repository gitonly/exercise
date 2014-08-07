package db.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import db.domain.User;

public class UserDAO extends BaseDAO{
	
	public void add(User user){
		Configuration conf = new Configuration();
		conf.configure();//加载配置文件,默认src下的hibernate.cfg.xml
		SessionFactory sf = conf.buildSessionFactory();//获取SessionFactory实例
		Session session = sf.openSession();
		Transaction txt = session.beginTransaction();//默认不自动提交,获取事务
		session.save(user);
		txt.commit();
		session.close();
	}
	
	public void add2(User user){
		Session session = this.openSession();
		session.save(user);
		this.closeSession();
	}
	
	public User findById(int id){//非主键查询用hql语句，以后讲
		Configuration conf = new Configuration();
		conf.configure();
		SessionFactory sf = conf.buildSessionFactory();
		Session session = sf.openSession();
		User user = (User)session.get(User.class, id);//User.class用来加载类。
		session.close();
		return user;
		
	}
	
	public User findById2(int id){
		Session session = this.openSession();
		//get立刻加载数据;
		//load是延迟加载,在调用属性get方法时才加载数据
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
//		User user = this.findById(id);//这个不能放在下面，因为这个方法里面有个关闭session的指令，会造成session关闭造成以后步骤无session对象
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
