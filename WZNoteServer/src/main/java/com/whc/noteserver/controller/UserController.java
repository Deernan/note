package com.whc.noteserver.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import com.whc.noteserver.entity.User;
import com.whc.noteserver.service.UserService;
import com.whc.noteserver.test.Person;
import com.whc.noteserver.util.JsonResult;
import com.whc.noteserver.util.MD5;

@Controller // ע�⣬���ɨ����뵽spring������
@RequestMapping("/user") // ��controller��ӳ��·��
public class UserController {

	private Logger logger = LogManager.getLogger(UserController.class);

	@Autowired
	UserService userService;

	@RequestMapping("/login") // ������ӳ��·��
	@ResponseBody // ��������Ϣ���͵���ҳ��
	public Object login(User user, HttpSession session) {
		// System.out.println(user.toString());
		// userService.login(user);
		logger.debug("��¼��" + user.getUsername());
		logger.info("��¼��" + user.getUsername());

		try {
			user.setPassword(MD5.md5(user.getPassword(), "helloworld"));
		} catch (Exception e) {
//			e.printStackTrace(); 
			logger.error("MD5����", e);
		}
		User userResult = userService.login(user);

		JsonResult jsonResult;
		if (userResult != null) {
			session.setAttribute("id", userResult.getId());
			jsonResult = new JsonResult(JsonResult.STATE_SUCCESS, "", userResult);
		} else {
			jsonResult = new JsonResult(JsonResult.STATE_ERROR, "�û������������", null);
		}

		return jsonResult;

	}

	@RequestMapping("/register")
	@ResponseBody
	public Object register(User user) {
		user.setId(UUID.randomUUID().toString());
		try {
			String newpassword = MD5.md5(user.getPassword(), "helloworld");
			user.setPassword(newpassword);
		} catch (Exception e) {
			e.printStackTrace();
		}
		JsonResult jsonResult = null;
		System.out.println(user);
		// 1.�ж�ǰ̨���������û����Ƿ��ظ�
		User userResult = userService.getUserByUserName(user);
		if (userResult == null) {
			// ����ע��
			// 2.������ظ���˵������ע�ᣬ��User��Ϣ��ӵ����ݿ�
			int result = userService.addUser(user);
			if (result == 1) {
				// ���ݿ����ɹ�
				jsonResult = new JsonResult(JsonResult.STATE_SUCCESS, "ע��ɹ�", null);
			} else {
				// ���ݿ����ʧ��
				jsonResult = new JsonResult(JsonResult.STATE_ERROR, "ע��ʧ��", null);
			}

		} else {
			// ������ͬ���û�����������ע��
			jsonResult = new JsonResult(JsonResult.STATE_ERROR, "�����ظ����û���", null);
		}

		return jsonResult;
	}
	
	/**
	 * �����û�id��ȡ�û���Ϣ
	 * @param user
	 * @return
	 */
	@RequestMapping("/getuserbyid")
	@ResponseBody
	public Object getuserbyid(User user) {
		JsonResult jsonResult=null;
		//��3�⣬������÷���
		User userRe=userService.getUserByID(user);
		jsonResult=new JsonResult(JsonResult.STATE_SUCCESS,"",userRe);
		return jsonResult;
		
	}
	
	/**
	 * �����û�ע����Ϣ
	 * @param user
	 * @return
	 */
	@RequestMapping("/updateUser")  //��4�⣬����ӳ��·��
	@ResponseBody
	public Object updateRegister(User user) {
		JsonResult jsonResult=null;
		
		//�����û���Ϣ
		int result=userService.updateUser(user);

		if(result==1) {
				//���³ɹ�
			jsonResult=new JsonResult(JsonResult.STATE_SUCCESS,"���³ɹ�",null);
		}else {
				//����ʧ��
			jsonResult=new JsonResult(JsonResult.STATE_ERROR,"����ʧ��",null);
		}	

		return jsonResult;
		
	}

}
