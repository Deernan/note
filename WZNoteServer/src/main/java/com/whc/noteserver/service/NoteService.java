package com.whc.noteserver.service;

import java.util.List;

import com.whc.noteserver.entity.Note;
import com.whc.noteserver.param.NoteParam;
import com.whc.noteserver.result.NoteResult;

public interface NoteService {

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
	public List<Note> getNoteDetail(Note note);

	/**
	 * ���±ʼ���Ϣ
	 * 
	 * @param Note Ҫ���µıʼ�
	 * @return
	 */
	public int updateNote(Note note);

	/**
	 * ɾ���ʼ�
	 * 
	 * @param Note Ҫɾ���ıʼ�
	 * @return
	 */
	public int deleteNote(Note note);

}
