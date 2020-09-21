package com.xiaobai.wx.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/****
 * @Author:shenkunlin
 * @Description:TWxMenu构建
 * @Date 2019/6/14 19:13
 *****/
@ApiModel(description = "TWxMenu", value = "TWxMenu")
@Table(name = "t_wx_menu")
public class TWxMenu implements Serializable {

    @ApiModelProperty(value = "", required = false)
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;//

    @ApiModelProperty(value = "", required = false)
    @Column(name = "menu_text")
    private String menuText;//

    @ApiModelProperty(value = "", required = false)
    @Column(name = "data_uuid")
    private String dataUuid;//

    @ApiModelProperty(value = "", required = false)
    @Column(name = "remark")
    private String remark;//

    @ApiModelProperty(value = "", required = false)
    @Column(name = "create_time")
    private Date createTime;//

    @ApiModelProperty(value = "", required = false)
    @Column(name = "update_time")
    private Date updateTime;//
    @ApiModelProperty(value = "", required = false)
    @Column(name = "category")
    private Integer category;


    //get方法
    public Integer getId() {
        return id;
    }

    //set方法
    public void setId(Integer id) {
        this.id = id;
    }

    //get方法
    public String getMenuText() {
        return menuText;
    }

    //set方法
    public void setMenuText(String menuText) {
        this.menuText = menuText;
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
