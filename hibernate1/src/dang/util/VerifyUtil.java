package dang.util;

import java.util.UUID;

public final class VerifyUtil {
	public static String getVerifyCode(){
		UUID uuid = UUID.randomUUID();
		return uuid.toString();
	}
	
	public static String getUserID(String emailCode){
		//TODO ��uuid-userid���ݵ�useridȡ��
		return "";
	}
	
	public static String getUUID(String emailCode){
		//TODO ��uuid-userid���ݵ�uuidȡ��
		return "";
	}
	
	public static void main(String[] args){
		System.out.println(getVerifyCode());
		System.out.println(getVerifyCode());
	}
}
