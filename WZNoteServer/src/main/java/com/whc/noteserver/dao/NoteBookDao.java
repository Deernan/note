package com.whc.noteserver.dao;

import java.util.HashMap;
import java.util.List;

import com.whc.noteserver.entity.NoteBook;
import com.whc.noteserver.param.NoteBookParam;

public interface NoteBookDao {

	/**
	 * ��ȡ��¼��
	 * 
	 * @return
	 */
	public int getCount(NoteBookParam param);

	/**
	 * ��ȡ�ʼǱ���Ϣ
	 * 
	 * @return
	 */
	public List<NoteBook> getNoteBook(NoteBookParam param);

	/**
	 * ��ӱʼǱ���Ϣ
	 * 
	 * @param noteBook Ҫ��ӵıʼǱ�
	 * @return
	 */
	public int addNoteBook(NoteBook noteBook);

	/**
	 * ��ѯ�����ʼǱ���Ϣ
	 * 
	 * @param noteBook ����noteBook��id
	 * @return
	 */
	public List<NoteBook> getNoteBookDetail(NoteBook noteBook);

	/**
	 * ���±ʼǱ���Ϣ
	 * 
	 * @param noteBook Ҫ���µıʼǱ�
	 * @return
	 */
	public int updateNoteBook(NoteBook noteBook);

	/**
	 * ɾ���ʼǱ�
	 * 
	 * @param noteBook Ҫɾ���ıʼǱ�
	 * @return
	 */
	public int deleteNoteBook(NoteBook noteBook);

	/**
	 * �����û�id��ȡ���бʼǱ���Ϣ
	 * 
	 * @param param
	 * @return
	 */
	public List<NoteBook> getAllNoteBookByUserId(NoteBookParam param);
}
