package com.qinweizhao.system.module.system.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * <p>
 * 字典数据表
 * </p>
 *
 * @author qinweizhao
 * @since 2021-12-21
 */
@TableName("sys_dict_data")
@ApiModel(value = "SysDictData对象", description = "字典数据表")
public class SysDictData implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty("字典编码")
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    @ApiModelProperty("字典排序")
    private Integer sort;

    @ApiModelProperty("字典标签")
    private String label;

    @ApiModelProperty("字典键值")
    private String value;

    @ApiModelProperty("字典类型")
    private String dictType;

    @ApiModelProperty("状态（0正常 1停用）")
    private Integer status;

    @ApiModelProperty("备注")
    private String remark;

    @ApiModelProperty("创建者")
    private String creator;

    @ApiModelProperty("创建时间")
    private LocalDateTime createTime;

    @ApiModelProperty("更新者")
    private String updater;

    @ApiModelProperty("更新时间")
    private LocalDateTime updateTime;

    @ApiModelProperty("是否删除")
    private Boolean deleted;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getSort() {
        return sort;
    }

    public void setSort(Integer sort) {
        this.sort = sort;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public String getDictType() {
        return dictType;
    }

    public void setDictType(String dictType) {
        this.dictType = dictType;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public String getCreator() {
        return creator;
    }

    public void setCreator(String creator) {
        this.creator = creator;
    }

    public LocalDateTime getCreateTime() {
        return createTime;
    }

    public void setCreateTime(LocalDateTime createTime) {
        this.createTime = createTime;
    }

    public String getUpdater() {
        return updater;
    }

    public void setUpdater(String updater) {
        this.updater = updater;
    }

    public LocalDateTime getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(LocalDateTime updateTime) {
        this.updateTime = updateTime;
    }

    public Boolean getDeleted() {
        return deleted;
    }

    public void setDeleted(Boolean deleted) {
        this.deleted = deleted;
    }

    @Override
    public String toString() {
        return "SysDictData{" +
                "id=" + id +
                ", sort=" + sort +
                ", label=" + label +
                ", value=" + value +
                ", dictType=" + dictType +
                ", status=" + status +
                ", remark=" + remark +
                ", creator=" + creator +
                ", createTime=" + createTime +
                ", updater=" + updater +
                ", updateTime=" + updateTime +
                ", deleted=" + deleted +
                "}";
    }
}
