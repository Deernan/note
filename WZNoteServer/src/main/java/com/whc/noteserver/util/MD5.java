package com.whc.noteserver.util;

import org.apache.commons.codec.digest.DigestUtils;

public class MD5 {
	// ����Կ����
	public static String md5(String text, String key) throws Exception {
		// ���ܺ���ַ���
		String md5str = DigestUtils.md5Hex(text + key);
		System.out.println("MD5���ܺ���ַ���Ϊ:" + md5str);
		return md5str;
	}

}
