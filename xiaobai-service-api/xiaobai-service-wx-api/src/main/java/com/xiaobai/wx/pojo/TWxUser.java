package com.xiaobai.wx.pojo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/****
 * @Author:shenkunlin
 * @Description:TWxUser构建
 * @Date 2019/6/14 19:13
 *****/
@ApiModel(description = "TWxUser", value = "TWxUser")
@Table(name = "t_wx_user")
public class TWxUser implements Serializable {

    @ApiModelProperty(value = "", required = false)
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;//

    @ApiModelProperty(value = "", required = false)
    @Column(name = "open_id")
    private String openId;//

    @ApiModelProperty(value = "1,男2,女", required = false)
    @Column(name = "sex")
    private Integer sex;//1,男2,女

    @ApiModelProperty(value = "", required = false)
    @Column(name = "province")
    private String province;//

    @ApiModelProperty(value = "", required = false)
    @Column(name = "city")
    private String city;//

    @ApiModelProperty(value = "", required = false)
    @Column(name = "country")
    private String country;//

    @ApiModelProperty(value = "", required = false)
    @Column(name = "headimgurl")
    private String headimgurl;//

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
    @Column(name = "nickname")
    private String nickname;//

    @ApiModelProperty(value = "", required = false)
    @Column(name = "unionid")
    private String unionid;//

    public String getDataUuid() {
        return dataUuid;
    }

    public void setDataUuid(String dataUuid) {
        this.dataUuid = dataUuid;
    }

    @ApiModelProperty(value = "", required = false)
    @Column(name = "data_uuid")
    private String dataUuid;


    //get方法
    public Integer getId() {
        return id;
    }

    //set方法
    public void setId(Integer id) {
        this.id = id;
    }

    //get方法
    public String getOpenId() {
        return openId;
    }

    //set方法
    public void setOpenId(String openId) {
        this.openId = openId;
    }

    //get方法
    public Integer getSex() {
        return sex;
    }

    //set方法
    public void setSex(Integer sex) {
        this.sex = sex;
    }

    //get方法
    public String getProvince() {
        return province;
    }

    //set方法
    public void setProvince(String province) {
        this.province = province;
    }

    //get方法
    public String getCity() {
        return city;
    }

    //set方法
    public void setCity(String city) {
        this.city = city;
    }

    //get方法
    public String getCountry() {
        return country;
    }

    //set方法
    public void setCountry(String country) {
        this.country = country;
    }

    //get方法
    public String getHeadimgurl() {
        return headimgurl;
    }

    //set方法
    public void setHeadimgurl(String headimgurl) {
        this.headimgurl = headimgurl;
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

    //get方法
    public String getNickname() {
        return nickname;
    }

    //set方法
    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    //get方法
    public String getUnionid() {
        return unionid;
    }

    //set方法
    public void setUnionid(String unionid) {
        this.unionid = unionid;
    }


}
