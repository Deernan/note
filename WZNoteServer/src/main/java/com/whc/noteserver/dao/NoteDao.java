package com.whc.noteserver.dao;

import java.util.List;

import com.whc.noteserver.entity.Note;
import com.whc.noteserver.param.NoteParam;
import com.whc.noteserver.result.NoteResult;

public interface NoteDao {
	
	public List<NoteResult> getNoteForeach(List<String> id);

	/**
	 * ��ȡ��¼��
	 * 
	 * @return
	 */
	public int getCount(NoteParam param);

	/**
	 * ��ȡ�ʼ���Ϣ
	 * 
	 * @return
	 */
	public List<NoteResult> getNote(NoteParam param);

	/**
	 * ��ӱʼ���Ϣ
	 * 
	 * @param Note Ҫ��ӵıʼ�
	 * @return
	 */
	public int addNote(Note note);

	/**
	 * ��ѯ�����ʼ���Ϣ
	 * 
	 * @param Note ����Note��id
	 * @return
	 */
	public List<Note> getNoteDetail(Note Note);

	/**
	 * ���±ʼ���Ϣ
	 * 
	 * @param Note Ҫ���µıʼ�
	 * @return
	 */
	public int updateNote(Note Note);

	/**
	 * ɾ���ʼ�
	 * 
	 * @param Note Ҫɾ���ıʼ�
	 * @return
	 */
	public int deleteNote(Note Note);
}
