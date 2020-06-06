package com.whc.noteserver.serviceimpl;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.whc.noteserver.dao.NoteBookDao;
import com.whc.noteserver.entity.NoteBook;
import com.whc.noteserver.param.NoteBookParam;
import com.whc.noteserver.service.NoteBookService;

@Service
public class NoteBookImpl implements NoteBookService {

	@Autowired
	NoteBookDao noteBookDao;

	public int getCount(NoteBookParam param) {
		return noteBookDao.getCount(param);
	}

	/**
	 * ��ȡ�ʼǱ���Ϣ
	 * 
	 * @return
	 */
	public List<NoteBook> getNoteBook(NoteBookParam param) {
		return noteBookDao.getNoteBook(param);
	}

	/**
	 * ��ӱʼǱ���Ϣ
	 * 
	 * @param noteBook Ҫ��ӵıʼǱ�
	 * @return
	 */
	public int addNoteBook(NoteBook noteBook) {
		return noteBookDao.addNoteBook(noteBook);
	}

	/**
	 * ��ѯ�����ʼǱ���Ϣ
	 * 
	 * @param noteBook ����noteBook��id
	 * @return
	 */
	public List<NoteBook> getNoteBookDetail(NoteBook noteBook) {
		return noteBookDao.getNoteBookDetail(noteBook);
	}

	/**
	 * ���±ʼǱ���Ϣ
	 * 
	 * @param noteBook Ҫ���µıʼǱ�
	 * @return
	 */
	public int updateNoteBook(NoteBook noteBook) {
		return noteBookDao.updateNoteBook(noteBook);
	}

	/**
	 * ɾ���ʼǱ�
	 * 
	 * @param noteBook Ҫɾ���ıʼǱ�
	 * @return
	 */
	public int deleteNoteBook(NoteBook noteBook) {
		return noteBookDao.deleteNoteBook(noteBook);
	}

	/**
	 * �����û�id��ȡ���бʼǱ���Ϣ
	 * 
	 * @param param
	 * @return
	 */
	public List<NoteBook> getAllNoteBookByUserId(NoteBookParam param) {
		return noteBookDao.getAllNoteBookByUserId(param);
	}

}
