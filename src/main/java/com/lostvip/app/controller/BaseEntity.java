package com.lostvip.app.controller;

import java.util.Date;

public abstract class BaseEntity implements java.io.Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * 主键id
	 */
	protected Long id;

	/** 删除标识 */
	protected Integer delFlg = 0;
	public Date insTime;	//
	
	public Date updTime;	//
	/**
	 * 方法：取得 int
	 * 
	 * @return: int 主键id
	 */
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Integer getDelFlg() {
		return delFlg;
	}

	public void setDelFlg(Integer delFlg) {
		this.delFlg = delFlg;
	}

	public Date getInsTime() {
		return insTime;
	}

	public void setInsTime(Date insTime) {
		this.insTime = insTime;
	}

	public Date getUpdTime() {
		return updTime;
	}

	public void setUpdTime(Date updTime) {
		this.updTime = updTime;
	}
}
