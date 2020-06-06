package com.whc.noteserver.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.whc.noteserver.dao.UserDao;
import com.whc.noteserver.entity.User;
import com.whc.noteserver.service.UserService;

@Service
public class UserImpl implements UserService {

	@Autowired
	UserDao userDao;

	public User login(User user) {
//		System.out.println(user);
		List<User> list = userDao.login(user);
		if (list == null || list.isEmpty()) {
			System.out.println("�û��������벻ƥ��");
			return null;
		} else {
			System.out.println(list.get(0));
			return list.get(0);
		}
	}

	@Override
	public User getUserByUserName(User user) {
		List<User> list = userDao.getUserByUserName(user);
		if (list == null || list.isEmpty()) {
			return null;
		}
		return list.get(0);
	}

	public int addUser(User user) {
		return userDao.addUser(user);
	}

}
