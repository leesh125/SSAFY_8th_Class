package com.ssafy.controller;

import java.sql.SQLException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ssafy.model.dto.DataInfo;
<<<<<<< HEAD
=======
import com.ssafy.model.dto.Notice;
import com.ssafy.model.dto.PageInfo;
import com.ssafy.model.service.NoticeService;

public class NoticeController implements Controller{

	private NoticeService noticeService = new NoticeService();
	
	@Override
	public Object handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String url = request.getServletPath();
		
		if(url.equals("/notice/notice.do")) {
			return getNotices(request, response);
		}else if(url.equals("/notice/noticeDetail.do")) {
			return detail(request, response);
		}else if(url.equals("/notice/noticeUpdate_form.do")) {
			return updateForm(request, response);
		}else if(url.equals("/notice/modify.do")) {
			return modify(request, response);
		}else if(url.equals("/notice/delete.do")) {
			return delete(request, response);
		}else if(url.equals("/notice/registerForm.do")) {
			return registerForm(request, response);
		}else if(url.equals("/notice/register.do")) {
			return register(request, response);
		}
		
		return null;
	}

	private PageInfo register(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String title = request.getParameter("title");
		String content = request.getParameter("content");
		
		boolean isUpdated = noticeService.register(title,content);		
		request.setAttribute("isUpdated", isUpdated);
		return new PageInfo(false, "/notice/notice.do");
	}

	private PageInfo registerForm(HttpServletRequest request, HttpServletResponse response) {
		return new PageInfo(true, "/notice/noticeRegister.jsp");
	}

	private DataInfo delete(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String noticeId = request.getParameter("noticeId");

		boolean isDeleted = noticeService.delete(noticeId);		
		request.setAttribute("isDeleted", isDeleted);
		
		
		return new DataInfo("application/json", isDeleted);
	}

	private DataInfo modify(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String noticeId = request.getParameter("noticeId");
		String title = request.getParameter("title");
		String content = request.getParameter("content");
		
		boolean isUpdated = noticeService.update(noticeId, title,content);		
		request.setAttribute("isUpdated", isUpdated);
		
		
		return new DataInfo("application/json", isUpdated);
	}

	private PageInfo updateForm(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String noticeId = request.getParameter("noticeid");
		Notice notice = noticeService.getNotice(noticeId);
		System.out.println(notice.getTitle());
		request.setAttribute("notice", notice);
		
		return new PageInfo(true, "/notice/noticeUpdate.jsp");
	}

	private PageInfo detail(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String noticeId = request.getParameter("noticeid");
		Notice notice = noticeService.getNotice(noticeId);
		request.setAttribute("notice", notice);
		
		return new PageInfo(true, "/notice/noticeDetail.jsp");
	}

	private PageInfo getNotices(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		List<Notice> notices = noticeService.getNotices();
		request.setAttribute("notices", notices);
		return new PageInfo(true, "/notice/notice.jsp");
	}
	
	private DataInfo update(HttpServletRequest request, HttpServletResponse response) {
//		String userId = request.getParameter("userId");
//		String password = request.getParameter("password");
//		String username = request.getParameter("username");
//		String address = request.getParameter("address");
//		
//		boolean isUpdated = userService.update(userId, password,username,address);		
//		request.setAttribute("isUpdated", isUpdated);
//		
//		
//		return new DataInfo("application/json", isUpdated);
		return null;
	}
}
package com.ssafy.controller;

import java.sql.SQLException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ssafy.model.dto.Notice;
import com.ssafy.model.dto.PageInfo;
import com.ssafy.model.service.NoticeService;

public class NoticeController implements Controller{

	private NoticeService noticeService = new NoticeService();
	
	@Override
	public Object handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String url = request.getServletPath();
		
		if(url.equals("/notice/notice.do")) {
			return getNotices(request, response);
		}else if(url.equals("/notice/noticeDetail.do")) {
			return detail(request, response);
		}
		
		return null;
	}

	private PageInfo detail(HttpServletRequest request, HttpServletResponse response) throws Exception {
		System.out.println("노티스 호출!");
		String noticeId = request.getParameter("noticeid");
		Notice notice = noticeService.getNotice(noticeId);
		request.setAttribute("notice", notice);
		
		return new PageInfo(true, "/notice/noticeDetail.jsp");
	}

	private PageInfo getNotices(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		List<Notice> notices = noticeService.getNotices();
		request.setAttribute("notices", notices);
		return new PageInfo(true, "/notice/notice.jsp");
	}

}
package com.ssafy.controller;

