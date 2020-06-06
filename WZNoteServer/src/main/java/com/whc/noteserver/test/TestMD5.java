package com.whc.noteserver.test;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;

import org.apache.commons.codec.digest.DigestUtils;

public class TestMD5 {

	public static void main(String[] args) {
		String content = readFileByBytes("D:\\Users\\Desktop\\123.txt");
		try {
			System.out.println(md52(content));
			// �������ģ�133524c54a3c940ffb9a827650f88672

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static String readFileByBytes(String fileName) {
		StringBuffer sb = new StringBuffer();
		try {
			File file = new File(fileName);
			InputStream in = null;

			if (file.isFile() && file.exists()) { // �ж��ļ��Ƿ����
				// System.out.println("���ֽ�Ϊ��λ��ȡ�ļ����ݣ�һ�ζ�����ֽڣ�");
				// һ�ζ�����ֽ�
				byte[] tempbytes = new byte[1024];
				int byteread = 0;
				in = new FileInputStream(file);
				// �������ֽڵ��ֽ������У�bytereadΪһ�ζ�����ֽ���
				while ((byteread = in.read(tempbytes)) != -1) {
					// System.out.write(tempbytes, 0, byteread);
					String str = new String(tempbytes, 0, byteread);
					sb.append(str);
				}
			}

		} catch (Exception e) {

		} finally {
			return sb.toString();
		}

	}

	// ����Կ����
	public static String md5(String text, String key) throws Exception {
		// ���ܺ���ַ���
		String md5str = DigestUtils.md5Hex(text + key);
		System.out.println("MD5���ܺ���ַ���Ϊ:" + md5str);
		return md5str;
	}

	// ������Կ����
	public static String md52(String text) throws Exception {
		// ���ܺ���ַ���
		String md5str = DigestUtils.md5Hex(text);
		// System.out.println("MD52���ܺ���ַ���Ϊ:" + md5str + "\t���ȣ�" + md5str.length());
		return md5str;
	}

	/**
	 * MD5��֤����
	 * 
	 * @param text����
	 * @param key��Կ
	 * @param md5����
	 */
	// ���ݴ������Կ������֤
	public static boolean verify(String text, String key, String md5) throws Exception {
		String md5str = md5(text, key);
		if (md5str.equalsIgnoreCase(md5)) {
			System.out.println("MD5��֤ͨ��");
			return true;
		}
		return false;
	}

}
