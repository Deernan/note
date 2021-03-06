package com.whc.noteserver.controller;

import java.util.HashMap;
import java.util.List;
import java.util.UUID;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import com.whc.noteserver.entity.NoteBook;
import com.whc.noteserver.param.NoteBookParam;
import com.whc.noteserver.result.LayPage;
import com.whc.noteserver.service.NoteBookService;
import com.whc.noteserver.util.JsonResult;

@Controller // 注解，组件扫描加入到spring容器中
@RequestMapping("/notebook") // 类controller的映射路径
public class NoteBookController {

	@Autowired
	NoteBookService noteBookService;

	/**
	 * 获取笔记本信息
	 * 
	 * @return
	 */
	@RequestMapping("/getnotebook")
	@ResponseBody
	public JsonResult getNoteBook(NoteBookParam param) {

		param.setPage((param.getPage() - 1) * param.getLimit());
		// System.out.println("page:"+page+" limit:"+limit);
		List<NoteBook> list = noteBookService.getNoteBook(param);
		int count = noteBookService.getCount(param);
		// 构建一个对象
		LayPage lp = new LayPage();
		lp.setCount(count);
		lp.setList(list);

		return new JsonResult(JsonResult.STATE_SUCCESS, "", lp);
	}

	/**
	 * 根据用户id获取笔记本信息
	 * 
	 * @param param
	 * @return
	 */
	@RequestMapping("/getnotebookbyuserid")
	@ResponseBody
	public JsonResult getAllNoteBookByUserId(NoteBookParam param) {
		List<NoteBook> list = noteBookService.getAllNoteBookByUserId(param);
		return new JsonResult(JsonResult.STATE_SUCCESS, "", list);
	}

	/**
	 * 添加笔记本
	 * 
	 * @return
	 */
	@RequestMapping("/addnotebook")
	@ResponseBody
	public JsonResult addNoteBook(NoteBook noteBook) {

		noteBook.setId(UUID.randomUUID().toString());
		noteBook.setAddtime(System.currentTimeMillis());
		noteBook.setIsdelete(0);
		// noteBook.setUserid();
		int result = noteBookService.addNoteBook(noteBook);
		if (result == 1) {
			return new JsonResult(JsonResult.STATE_SUCCESS, "添加成功", null);
		} else {
			return new JsonResult(JsonResult.STATE_ERROR, "添加失败", null);
		}
	}

	/**
	 * 获取单个笔记本信息
	 * 
	 * @return
	 */
	@RequestMapping("/getdetail")
	@ResponseBody
	public JsonResult getNoteBookDetail(NoteBook noteBook) {
		List<NoteBook> list = noteBookService.getNoteBookDetail(noteBook);
		if (list != null && !list.isEmpty()) {
			return new JsonResult(JsonResult.STATE_SUCCESS, "", list.get(0));
		} else {
			return new JsonResult(JsonResult.STATE_ERROR, "未查询到笔记本", null);
		}

	}

	/**
	 * 修改笔记本
	 * 
	 * @return
	 */
	@RequestMapping("/updatenotebook")
	@ResponseBody
	public JsonResult updateNoteBook(NoteBook noteBook) {
		int result = noteBookService.updateNoteBook(noteBook);
		if (result == 1) {
			return new JsonResult(JsonResult.STATE_SUCCESS, "修改成功", null);
		} else {
			return new JsonResult(JsonResult.STATE_ERROR, "修改失败", null);
		}
	}

	/**
	 * 删除笔记本
	 * 
	 * @return
	 */
	@RequestMapping("/deletenotebook")
	@ResponseBody
	public JsonResult deleteNoteBook(NoteBook noteBook) {
		int result = noteBookService.deleteNoteBook(noteBook);
		if (result == 1) {
			return new JsonResult(JsonResult.STATE_SUCCESS, "删除成功", null);
		} else {
			return new JsonResult(JsonResult.STATE_ERROR, "删除失败", null);
		}
	}

}
