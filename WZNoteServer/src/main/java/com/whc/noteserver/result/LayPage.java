package com.whc.noteserver.result;

import java.util.List;

import com.whc.noteserver.entity.NoteBook;

public class LayPage {
	
	private int count;    //��������
	List<NoteBook> list;    //һҳ��ʾ������
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}
	public List<NoteBook> getList() {
		return list;
	}
	public void setList(List<NoteBook> list) {
		this.list = list;
	}

}
