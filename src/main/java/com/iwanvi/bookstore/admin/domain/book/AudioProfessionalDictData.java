package com.iwanvi.bookstore.admin.domain.book;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.iwanvi.bookstore.admin.domain.BaseEntity;

/**
 * 有声业务参数字典表 audio_professional_dict_data
 * @author iwanvi
 * @date 2019-06-11
 */
public class AudioProfessionalDictData extends BaseEntity{
	private static final long serialVersionUID = 1L;

	/** 编号 */
	private Integer id;
	/** 上级编号 */
	private Integer parentId;
	/** 书单编号 */
	private Integer bookListId;
	/** 渠道名 */
	private String channel;
	/** 业务名 */
	private String professional;
	/** 平台名 */
	private String platform;
	/** 应用名 */
	private String application;
	/** 包名 */
	private String packageName;
	/** 版本 */
	private String version;
	/** 状态：1正常，0失效 */
	private Integer channelStatus;
	/** 备注 */
	private String remark;

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getId() {
		return id;
	}
	public void setParentId(Integer parentId) {
		this.parentId = parentId;
	}

	public Integer getParentId() {
		return parentId;
	}
	public void setBookListId(Integer bookListId) {
		this.bookListId = bookListId;
	}

	public Integer getBookListId() {
		return bookListId;
	}
	public void setChannel(String channel) {
		this.channel = channel;
	}

	public String getChannel() {
		return channel;
	}
	public void setProfessional(String professional) {
		this.professional = professional;
	}

	public String getProfessional() {
		return professional;
	}
	public void setPlatform(String platform) {
		this.platform = platform;
	}

	public String getPlatform() {
		return platform;
	}
	public void setApplication(String application) {
		this.application = application;
	}

	public String getApplication() {
		return application;
	}
	public void setPackageName(String packageName) {
		this.packageName = packageName;
	}

	public String getPackageName() {
		return packageName;
	}
	public void setVersion(String version) {
		this.version = version;
	}

	public String getVersion() {
		return version;
	}
	public void setChannelStatus(Integer channelStatus) {
		this.channelStatus = channelStatus;
	}

	public Integer getChannelStatus() {
		return channelStatus;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}

	public String getRemark() {
		return remark;
	}

    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("parentId", getParentId())
            .append("bookListId", getBookListId())
            .append("channel", getChannel())
            .append("professional", getProfessional())
            .append("platform", getPlatform())
            .append("application", getApplication())
            .append("packageName", getPackageName())
            .append("version", getVersion())
            .append("channelStatus", getChannelStatus())
            .append("remark", getRemark())
            .toString();
    }
}
