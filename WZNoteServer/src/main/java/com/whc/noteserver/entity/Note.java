package com.whc.noteserver.entity;

import java.io.Serializable;

public class Note implements Serializable{
	
	private static final long serialVersionUID = -1884502868921125599L;
	public static int DELETE_YES=1;
	public static int DELETE_NO=0;
	private String id; //id
	private String name;//�ʼǱ�����
	private String content;//�ʼ�����
	private long addtime;//���ʱ��
	private int isdelete;//�Ƿ�ɾ����־��0-δɾ����1-ɾ��
	private String notebookid;//�����ʼǱ�id

	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public long getAddtime() {
		return addtime;
	}
	public void setAddtime(long addtime) {
		this.addtime = addtime;
	}
	public int getIsdelete() {
		return isdelete;
	}
	public void setIsdelete(int isdelete) {
		this.isdelete = isdelete;
	}

	
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	
	public String getNotebookid() {
		return notebookid;
	}
	public void setNotebookid(String notebookid) {
		this.notebookid = notebookid;
	}
	@Override
	public String toString() {
		return "NoteBook [id=" + id + ", name=" + name + ", addtime=" + addtime + ", isdelete=" + isdelete + ", userid="
				+ content + "]";
	}
	
	
	
}
