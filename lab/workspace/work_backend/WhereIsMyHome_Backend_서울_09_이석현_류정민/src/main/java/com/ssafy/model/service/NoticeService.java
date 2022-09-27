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

<<<<<<< HEAD
	public boolean update(String noticeId, String title, String content) throws SQLException { 
		return noticeDAO.updateNotice(noticeId,title,content) > 0;
	}

	public boolean delete(String noticeId) throws SQLException {
		return noticeDAO.deleteNotice(noticeId) > 0;
	}

	public boolean register(String title, String content) throws SQLException {
		return noticeDAO.registerNotice(title,content) > 0;
	}

=======
<<<<<<< HEAD
	public boolean update(String noticeId, String title, String content) throws SQLException { 
		return noticeDAO.updateNotice(noticeId,title,content) > 0;
	}

	public boolean delete(String noticeId) throws SQLException {
		return noticeDAO.deleteNotice(noticeId) > 0;
	}

	public boolean register(String title, String content) throws SQLException {
		return noticeDAO.registerNotice(title,content) > 0;
	}

=======
>>>>>>> branch 'master' of https://github.com/leesh125/SSAFY_8th_Class
>>>>>>> refs/remotes/origin/master
}
