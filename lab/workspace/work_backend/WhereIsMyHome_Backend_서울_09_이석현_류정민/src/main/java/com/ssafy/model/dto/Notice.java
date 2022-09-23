package com.ssafy.model.dto;

public class Notice {

	private int noticeid;
	private String title;
	private String content;
	private String date_time;
	private int hit;
	
	public Notice(int noticeId, String title, String content, String date_time, int hit) {
		this.noticeid = noticeId;
		this.title = title;
		this.content = content;
		this.date_time = date_time;
		this.hit = hit;
	}
	
	public Notice(String title, String content, String date_time, int hit) {
		this.title = title;
		this.content = content;
		this.date_time = date_time;
		this.hit = hit;
	}

	public int getNoticeId() {
		return noticeid;
	}
	public void setNoticeId(int noticeId) {
		this.noticeid = noticeId;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getDate_time() {
		return date_time;
	}
	public void setDate_time(String date_time) {
		this.date_time = date_time;
	}
	public int getHit() {
		return hit;
	}
	public void setHit(int hit) {
		this.hit = hit;
	}
}
