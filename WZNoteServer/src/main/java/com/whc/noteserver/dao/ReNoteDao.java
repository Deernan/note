package com.whc.noteserver.dao;

import java.util.List;

import com.whc.noteserver.entity.Note;
import com.whc.noteserver.entity.ReNote;
import com.whc.noteserver.param.NoteParam;
import com.whc.noteserver.param.ReNoteParam;
import com.whc.noteserver.result.NoteResult;
import com.whc.noteserver.result.DelNoteResult;

public interface ReNoteDao {

	/**
	 * ��ȡ��¼��
	 * 
	 * @return
	 */
	public int getCount(ReNoteParam param);

	/**
	 * ��ȡ��ɾ���ıʼ���Ϣ
	 * 
	 * @return
	 */
	public List<DelNoteResult> getDelNote(ReNoteParam param);

	/**
	 * ��ԭ�ʼ�
	 * 
	 * @param Note Ҫɾ���ıʼ�
	 * @return
	 */
	public int reNote(ReNote Note);
	
	/**
	 * ����ɾ���ʼ�
	 * 
	 * @param Note Ҫɾ���ıʼ�
	 * @return
	 */
	public int deleteNote(ReNote Note);
}
