package com.whc.noteserver.result;

import java.util.List;

import com.whc.noteserver.entity.NoteBook;

public class LayPage {
	private int count; // ��������
	// private List<NoteBook> list;//һҳ��ʾ������
	private Object list;

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	public Object getList() {
		return list;
	}

	public void setList(Object list) {
		this.list = list;
	}

}
