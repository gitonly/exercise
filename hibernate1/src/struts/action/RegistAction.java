package struts.action;

import dang.util.DegistUtil;
import dang.util.VerifyUtil;
import db.dao.UserDAO;
import db.domain.User;

public class RegistAction {
	private User user;
	
	public String execute(){
		UserDAO userDAO = new UserDAO();
		//TODO ������������ֵ
		String pwd = DegistUtil.md5(user.getPassword());
		user.setPassword(pwd);
		String code = VerifyUtil.getVerifyCode();
		user.setVerifyCode(code);
		user.setLastLoginTime(System.currentTimeMillis());
		userDAO.add(user);
		System.out.println("�����ʼ�:"+code+"-"+user.getId());
		return "success";
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
	
}
