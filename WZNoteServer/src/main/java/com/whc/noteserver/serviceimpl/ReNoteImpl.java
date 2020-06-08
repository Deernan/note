package com.whc.noteserver.serviceimpl;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.whc.noteserver.dao.NoteDao;
import com.whc.noteserver.dao.ReNoteDao;
import com.whc.noteserver.entity.Note;
import com.whc.noteserver.entity.ReNote;
import com.whc.noteserver.param.NoteParam;
import com.whc.noteserver.param.ReNoteParam;
import com.whc.noteserver.result.NoteResult;
import com.whc.noteserver.result.DelNoteResult;
import com.whc.noteserver.service.NoteService;
import com.whc.noteserver.service.ReNoteService;

@Service
public class ReNoteImpl implements ReNoteService {

	@Autowired
	ReNoteDao renoteDao;

	public int getCount(ReNoteParam param) {
		return renoteDao.getCount(param);
	}

	/**
	 * ��ȡ��ɾ���ıʼ���Ϣ
	 * 
	 * @return
	 */
	public List<DelNoteResult> getDelNote(ReNoteParam param) {
		return renoteDao.getDelNote(param);
	}
	
	/**
	 *��ԭ�ʼ�
	 * 
	 * @param renote Ҫ��ԭ�ıʼ�
	 * @return
	 */
	public int reNote(ReNote note) {
		return renoteDao.reNote(note);
	}
	
	/**
	 * ɾ���ʼ�
	 * 
	 * @param note Ҫɾ���ıʼ�
	 * @return
	 */
	public int deleteNote(ReNote note) {
		return renoteDao.deleteNote(note);
	}

}
