package dang.util;

import java.util.UUID;

public final class VerifyUtil {
	public static String getVerifyCode(){
		UUID uuid = UUID.randomUUID();
		return uuid.toString();
	}
	
	public static String getUserID(String emailCode){
		//TODO 将uuid-userid内容的userid取出
		return "";
	}
	
	public static String getUUID(String emailCode){
		//TODO 将uuid-userid内容的uuid取出
		return "";
	}
	
	public static void main(String[] args){
		System.out.println(getVerifyCode());
		System.out.println(getVerifyCode());
	}
}
