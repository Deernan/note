package com.whc.noteserver.controller;

import java.util.HashMap;
import java.util.List;
import java.util.UUID;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import com.whc.noteserver.entity.Note;
import com.whc.noteserver.param.NoteParam;
import com.whc.noteserver.result.LayPage;
import com.whc.noteserver.result.NoteResult;
import com.whc.noteserver.service.NoteService;
import com.whc.noteserver.util.JsonResult;

@Controller // ע�⣬���ɨ����뵽spring������
@RequestMapping("/note") // ��controller��ӳ��·��
public class NoteController {

	@Autowired
	NoteService noteService;

	/**
	 * ��ȡ�ʼ���Ϣ
	 * 
	 * @return
	 */
	@RequestMapping("/getnote")
	@ResponseBody
	public JsonResult getNote(NoteParam param) {

		param.setPage((param.getPage() - 1) * param.getLimit());
		// System.out.println("page:"+page+" limit:"+limit);
		List<NoteResult> list = noteService.getNote(param);
		int count = noteService.getCount(param);
		// ����һ������
		LayPage lp = new LayPage();
		lp.setCount(count);
		lp.setList(list);

		return new JsonResult(JsonResult.STATE_SUCCESS, "", lp);
	}

	/**
	 * ��ӱʼ�
	 * 
	 * @return
	 */
	@RequestMapping("/addnote")
	@ResponseBody
	public JsonResult addNote(Note note) {

		note.setId(UUID.randomUUID().toString());
		note.setAddtime(System.currentTimeMillis());
		note.setIsdelete(0);
		// note.setUserid();
		int result = noteService.addNote(note);
		if (result == 1) {
			return new JsonResult(JsonResult.STATE_SUCCESS, "��ӳɹ�", null);
		} else {
			return new JsonResult(JsonResult.STATE_ERROR, "���ʧ��", null);
		}
	}

	/**
	 * ��ȡ�����ʼ���Ϣ
	 * 
	 * @return
	 */
	@RequestMapping("/getdetail")
	@ResponseBody
	public JsonResult getNoteDetail(Note note) {
		List<Note> list = noteService.getNoteDetail(note);
		if (list != null && !list.isEmpty()) {
			return new JsonResult(JsonResult.STATE_SUCCESS, "", list.get(0));
		} else {
			return new JsonResult(JsonResult.STATE_ERROR, "δ��ѯ���ʼ�", null);
		}

	}

	/**
	 * �޸ıʼ�
	 * 
	 * @return
	 */
	@RequestMapping("/updatenote")
	@ResponseBody
	public JsonResult updateNote(Note note) {
		int result = noteService.updateNote(note);
		if (result == 1) {
			return new JsonResult(JsonResult.STATE_SUCCESS, "�޸ĳɹ�", null);
		} else {
			return new JsonResult(JsonResult.STATE_ERROR, "�޸�ʧ��", null);
		}
	}

	/**
	 * ɾ���ʼ�
	 * 
	 * @return
	 */
	@RequestMapping("/deletenote")
	@ResponseBody
	public JsonResult deleteNote(Note note) {
		int result = noteService.deleteNote(note);
		if (result == 1) {
			return new JsonResult(JsonResult.STATE_SUCCESS, "ɾ���ɹ�", null);
		} else {
			return new JsonResult(JsonResult.STATE_ERROR, "ɾ��ʧ��", null);
		}
	}

}
