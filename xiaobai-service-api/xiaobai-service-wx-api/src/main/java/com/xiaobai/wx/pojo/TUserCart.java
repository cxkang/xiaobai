package com.xiaobai.wx.pojo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/****
 * @Author:shenkunlin
 * @Description:TUserCart构建
 * @Date 2019/6/14 19:13
 *****/
@ApiModel(description = "TUserCart", value = "TUserCart")
@Table(name = "t_user_cart")
public class TUserCart implements Serializable {

    @ApiModelProperty(value = "", required = false)
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;//

    @ApiModelProperty(value = "", required = false)
    @Column(name = "data_uuiid")
    private String dataUuiid;//

    @ApiModelProperty(value = "", required = false)
    @Column(name = "user_uuid")
    private String userUuid;//

    @ApiModelProperty(value = "", required = false)
    @Column(name = "goods_uuid")
    private String goodsUuid;//

    @ApiModelProperty(value = "", required = false)
    @Column(name = "spec_uuid")
    private String specUuid;//

    @ApiModelProperty(value = "", required = false)
    @Column(name = "goods_name")
    private String goodsName;//

    @ApiModelProperty(value = "", required = false)
    @Column(name = "goods_desc")
    private String goodsDesc;//

    @ApiModelProperty(value = "", required = false)
    @Column(name = "goods_price")
    private String goodsPrice;//

    @ApiModelProperty(value = "", required = false)
    @Column(name = "goods_qty")
    private Integer goodsQty;//

    @ApiModelProperty(value = "", required = false)
    @Column(name = "remark")
    private String remark;//

    @ApiModelProperty(value = "", required = false)
    @Column(name = "delete_flag")
    private Integer deleteFlag;//

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
    public String getDataUuiid() {
        return dataUuiid;
    }

    //set方法
    public void setDataUuiid(String dataUuiid) {
        this.dataUuiid = dataUuiid;
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
    public String getGoodsUuid() {
        return goodsUuid;
    }

    //set方法
    public void setGoodsUuid(String goodsUuid) {
        this.goodsUuid = goodsUuid;
    }

    //get方法
    public String getSpecUuid() {
        return specUuid;
    }

    //set方法
    public void setSpecUuid(String specUuid) {
        this.specUuid = specUuid;
    }

    //get方法
    public String getGoodsName() {
        return goodsName;
    }

    //set方法
    public void setGoodsName(String goodsName) {
        this.goodsName = goodsName;
    }

    //get方法
    public String getGoodsDesc() {
        return goodsDesc;
    }

    //set方法
    public void setGoodsDesc(String goodsDesc) {
        this.goodsDesc = goodsDesc;
    }

    //get方法
    public String getGoodsPrice() {
        return goodsPrice;
    }

    //set方法
    public void setGoodsPrice(String goodsPrice) {
        this.goodsPrice = goodsPrice;
    }

    //get方法
    public Integer getGoodsQty() {
        return goodsQty;
    }

    //set方法
    public void setGoodsQty(Integer goodsQty) {
        this.goodsQty = goodsQty;
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
    public Integer getDeleteFlag() {
        return deleteFlag;
    }

    //set方法
    public void setDeleteFlag(Integer deleteFlag) {
        this.deleteFlag = deleteFlag;
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
