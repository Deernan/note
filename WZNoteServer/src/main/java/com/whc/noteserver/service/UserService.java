package com.whc.noteserver.service;

import com.whc.noteserver.entity.User;

public interface UserService {
	/**
	 * �û���¼
	 * @param user �����user
	 * @return �����ݿ��ѯ���ص�User
	 */
	public User login(User user);
	
	/**
	 * �����û�����ȡ�û���Ϣ
	 * @param user ��ǰ̨�����user
	 * @return �����ݿ��ѯ��user
	 */
	public User getUserByUserName(User user);
	
	/**
	 * ����û���Ϣ
	 * @param userǰ̨�����user
	 * @return 1
	 */
	public int addUser(User user);

}
