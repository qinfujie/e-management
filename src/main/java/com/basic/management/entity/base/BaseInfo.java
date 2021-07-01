package com.basic.management.entity.base;
import com.basic.management.vo.LoginInfo;
import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import javax.persistence.*;
import java.util.Date;

/**
 * 基础类
 *
 * @author fujie
 */
@Data
@MappedSuperclass
public class BaseInfo {

    /**
     * 创建人
     */
    @ApiModelProperty(value = "创建人名称",notes = "创建人名称")
    @Column(columnDefinition = "varchar(32) comment '创建人名称'")
    private String createName;

    /**
     * 创建人编号
     */
    @ApiModelProperty(value = "创建人编号",notes = "创建人编号")
    @Column(columnDefinition = "varchar(32) comment '创建人编号'")
    private String createNo;

    /**
     * 修改人
     */
    @ApiModelProperty(value = "修改人名称",notes = "修改人名称")
    @Column(columnDefinition = "varchar(32) comment '修改人名称'")
    private String updateName;

    /**
     * 修改人编号
     */
    @ApiModelProperty(value = "创建人编号",notes = "创建人编号")
    @Column(columnDefinition = "varchar(32) comment '创建人编号'")
    private String updateNo;

    /**
     * 创建时间
     */
    @JsonFormat(timezone = "GMT+8", pattern = "yyyy-MM-dd hh:mm:ss")
    @ApiModelProperty(value = "创建时间",notes = "创建时间")
    @Column(columnDefinition = "datetime comment '创建时间'")
    private Date createTime;

    /**
     * 修改时间
     */
    @JsonFormat(timezone = "GMT+8", pattern = "yyyy-MM-dd hh:mm:ss")
    @ApiModelProperty(value = "修改时间",notes = "修改时间")
    @Column(columnDefinition = "datetime comment '修改时间'")
    private Date updateTime;

    @PrePersist
    protected void prePersist() {
        Date now = new Date();
        if (createTime == null) {
            createTime = now;
            createNo = LoginInfo.getUserNo();
            createName = LoginInfo.getUserName();
        }

        if (updateTime == null) {
            updateTime = now;
        }
    }

    @PreUpdate
    protected void preUpdate() {
        updateTime = new Date();
        updateNo = LoginInfo.getUserNo();
        updateName = LoginInfo.getUserName();
    }

}
