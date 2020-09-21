package com.xiaobai.wx.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/****
 * @Author:shenkunlin
 * @Description:TUserBinding构建
 * @Date 2019/6/14 19:13
 *****/
@ApiModel(description = "TUserBinding", value = "TUserBinding")
@Table(name = "t_user_binding")
public class TUserBinding implements Serializable {

    @ApiModelProperty(value = "", required = false)
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;//

    @ApiModelProperty(value = "", required = false)
    @Column(name = "data_uuid")
    private String dataUuid;//

    @ApiModelProperty(value = "用户UUID", required = false)
    @Column(name = "user_uuid")
    private String userUuid;//用户UUID

    @ApiModelProperty(value = "微信ID", required = false)
    @Column(name = "openid")
    private String openid;//微信ID

    @ApiModelProperty(value = "类别，比如微信、支付宝", required = false)
    @Column(name = "category")
    private String category;//类别，比如微信、支付宝

    @ApiModelProperty(value = "备注", required = false)
    @Column(name = "remark")
    private String remark;//备注

    @ApiModelProperty(value = "", required = false)
    @Column(name = "create_time")
    private Date createTime;//

    @ApiModelProperty(value = "", required = false)
    @Column(name = "update_time")
    private Date updateTime;//


    //get方法
    public Integer getId() {
        return id;
    }

    //set方法
    public void setId(Integer id) {
        this.id = id;
    }

    //get方法
    public String getDataUuid() {
        return dataUuid;
    }

    //set方法
    public void setDataUuid(String dataUuid) {
        this.dataUuid = dataUuid;
    }

    //get方法
    public String getUserUuid() {
        return userUuid;
    }

    //set方法
    public void setUserUuid(String userUuid) {
        this.userUuid = userUuid;
    }

    //get方法
    public String getOpenid() {
        return openid;
    }

    //set方法
    public void setOpenid(String openid) {
        this.openid = openid;
    }

    //get方法
    public String getCategory() {
        return category;
    }

    //set方法
    public void setCategory(String category) {
        this.category = category;
    }

    //get方法
    public String getRemark() {
        return remark;
    }

    //set方法
    public void setRemark(String remark) {
        this.remark = remark;
    }

    //get方法
    public Date getCreateTime() {
        return createTime;
    }

    //set方法
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    //get方法
    public Date getUpdateTime() {
        return updateTime;
    }

    //set方法
    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }


}