import java.sql.SQLException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ssafy.model.dto.Notice;
import com.ssafy.model.dto.PageInfo;
import com.ssafy.model.service.NoticeService;

public class NoticeController implements Controller{

	private NoticeService noticeService = new NoticeService();
	
	@Override
	public Object handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String url = request.getServletPath();
		
		if(url.equals("/notice/notice.do")) {
			return getNotices(request, response);
		}else if(url.equals("/notice/noticeDetail.do")) {
			return detail(request, response);
		}
		
		return null;
	}

	private PageInfo detail(HttpServletRequest request, HttpServletResponse response) throws Exception {
		System.out.println("노티스 호출!");
		String noticeId = request.getParameter("noticeid");
		Notice notice = noticeService.getNotice(noticeId);
		request.setAttribute("notice", notice);
		
		return new PageInfo(true, "/notice/noticeDetail.jsp");
	}

	private PageInfo getNotices(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		List<Notice> notices = noticeService.getNotices();
		request.setAttribute("notices", notices);
		return new PageInfo(true, "/notice/notice.jsp");
	}

}
package com.ssafy.controller;

import java.sql.SQLException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ssafy.model.dto.Notice;
import com.ssafy.model.dto.PageInfo;
import com.ssafy.model.service.NoticeService;

public class NoticeController implements Controller{

	private NoticeService noticeService = new NoticeService();
	
	@Override
	public Object handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String url = request.getServletPath();
		
		if(url.equals("/notice/notice.do")) {
			return getNotices(request, response);
		}else if(url.equals("/notice/noticeDetail.do")) {
			return detail(request, response);
		}
		
		return null;
	}

	private PageInfo detail(HttpServletRequest request, HttpServletResponse response) throws Exception {
		System.out.println("노티스 호출!");
		String noticeId = request.getParameter("noticeid");
		Notice notice = noticeService.getNotice(noticeId);
		request.setAttribute("notice", notice);
		
		return new PageInfo(true, "/notice/noticeDetail.jsp");
	}

	private PageInfo getNotices(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		List<Notice> notices = noticeService.getNotices();
		request.setAttribute("notices", notices);
		return new PageInfo(true, "/notice/notice.jsp");
	}

}
package com.ssafy.controller;

import java.sql.SQLException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ssafy.model.dto.Notice;
import com.ssafy.model.dto.PageInfo;
import com.ssafy.model.service.NoticeService;

public class NoticeController implements Controller{

	private NoticeService noticeService = new NoticeService();
	
	@Override
	public Object handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String url = request.getServletPath();
		
		if(url.equals("/notice/notice.do")) {
			return getNotices(request, response);
		}else if(url.equals("/notice/noticeDetail.do")) {
			return detail(request, response);
		}
		
		return null;
	}

	private PageInfo detail(HttpServletRequest request, HttpServletResponse response) throws Exception {
		System.out.println("노티스 호출!");
		String noticeId = request.getParameter("noticeid");
		Notice notice = noticeService.getNotice(noticeId);
		request.setAttribute("notice", notice);
		
		return new PageInfo(true, "/notice/noticeDetail.jsp");
	}

	private PageInfo getNotices(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		List<Notice> notices = noticeService.getNotices();
		request.setAttribute("notices", notices);
		return new PageInfo(true, "/notice/notice.jsp");
	}

}
package com.ssafy.controller;

import java.sql.SQLException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ssafy.model.dto.Notice;
import com.ssafy.model.dto.PageInfo;
import com.ssafy.model.service.NoticeService;

public class NoticeController implements Controller{

	private NoticeService noticeService = new NoticeService();
	
	@Override
	public Object handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String url = request.getServletPath();
		
		if(url.equals("/notice/notice.do")) {
			return getNotices(request, response);
		}else if(url.equals("/notice/noticeDetail.do")) {
			return detail(request, response);
		}
		
		return null;
	}

	private PageInfo detail(HttpServletRequest request, HttpServletResponse response) throws Exception {
		System.out.println("노티스 호출!");
		String noticeId = request.getParameter("noticeid");
		Notice notice = noticeService.getNotice(noticeId);
		request.setAttribute("notice", notice);
		
		return new PageInfo(true, "/notice/noticeDetail.jsp");
	}

	private PageInfo getNotices(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		List<Notice> notices = noticeService.getNotices();
		request.setAttribute("notices", notices);
		return new PageInfo(true, "/notice/notice.jsp");
	}

}
package com.ssafy.controller;

