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
import com.whc.noteserver.entity.ReNote;
import com.whc.noteserver.param.NoteParam;
import com.whc.noteserver.param.ReNoteParam;
import com.whc.noteserver.result.LayPage;
import com.whc.noteserver.result.NoteResult;
import com.whc.noteserver.result.DelNoteResult;
import com.whc.noteserver.service.NoteService;
import com.whc.noteserver.service.ReNoteService;
import com.whc.noteserver.util.JsonResult;

@Controller // ע�⣬���ɨ����뵽spring������
@RequestMapping("/renote") // ��controller��ӳ��·��
public class ReNoteController {

	@Autowired
	ReNoteService renoteService;

	/**
	 * ��ȡɾ���ıʼ���Ϣ
	 * 
	 * @return
	 */
	@RequestMapping("/getdelnote")
	@ResponseBody
	public JsonResult getDelNote(ReNoteParam param) {

		param.setPage((param.getPage() - 1) * param.getLimit());
		// System.out.println("page:"+page+" limit:"+limit);
		List<DelNoteResult> list = renoteService.getDelNote(param);
		int count = renoteService.getCount(param);
		// ����һ������
		LayPage lp = new LayPage();
		lp.setCount(count);
		lp.setList(list);

		return new JsonResult(JsonResult.STATE_SUCCESS, "", lp);
	}

	/**
	 * ��ԭ�ʼ�
	 * 
	 * @return
	 */
	@RequestMapping("/renote")
	@ResponseBody
	public JsonResult renote(ReNote note) {
		int result = renoteService.reNote(note);
		if (result == 1) {
			return new JsonResult(JsonResult.STATE_SUCCESS, "��ԭ�ɹ�", null);
		} else {
			return new JsonResult(JsonResult.STATE_ERROR, "��ԭʧ��", null);
		}
	}

	/**
	 * ����ɾ���ʼ�
	 * 
	 * @return
	 */
	@RequestMapping("/deletenote")
	@ResponseBody
	public JsonResult deleteNote(ReNote note) {
		int result = renoteService.deleteNote(note);
		if (result == 1) {
			return new JsonResult(JsonResult.STATE_SUCCESS, "ɾ���ɹ�", null);
		} else {
			return new JsonResult(JsonResult.STATE_ERROR, "ɾ��ʧ��", null);
		}
	}

}
