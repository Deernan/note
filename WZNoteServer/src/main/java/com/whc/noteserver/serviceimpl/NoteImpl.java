package com.whc.noteserver.serviceimpl;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.whc.noteserver.dao.NoteDao;
import com.whc.noteserver.entity.Note;
import com.whc.noteserver.param.NoteParam;
import com.whc.noteserver.result.NoteResult;
import com.whc.noteserver.service.NoteService;

@Service
public class NoteImpl implements NoteService {
	
	@Autowired
	NoteDao noteDao;
	
	public List<NoteResult> getNoteForeach(List<String> id){
		return noteDao.getNoteForeach(id);
	}

	public int getCount(NoteParam param) {
		return noteDao.getCount(param);
	}

	/**
	 * ��ȡ�ʼ���Ϣ
	 * 
	 * @return
	 */
	public List<NoteResult> getNote(NoteParam param) {
		return noteDao.getNote(param);
	}

	/**
	 * ��ӱʼ���Ϣ
	 * 
	 * @param note Ҫ��ӵıʼ�
	 * @return
	 */
	public int addNote(Note note) {
		return noteDao.addNote(note);
	}

	/**
	 * ��ѯ�����ʼ���Ϣ
	 * 
	 * @param note ����note��id
	 * @return
	 */
	public List<Note> getNoteDetail(Note note) {
		return noteDao.getNoteDetail(note);
	}

	/**
	 * ���±ʼ���Ϣ
	 * 
	 * @param note Ҫ���µıʼ�
	 * @return
	 */
	public int updateNote(Note note) {
		return noteDao.updateNote(note);
	}

	/**
	 * ɾ���ʼ�
	 * 
	 * @param note Ҫɾ���ıʼ�
	 * @return
	 */
	public int deleteNote(Note note) {
		return noteDao.deleteNote(note);
	}

}
