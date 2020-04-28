package com.whc.noteserver.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.whc.noteserver.dao.NoteBookDao;
import com.whc.noteserver.entity.NoteBook;
import com.whc.noteserver.service.NoteBookService;

@Service
public class NoteBookImpl implements NoteBookService{

	@Autowired
	NoteBookDao noteBookDao;
	
	/**
	 * ��ȡ�ʼǱ���Ϣ
	 * @return
	 */
	public List<NoteBook> getNoteBook() {
		return noteBookDao.getNoteBook();
	}

	/**
	 * ��ӱʼǱ���Ϣ
	 * @param noteBook Ҫ��ӵıʼǱ�
	 * @return
	 */
	public int addNoteBook(NoteBook noteBook) {
		return noteBookDao.addNoteBook(noteBook);
	}

	/**
	 * ��ѯ�����ʼǱ���Ϣ
	 * @param noteBook ����noteBook��id
	 * @return
	 */
	public List<NoteBook> getNoteBookDetail(NoteBook noteBook) {
		return noteBookDao.getNoteBookDetail(noteBook);
	}

	/**
	 *���±ʼǱ���Ϣ
	 * @param noteBook Ҫ���µıʼǱ�
	 * @return 
	 */
	public int updateNoteBook(NoteBook noteBook) {
		return noteBookDao.updateNoteBook(noteBook);
	}

	/**
	 * ɾ���ʼǱ���Ϣ
	 * @param noteBook Ҫɾ���ıʼǱ�
	 * @return 
	 */
	public int deleteNoteBook(NoteBook noteBook) {
		return noteBookDao.deleteNoteBook(noteBook);
	}
	
	

}
