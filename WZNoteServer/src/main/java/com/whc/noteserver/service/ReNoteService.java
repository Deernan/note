package com.whc.noteserver.service;

import java.util.List;

import com.whc.noteserver.entity.Note;
import com.whc.noteserver.entity.ReNote;
import com.whc.noteserver.param.NoteParam;
import com.whc.noteserver.param.ReNoteParam;
import com.whc.noteserver.result.NoteResult;
import com.whc.noteserver.result.DelNoteResult;

public interface ReNoteService {

	public int getCount(ReNoteParam param);

	/**
	 * ��ȡ�ʼ���Ϣ
	 * 
	 * @return
	 */
	public List<DelNoteResult> getDelNote(ReNoteParam param);

	/**
	 * ��ԭ�ʼ�
	 * 
	 * @param Note Ҫ��ԭ�ıʼ�
	 * @return
	 */
	public int reNote(ReNote note);
	
	/**
	 * ����ɾ���ʼ�
	 * 
	 * @param Note Ҫ����ɾ���ıʼ�
	 * @return
	 */
	public int deleteNote(ReNote note);

}
