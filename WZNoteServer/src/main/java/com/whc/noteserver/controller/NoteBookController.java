package com.whc.noteserver.controller;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.whc.noteserver.entity.NoteBook;
import com.whc.noteserver.param.NoteBookParam;
import com.whc.noteserver.result.LayPage;
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
	public JsonResult getNoteBook(NoteBookParam param) {
		param.setPage((param.getPage()-1)*param.getLimit());
		//System.out.println("page:"+page+" limit:"+limit);
		List<NoteBook> list = noteBookService.getNoteBook(param);
		int count = noteBookService.getCount();
		//����һ������
		LayPage lp = new LayPage();
		lp.setCount(count);
		lp.setList(list);
		
		return new JsonResult(JsonResult.STATE_SUCCESS,"",lp);
	}
	
	/**
	 * ��ӱʼǱ�
	 * @return
	 */
	@RequestMapping("/addnotebook")
	@ResponseBody
	public JsonResult addNoteBook(NoteBook noteBook) {
		noteBook.setId(UUID.randomUUID().toString());
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