import java.sql.SQLException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ssafy.model.dto.Notice;
import com.ssafy.model.dto.PageInfo;
import com.ssafy.model.service.NoticeService;

public class NoticeController implements Controller{

	private NoticeService noticeService = new NoticeService();
	
	@Override
	public Object handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String url = request.getServletPath();
		
		if(url.equals("/notice/notice.do")) {
			return getNotices(request, response);
		}else if(url.equals("/notice/noticeDetail.do")) {
			return detail(request, response);
		}
		
		return null;
	}

	private PageInfo detail(HttpServletRequest request, HttpServletResponse response) throws Exception {
		System.out.println("노티스 호출!");
		String noticeId = request.getParameter("noticeid");
		Notice notice = noticeService.getNotice(noticeId);
		request.setAttribute("notice", notice);
		
		return new PageInfo(true, "/notice/noticeDetail.jsp");
	}

	private PageInfo getNotices(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		List<Notice> notices = noticeService.getNotices();
		request.setAttribute("notices", notices);
		return new PageInfo(true, "/notice/notice.jsp");
	}

}
package com.ssafy.controller;

import java.sql.SQLException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ssafy.model.dto.Notice;
import com.ssafy.model.dto.PageInfo;
import com.ssafy.model.service.NoticeService;

public class NoticeController implements Controller{

	private NoticeService noticeService = new NoticeService();
	
	@Override
	public Object handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String url = request.getServletPath();
		
		if(url.equals("/notice/notice.do")) {
			return getNotices(request, response);
		}else if(url.equals("/notice/noticeDetail.do")) {
			return detail(request, response);
		}
		
		return null;
	}

	private PageInfo detail(HttpServletRequest request, HttpServletResponse response) throws Exception {
		System.out.println("노티스 호출!");
		String noticeId = request.getParameter("noticeid");
		Notice notice = noticeService.getNotice(noticeId);
		request.setAttribute("notice", notice);
		
		return new PageInfo(true, "/notice/noticeDetail.jsp");
	}

	private PageInfo getNotices(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		List<Notice> notices = noticeService.getNotices();
		request.setAttribute("notices", notices);
		return new PageInfo(true, "/notice/notice.jsp");
	}

}
package com.ssafy.controller;

import java.sql.SQLException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ssafy.model.dto.Notice;
import com.ssafy.model.dto.PageInfo;
import com.ssafy.model.service.NoticeService;

public class NoticeController implements Controller{

	private NoticeService noticeService = new NoticeService();
	
	@Override
	public Object handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String url = request.getServletPath();
		
		if(url.equals("/notice/notice.do")) {
			return getNotices(request, response);
		}else if(url.equals("/notice/noticeDetail.do")) {
			return detail(request, response);
		}
		
		return null;
	}

	private PageInfo detail(HttpServletRequest request, HttpServletResponse response) throws Exception {
		System.out.println("노티스 호출!");
		String noticeId = request.getParameter("noticeid");
		Notice notice = noticeService.getNotice(noticeId);
		request.setAttribute("notice", notice);
		
		return new PageInfo(true, "/notice/noticeDetail.jsp");
	}

	private PageInfo getNotices(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		List<Notice> notices = noticeService.getNotices();
		request.setAttribute("notices", notices);
		return new PageInfo(true, "/notice/notice.jsp");
	}

}
package com.ssafy.controller;

import java.sql.SQLException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ssafy.model.dto.Notice;
import com.ssafy.model.dto.PageInfo;
import com.ssafy.model.service.NoticeService;

public class NoticeController implements Controller{

	private NoticeService noticeService = new NoticeService();
	
	@Override
	public Object handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String url = request.getServletPath();
		
		if(url.equals("/notice/notice.do")) {
			return getNotices(request, response);
		}else if(url.equals("/notice/noticeDetail.do")) {
			return detail(request, response);
		}
		
		return null;
	}

	private PageInfo detail(HttpServletRequest request, HttpServletResponse response) throws Exception {
		System.out.println("노티스 호출!");
		String noticeId = request.getParameter("noticeid");
		Notice notice = noticeService.getNotice(noticeId);
		request.setAttribute("notice", notice);
		
		return new PageInfo(true, "/notice/noticeDetail.jsp");
	}

	private PageInfo getNotices(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		List<Notice> notices = noticeService.getNotices();
		request.setAttribute("notices", notices);
		return new PageInfo(true, "/notice/notice.jsp");
	}

}
package com.ssafy.controller;

