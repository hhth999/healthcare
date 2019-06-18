package com.hk.healthcare.dto;

import java.sql.Date;

public class FreeboardDto {
	private int free_seq;
	private String free_title;
	private String free_content;
	private Date free_regdate;
	private String free_category;
	private int free_like;
	private int free_hate;
	private String id;
	private int free_view;
	public int getFree_seq() {
		return free_seq;
	}
	public void setFree_seq(int free_seq) {
		this.free_seq = free_seq;
	}
	public String getFree_title() {
		return free_title;
	}
	public void setFree_title(String free_title) {
		this.free_title = free_title;
	}
	public String getFree_content() {
		return free_content;
	}
	public void setFree_content(String free_content) {
		this.free_content = free_content;
	}
	public Date getFree_regdate() {
		return free_regdate;
	}
	public void setFree_regdate(Date free_regdate) {
		this.free_regdate = free_regdate;
	}
	public String getFree_category() {
		return free_category;
	}
	public void setFree_category(String free_category) {
		this.free_category = free_category;
	}
	public int getFree_like() {
		return free_like;
	}
	public void setFree_like(int free_like) {
		this.free_like = free_like;
	}
	public int getFree_hate() {
		return free_hate;
	}
	public void setFree_hate(int free_hate) {
		this.free_hate = free_hate;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public int getFree_view() {
		return free_view;
	}
	public void setFree_view(int free_view) {
		this.free_view = free_view;
	}
	@Override
	public String toString() {
		return "FreeboardDto [free_seq=" + free_seq + ", free_title=" + free_title + ", free_content=" + free_content
				+ ", free_regdate=" + free_regdate + ", free_category=" + free_category + ", free_like=" + free_like
				+ ", free_hate=" + free_hate + ", id=" + id + ", free_view=" + free_view + "]";
	}
	public FreeboardDto(int free_seq, String free_title, String free_content, Date free_regdate, String free_category,
			int free_like, int free_hate, String id, int free_view) {
		super();
		this.free_seq = free_seq;
		this.free_title = free_title;
		this.free_content = free_content;
		this.free_regdate = free_regdate;
		this.free_category = free_category;
		this.free_like = free_like;
		this.free_hate = free_hate;
		this.id = id;
		this.free_view = free_view;
	}
	public FreeboardDto() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
}
