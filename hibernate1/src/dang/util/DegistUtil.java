package dang.util;

import java.security.MessageDigest;

import sun.misc.BASE64Encoder;

public final class DegistUtil {
	public static String md5(String str){
		try {
			//���������ֽ��ټ���
			MessageDigest md = MessageDigest.getInstance("MD5");
			byte[] bys = md.digest(str.getBytes());
			//�����ܺ���ֽ�����ʹ��Base64�㷨����ַ���
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
