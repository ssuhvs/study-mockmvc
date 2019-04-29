package third.account.vo;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

/**
 * @Company: ebaifen
 * @author : sszvip
 * @version V3.0
 */
@SuppressWarnings("serial")
public class EbfBusinessAccountMini extends BaseModel{
	
	// 字段
	//columns START
	private Long id;
	private String account;
	private String password;
	private Long businessId;
	private Long storeId;
	private Long brandStoreId;
	private String auth;
	private String enableStatus;
	private java.util.Date insTime;
	private java.util.Date updTime;
	//columns END
	
	// 属性get,set
	public void setId(Long value) {
		this.id = value;
	}

	public Long getId() {
		return this.id;
	}
	public void setAccount(String value) {
		this.account = value;
	}

	public String getAccount() {
		return this.account;
	}
	public void setPassword(String value) {
		this.password = value;
	}

	public String getPassword() {
		return this.password;
	}
	public void setBusinessId(Long value) {
		this.businessId = value;
	}

	public Long getBusinessId() {
		return this.businessId;
	}
	public void setStoreId(Long value) {
		this.storeId = value;
	}

	public Long getStoreId() {
		return this.storeId;
	}
	public void setBrandStoreId(Long value) {
		this.brandStoreId = value;
	}

	public Long getBrandStoreId() {
		return this.brandStoreId;
	}
	public void setAuth(String value) {
		this.auth = value;
	}

	public String getAuth() {
		return this.auth;
	}
	public void setEnableStatus(String value) {
		this.enableStatus = value;
	}

	public String getEnableStatus() {
		return this.enableStatus;
	}
	public void setInsTime(java.util.Date value) {
		this.insTime = value;
	}

	public java.util.Date getInsTime() {
		return this.insTime;
	}
	public void setUpdTime(java.util.Date value) {
		this.updTime = value;
	}

	public java.util.Date getUpdTime() {
		return this.updTime;
	}

	public String toString() {
		return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
			.append("Id",getId())
			.append("Account",getAccount())
			.append("Password",getPassword())
			.append("BusinessId",getBusinessId())
			.append("StoreId",getStoreId())
			.append("BrandStoreId",getBrandStoreId())
			.append("Auth",getAuth())
			.append("EnableStatus",getEnableStatus())
			.append("InsTime",getInsTime())
			.append("UpdTime",getUpdTime())
			.toString();
	}
	
	public int hashCode() {
		return new HashCodeBuilder()
			.append(getId())
			.toHashCode();
	}
	
	public boolean equals(Object obj) {
		if(obj instanceof EbfBusinessAccountMini == false) return false;
		if(this == obj) return true;
		EbfBusinessAccountMini other = (EbfBusinessAccountMini)obj;
		return new EqualsBuilder()
			.append(getId(),other.getId())
			.isEquals();
	}
}

