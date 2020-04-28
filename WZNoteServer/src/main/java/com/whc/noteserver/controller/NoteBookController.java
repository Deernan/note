package com.whc.noteserver.controller;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.whc.noteserver.entity.NoteBook;
import com.whc.noteserver.service.NoteBookService;
import com.whc.noteserver.util.JsonResult;

@Controller // ע�⣬���ɨ����뵽spring������
@RequestMapping("/notebook") // ��controller��ӳ��·��
public class NoteBookController {
	
	@Autowired
	NoteBookService noteBookService;
	/**
	 * ��ȡ�ʼǱ���Ϣ
	 * @return
	 */
	@RequestMapping("/getnotebook")
	@ResponseBody
	public JsonResult getNoteBook() {
		List<NoteBook> list = noteBookService.getNoteBook();
		return new JsonResult(JsonResult.STATE_SUCCESS,"",list);
	}
	
	/**
	 * ��ӱʼǱ�
	 * @return
	 */
	@RequestMapping("/addnotebook")
	@ResponseBody
	public JsonResult addNoteBook(NoteBook noteBook) {
		int result = noteBookService.addNoteBook(noteBook);
		if (result==1) {
			return new JsonResult(JsonResult.STATE_SUCCESS,"��ӳɹ�",null);
		}else {
			return new JsonResult(JsonResult.STATE_ERROR,"���ʧ��",null);
		}
	}
	
	/**
	 * ��ȡ�����ʼǱ���Ϣ
	 * @return
	 */
	@RequestMapping("/getdetail")
	@ResponseBody
	public JsonResult getNoteBookDetail(NoteBook noteBook) {
		List<NoteBook> list = noteBookService.getNoteBookDetail(noteBook);
		if (list!=null && !list.isEmpty()) {
			return new JsonResult(JsonResult.STATE_SUCCESS,"",list.get(0));
		}else {
			return new JsonResult(JsonResult.STATE_ERROR,"δ��ѯ���ʼǱ�",null);
		}
	}
	
	/**
	 * �޸ıʼǱ�
	 * @return
	 */
	@RequestMapping("/updatenotebook")
	@ResponseBody
	public JsonResult updateNoteBook(NoteBook noteBook) {
		int result = noteBookService.updateNoteBook(noteBook);
		if (result==1) {
			return new JsonResult(JsonResult.STATE_SUCCESS,"�޸ĳɹ�",null);
		}else {
			return new JsonResult(JsonResult.STATE_ERROR,"�޸�ʧ��",null);
		}
	}
	
	/**
	 * ɾ���ʼǱ�
	 * @return
	 */
	@RequestMapping("/deletenotebook")
	@ResponseBody
	public JsonResult deleteNoteBook(NoteBook noteBook) {
		int result = noteBookService.deleteNoteBook(noteBook);
		if (result==1) {
			return new JsonResult(JsonResult.STATE_SUCCESS,"ɾ���ɹ�",null);
		}else {
			return new JsonResult(JsonResult.STATE_ERROR,"ɾ��ʧ��",null);
		}
	}

}
