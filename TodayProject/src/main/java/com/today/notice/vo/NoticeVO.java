package com.today.notice.vo;

public class NoticeVO {

	//번호, 제목, 내용, 작성자, 작성일, 조회수, 비밀번호
	private long no, hit;
	private String title, content,writeDate, startDate, endDate, updateDate,id ;
	
	
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public long getHit() {
		return hit;
	}
	public void setHit(long hit) {
		this.hit = hit;
	}
	public long getNo() {
		return no;
	}
	public void setNo(long no) {
		this.no = no;
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
	public String getWriteDate() {
		return writeDate;
	}
	public void setWriteDate(String writeDate) {
		this.writeDate = writeDate;
	}
	public String getStartDate() {
		return startDate;
	}
	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}
	public String getEndDate() {
		return endDate;
	}
	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}
	public String getUpdateDate() {
		return updateDate;
	}
	public void setUpdateDate(String updateDate) {
		this.updateDate = updateDate;
	}
	@Override
	public String toString() {
		return "NoticeVO [no=" + no + ", hit=" + hit + ", title=" + title + ", content=" + content + ", writeDate="
				+ writeDate + ", startDate=" + startDate + ", endDate=" + endDate + ", updateDate=" + updateDate
				+ "]";
	}




	
	
	
}
