package com.lostvip.app.controller;

/**
 * @Company: ebaifen
 * @author : sszvip
 * @version V3.0
 */
public class YbfUserBase extends BaseEntity {
	// 字段
	//columns START
	private String idNumber;
	private String userName;
	private String openId;
	private String unionId;
	private String nickName;
	private String avatar;
	private String phone;
	private Long businessId;
	private Long brandStoreId;
	private String source;
	private String memberType;

	public String getIdNumber() {
		return idNumber;
	}

	public void setIdNumber(String idNumber) {
		this.idNumber = idNumber;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getOpenId() {
		return openId;
	}

	public void setOpenId(String openId) {
		this.openId = openId;
	}

	public String getUnionId() {
		return unionId;
	}

	public void setUnionId(String unionId) {
		this.unionId = unionId;
	}

	public String getNickName() {
		return nickName;
	}

	public void setNickName(String nickName) {
		this.nickName = nickName;
	}

	public String getAvatar() {
		return avatar;
	}

	public void setAvatar(String avatar) {
		this.avatar = avatar;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public Long getBusinessId() {
		return businessId;
	}

	public void setBusinessId(Long businessId) {
		this.businessId = businessId;
	}

	public Long getBrandStoreId() {
		return brandStoreId;
	}

	public void setBrandStoreId(Long brandStoreId) {
		this.brandStoreId = brandStoreId;
	}

	public String getSource() {
		return source;
	}

	public void setSource(String source) {
		this.source = source;
	}

	public String getMemberType() {
		return memberType;
	}

	public void setMemberType(String memberType) {
		this.memberType = memberType;
	}

}