import java.sql.SQLException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ssafy.model.dto.Notice;
import com.ssafy.model.dto.PageInfo;
import com.ssafy.model.service.NoticeService;

public class NoticeController implements Controller{

	private NoticeService noticeService = new NoticeService();
	
	@Override
	public Object handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String url = request.getServletPath();
		
		if(url.equals("/notice/notice.do")) {
			return getNotices(request, response);
		}else if(url.equals("/notice/noticeDetail.do")) {
			return detail(request, response);
		}
		
		return null;
	}

	private PageInfo detail(HttpServletRequest request, HttpServletResponse response) throws Exception {
		System.out.println("노티스 호출!");
		String noticeId = request.getParameter("noticeid");
		Notice notice = noticeService.getNotice(noticeId);
		request.setAttribute("notice", notice);
		
		return new PageInfo(true, "/notice/noticeDetail.jsp");
	}

	private PageInfo getNotices(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		List<Notice> notices = noticeService.getNotices();
		request.setAttribute("notices", notices);
		return new PageInfo(true, "/notice/notice.jsp");
	}

}
package com.ssafy.controller;

import java.sql.SQLException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

>>>>>>> refs/remotes/origin/master
import com.ssafy.model.dto.Notice;
import com.ssafy.model.dto.PageInfo;
import com.ssafy.model.service.NoticeService;

public class NoticeController implements Controller{

	private NoticeService noticeService = new NoticeService();
	
	@Override
	public Object handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String url = request.getServletPath();
		
		if(url.equals("/notice/notice.do")) {
			return getNotices(request, response);
		}else if(url.equals("/notice/noticeDetail.do")) {
			return detail(request, response);
		}else if(url.equals("/notice/noticeUpdate_form.do")) {
			return updateForm(request, response);
		}else if(url.equals("/notice/modify.do")) {
			return modify(request, response);
		}else if(url.equals("/notice/delete.do")) {
			return delete(request, response);
		}else if(url.equals("/notice/registerForm.do")) {
			return registerForm(request, response);
		}else if(url.equals("/notice/register.do")) {
			return register(request, response);
		}
		
		return null;
	}

	private PageInfo register(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String title = request.getParameter("title");
		String content = request.getParameter("content");
		
		boolean isUpdated = noticeService.register(title,content);		
		request.setAttribute("isUpdated", isUpdated);
		return new PageInfo(false, "/notice/notice.do");
	}

	private PageInfo registerForm(HttpServletRequest request, HttpServletResponse response) {
		return new PageInfo(true, "/notice/noticeRegister.jsp");
	}

	private DataInfo delete(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String noticeId = request.getParameter("noticeId");

		boolean isDeleted = noticeService.delete(noticeId);		
		request.setAttribute("isDeleted", isDeleted);
		
		
		return new DataInfo("application/json", isDeleted);
	}

	private DataInfo modify(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String noticeId = request.getParameter("noticeId");
		String title = request.getParameter("title");
		String content = request.getParameter("content");
		
		boolean isUpdated = noticeService.update(noticeId, title,content);		
		request.setAttribute("isUpdated", isUpdated);
		
		
		return new DataInfo("application/json", isUpdated);
	}

	private PageInfo updateForm(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String noticeId = request.getParameter("noticeid");
		Notice notice = noticeService.getNotice(noticeId);
		System.out.println(notice.getTitle());
		request.setAttribute("notice", notice);
		
		return new PageInfo(true, "/notice/noticeUpdate.jsp");
	}

	private PageInfo detail(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String noticeId = request.getParameter("noticeid");
		Notice notice = noticeService.getNotice(noticeId);
		request.setAttribute("notice", notice);
		
		return new PageInfo(true, "/notice/noticeDetail.jsp");
	}

	private PageInfo getNotices(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		List<Notice> notices = noticeService.getNotices();
		request.setAttribute("notices", notices);
		return new PageInfo(true, "/notice/notice.jsp");
	}
	
	private DataInfo update(HttpServletRequest request, HttpServletResponse response) {
//		String userId = request.getParameter("userId");
//		String password = request.getParameter("password");
//		String username = request.getParameter("username");
//		String address = request.getParameter("address");
//		
//		boolean isUpdated = userService.update(userId, password,username,address);		
//		request.setAttribute("isUpdated", isUpdated);
//		
//		
//		return new DataInfo("application/json", isUpdated);
		return null;
	}
}
