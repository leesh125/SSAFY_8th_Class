package com.ssafy.model.service;

import java.sql.SQLException;
import java.util.List;

import com.ssafy.model.dao.NoticeDAO;
import com.ssafy.model.dto.Notice;

public class NoticeService {

	private NoticeDAO noticeDAO = new NoticeDAO();
	
	public List<Notice> getNotices() throws SQLException {
		return noticeDAO.getNotices();
	}

	public Notice getNotice(String noticeId) throws SQLException {
		return noticeDAO.getNotice(noticeId);
	}

}
