package com.whc.noteserver.dao;

import java.util.List;

import com.whc.noteserver.entity.User;

public interface UserDao {
	public List<User> login(User user);

	/**
	 * �����û�����ȡ�û���Ϣ
	 * 
	 * @param user ��ǰ̨�����user
	 * @return �����ݿ��ѯ��user
	 */
	public List<User> getUserByUserName(User user);

	/**
	 * ����û���Ϣ
	 * 
	 * @param user ��ǰ̨�����user
	 * @return 1
	 */
	public int addUser(User user);
	
	/**
	 * �����û���Ϣ
	 * @param user ��ǰ̨�����user
	 * @return
	 */
	public int updateUser(User user);
	
	/**
	 * ����id��ȡ�û���Ϣ
	 * @param user
	 * @return
	 */
	public List<User> getUserByID(User user);
}
