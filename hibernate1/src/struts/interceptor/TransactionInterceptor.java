package struts.interceptor;

import java.sql.SQLException;

import org.hibernate.Transaction;

import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.MethodFilterInterceptor;

import db.dao.HibernateSessionUtil;

public class TransactionInterceptor extends MethodFilterInterceptor {

	@Override
	protected String doIntercept(ActionInvocation arg0) throws Exception {
		String resultCode = "";
		Transaction txt = HibernateSessionUtil.getSession().beginTransaction();
		try{
			resultCode = arg0.invoke();
			txt.commit();
		}catch(SQLException e){
			e.printStackTrace();
			txt.rollback();
		}finally{
			HibernateSessionUtil.closeSession();
		}
		return resultCode;
	}

}
