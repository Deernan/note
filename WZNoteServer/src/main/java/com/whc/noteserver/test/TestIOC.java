package com.whc.noteserver.test;



import java.util.Date;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestIOC {

	public static void main(String[] args) {
		//springӦ��������
		//ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("conf/spring-service.xml");
		//ʵ��������
		//Date date=context.getBean("date",Date.class);
		//System.out.println(date);
		//http://www.baidu.com/login.html  ��ת��  http://www.baidu.com/index.html
		//ֱ������ http://www.baidu.com/index.html  ��ת��  http://www.baidu.com/login.html
		//bean�������� singletonv request  session
		//FanDian fanDian =context.getBean("fanDian",FanDian.class);
		//System.out.println(fanDian.hashCode());
		//fanDian.say();
		//fanDian =context.getBean("fanDian",FanDian.class);
		//System.out.println(fanDian.hashCode());
		//fanDian =context.getBean("fanDian",FanDian.class);
		//System.out.println(fanDian.hashCode());
		
		//Person person = context.getBean("person",Person.class);
		//person.say();

		
		

	}

}
