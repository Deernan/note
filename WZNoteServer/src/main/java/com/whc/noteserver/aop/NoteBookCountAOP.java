package com.whc.noteserver.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.whc.noteserver.entity.NoteBook;
import com.whc.noteserver.param.NoteBookParam;
import com.whc.noteserver.service.NoteBookService;
import com.whc.noteserver.service.UserService;

@Aspect
@Component 
public class NoteBookCountAOP {
	
	@Autowired
	private NoteBookService noteBookService;
	
	@Pointcut("execution(* com.whc.noteserver.service.NoteBookService.addNoteBook(..))")
	private void poinCut() {
		
	}
	
	@Before("poinCut()") 
	public void before(JoinPoint joinPoint) {
	    System.out.println("addNoteBook����ִ��ǰ"); 
	 }
	 
	@AfterReturning("poinCut()") 
	public void afterReturning(JoinPoint joinPoint){ 
		System.out.println("��ӱʼǱ���ִ�з���"); 
	}
	 
	@Around("poinCut()")
	public Object around(ProceedingJoinPoint proceedingJoinPoint) {
		System.out.println("���ƿ�ʼ");
		Object[] args = proceedingJoinPoint.getArgs();
		NoteBookParam noteBookParam = new NoteBookParam();
		noteBookParam.setUserid(((NoteBook)args[0]).getUserid());
		int re = noteBookService.getCount(noteBookParam);
		Object obj = null;
		if (re<50) {
			//�������
			try {
				//ִ��Ŀ�귽��
				obj = proceedingJoinPoint.proceed();
			} catch (Throwable e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println("���ƽ���");
			return obj;
		}else {
			//��������ӱʼǱ�
			System.out.println("���ƿ�ʼ");
			return -1;
		}
	}
	
	@AfterThrowing(value = "poinCut()",throwing="e")
	public void countThrow(JoinPoint joinPoint,Throwable e) {
		System.out.println("�쳣��"+e.getMessage());
	}
	
	@After("poinCut()")
	public void retu(JoinPoint joinPoint) {
		System.out.println("����ִ�з���");
	}
	
	

}
