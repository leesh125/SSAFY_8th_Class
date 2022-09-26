package com.ssafy.test.model.service;

import java.sql.SQLException;
import java.util.List;

import com.ssafy.test.model.Note;
import com.ssafy.test.model.dao.NoteDAO;

public class NoteService {

	private NoteDAO noteDAO = new NoteDAO();
	
	public boolean insertNote(Note note) throws SQLException {
		return noteDAO.insertProduct(note) > 0;
	}

	public List<Note> getLists() throws SQLException {
		return noteDAO.getList();
	}

	public Note getNote(String noteCode) throws SQLException {
		return noteDAO.getNote(noteCode);
	}

	public boolean delete(String noteCode) throws SQLException {
		return noteDAO.delete(noteCode) > 0;
	}

}
