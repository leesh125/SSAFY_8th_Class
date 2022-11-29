package com.ssafy.test.controller;

import java.sql.SQLException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ssafy.test.dto.PageInfo;
import com.ssafy.test.model.Note;
import com.ssafy.test.model.service.NoteService;

public class NoteController implements Controller {

	private NoteService noteService = new NoteService();
	
	@Override
	public Object handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String url = request.getServletPath();
		
		if(url.equals("/note/registerForm.do")) {
			return registNote(request, response);
		}else if(url.equals("/note/register.do")) {
			return register(request, response);
		}else if(url.equals("/note/list.do")) {
			return getNotes(request, response);
		}else if(url.equals("/note/detail.do")) {
			return getNote(request, response);
		}else if(url.equals("/note/delete.do")) {
			return delete(request, response);
		}
		return null;
	}

	private PageInfo delete(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String noteCode = request.getParameter("noteCode");

		boolean isDeleted = noteService.delete(noteCode);		
		request.setAttribute("isDeleted", isDeleted);
		return new PageInfo(true, "/note/list.do");
	}

	private PageInfo getNote(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String noteCode = request.getParameter("noteCode");
		Note note = noteService.getNote(noteCode);
		request.setAttribute("note", note);
		return new PageInfo(true, "/note/detailNote.jsp");
	}

	private PageInfo getNotes(HttpServletRequest request, HttpServletResponse response) throws Exception {
		List<Note> notes = noteService.getLists();
		request.setAttribute("notes", notes);
		return new PageInfo(true, "/note/listNote.jsp");
	}

	private PageInfo register(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String noteCode = request.getParameter("noteCode");
		String model = request.getParameter("model");
		int price = Integer.parseInt(request.getParameter("price"));
		String company = request.getParameter("company");
		
		boolean res = noteService.insertNote(new Note(noteCode,model,price,company));
		
		if(res) {
			request.setAttribute("successMsg", "상품 등록에 성공하였습니다.");
			return new PageInfo(false, "/note/list.do");
		}else {
			request.setAttribute("errorMsg", "상품 등록에 실패하였습니다.");
			return new PageInfo(true, "/note/regiter.jsp");
		}
	}

	private PageInfo registNote(HttpServletRequest request, HttpServletResponse response) {
		return new PageInfo(true,"/note/registNote.jsp");
	}

}
