package com.whc.noteserver.dao;

import java.util.List;

import com.whc.noteserver.entity.Note;
import com.whc.noteserver.param.NoteParam;
import com.whc.noteserver.result.NoteResult;

public interface NoteDao {

	/**
	 * ��ȡ��¼��
	 * 
	 * @return
	 */
	public int getCount(NoteParam param);

	/**
	 * ��ȡ�ʼǱ���Ϣ
	 * 
	 * @return
	 */
	public List<NoteResult> getNote(NoteParam param);

	/**
	 * ��ӱʼǱ���Ϣ
	 * 
	 * @param Note Ҫ��ӵıʼǱ�
	 * @return
	 */
	public int addNote(Note note);

	/**
	 * ��ѯ�����ʼǱ���Ϣ
	 * 
	 * @param Note ����Note��id
	 * @return
	 */
	public List<Note> getNoteDetail(Note Note);

	/**
	 * ���±ʼǱ���Ϣ
	 * 
	 * @param Note Ҫ���µıʼǱ�
	 * @return
	 */
	public int updateNote(Note Note);

	/**
	 * ɾ���ʼǱ�
	 * 
	 * @param Note Ҫɾ���ıʼǱ�
	 * @return
	 */
	public int deleteNote(Note Note);
}
