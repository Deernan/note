package com.whc.noteserver.entity;

import java.io.Serializable;

public class ReNote implements Serializable {

	private static final long serialVersionUID = -1884502868921125599L;
	public static int DELETE_YES = 1;
	public static int DELETE_NO = 0;
	private String id; // id
	private String name;// �ʼ�����
	private int isdelete;// �Ƿ�ɾ����־��0-δɾ����1-ɾ��

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
	public int getIsdelete() {
		return isdelete;
	}

	public void setIsdelete(int isdelete) {
		this.isdelete = isdelete;
	}


	@Override
	public String toString() {
		return "NoteBook [id=" + id + ", name=" + name + ", isdelete=" + isdelete + ", userid="
				+ "]";
	}

}
