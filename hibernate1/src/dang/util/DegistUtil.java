package dang.util;

import java.security.MessageDigest;

import sun.misc.BASE64Encoder;

public final class DegistUtil {
	public static String md5(String str){
		try {
			//将密码编程字节再加密
			MessageDigest md = MessageDigest.getInstance("MD5");
			byte[] bys = md.digest(str.getBytes());
			//将加密后的字节数组使用Base64算法变成字符串
			BASE64Encoder encode = new BASE64Encoder();
			return encode.encode(bys);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public static void main(String[] args){
		System.out.println(md5("abc"));
		System.out.println(md5("dddddasdfasdf"));
	}
	
	
}
