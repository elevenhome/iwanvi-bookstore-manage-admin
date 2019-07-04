package com.iwanvi.bookstore.admin.domain.book;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.iwanvi.bookstore.admin.domain.BaseEntity;
import java.util.Date;

/**
 * 有声图书字典表 audio_book_dict_data
 * @author iwanvi
 * @date 2019-06-11
 */
public class AudioBookDictData extends BaseEntity{
	private static final long serialVersionUID = 1L;

	/** 编号 */
	private Integer id;
	/** 中文名称 */
	private String cnName;
	/** 英文名称 */
	private String enName;
	/** 字典类型:1业务，2应用，3平台，4渠道，5版本，6包名 */
	private String dictType;
	/** 创建时间 */
	private Date createDate;
	/** 修改时间 */
	private Date updateDate;
	/** 状态:1正常，0失效 */
	private Integer channelStatus;
	/** 创建人 */
	private String createBy;
	/** 备注 */
	private String remark;

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getId() {
		return id;
	}
	public void setCnName(String cnName) {
		this.cnName = cnName;
	}

	public String getCnName() {
		return cnName;
	}
	public void setEnName(String enName) {
		this.enName = enName;
	}

	public String getEnName() {
		return enName;
	}
	public void setDictType(String dictType) {
		this.dictType = dictType;
	}

	public String getDictType() {
		return dictType;
	}
	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	public Date getCreateDate() {
		return createDate;
	}
	public void setUpdateDate(Date updateDate) {
		this.updateDate = updateDate;
	}

	public Date getUpdateDate() {
		return updateDate;
	}
	public void setChannelStatus(Integer channelStatus) {
		this.channelStatus = channelStatus;
	}

	public Integer getChannelStatus() {
		return channelStatus;
	}
	public void setCreateBy(String createBy) {
		this.createBy = createBy;
	}

	public String getCreateBy() {
		return createBy;
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
            .append("cnName", getCnName())
            .append("enName", getEnName())
            .append("dictType", getDictType())
            .append("createDate", getCreateDate())
            .append("updateDate", getUpdateDate())
            .append("channelStatus", getChannelStatus())
            .append("createBy", getCreateBy())
            .append("remark", getRemark())
            .toString();
    }
}
