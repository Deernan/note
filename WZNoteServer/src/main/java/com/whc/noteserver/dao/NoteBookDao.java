package com.whc.noteserver.dao;

import java.util.List;

import com.whc.noteserver.entity.NoteBook;
import com.whc.noteserver.param.NoteBookParam;

public interface NoteBookDao {
	
	/**
	 * ��ȡ��¼��
	 * @return
	 */
	public int getCount();
	
	/**
	 * ��ȡ�ʼǱ���Ϣ
	 * @return
	 */
	public List<NoteBook> getNoteBook(NoteBookParam param);
	
	/**
	 * ��ӱʼǱ���Ϣ
	 * @param noteBook Ҫ��ӵıʼǱ�
	 * @return
	 */
	public int addNoteBook(NoteBook noteBook);
	
	/**
	 * ��ѯ�����ʼǱ���Ϣ
	 * @param noteBook ����noteBook��id
	 * @return
	 */
	public List<NoteBook> getNoteBookDetail(NoteBook noteBook);
	
	/**
	 *���±ʼǱ���Ϣ
	 * @param noteBook Ҫ���µıʼǱ�
	 * @return 
	 */
	public int updateNoteBook(NoteBook noteBook);
	
	/**
	 * ɾ���ʼǱ���Ϣ
	 * @param noteBook Ҫɾ���ıʼǱ�
	 * @return 
	 */
	public int deleteNoteBook(NoteBook noteBook);

}
