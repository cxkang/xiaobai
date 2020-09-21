package com.xiaobai.user.pojo;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/****
 *
 *用户
 *****/
//@ApiModel(description = "TUser",value = "TUser")
@Table(name = "t_user")
public class TUser implements Serializable {

    //	@ApiModelProperty(value = "用户id",required = false)
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;//用户id

    //	@ApiModelProperty(value = "用户uuid",required = false)
    @Column(name = "data_uuid")
    private String dataUuid;//用户uuid

    //	@ApiModelProperty(value = "用户名",required = false)
    @Column(name = "client_id")
    private String clientId;//用户名

    //	@ApiModelProperty(value = "密码",required = false)
    @Column(name = "client_password")
    private String clientPassword;//密码

    //	@ApiModelProperty(value = "昵称",required = false)
    @Column(name = "nickname")
    private String nickname;//昵称

    //	@ApiModelProperty(value = "性别",required = false)
    @Column(name = "sex")
    private String sex;//性别

    //	@ApiModelProperty(value = "生日",required = false)
    @Column(name = "birthday")
    private Date birthday;//生日

    //	@ApiModelProperty(value = "最后登录时间",required = false)
    @Column(name = "last_login")
    private Date lastLogin;//最后登录时间

    //	@ApiModelProperty(value = "最后登录IP",required = false)
    @Column(name = "last_ip")
    private String lastIp;//最后登录IP

    //	@ApiModelProperty(value = "最后登录设备ID",required = false)
    @Column(name = "last_device")
    private String lastDevice;//最后登录设备ID

    //	@ApiModelProperty(value = "头像图片地址",required = false)
    @Column(name = "head_url")
    private String headUrl;//头像图片地址

    //	@ApiModelProperty(value = "用户类别：A-普通用户；B-后台管理；C：第三方",required = false)
    @Column(name = "category")
    private String category;//用户类别：A-普通用户；B-后台管理；C：第三方

    //	@ApiModelProperty(value = "备注",required = false)
    @Column(name = "remark")
    private String remark;//备注

    //	@ApiModelProperty(value = "生成时间",required = false)
    @Column(name = "create_time")
    private Date createTime;//生成时间

    //	@ApiModelProperty(value = "修改时间",required = false)
    @Column(name = "update_time")
    private Date updateTime;//修改时间


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
    public String getClientId() {
        return clientId;
    }

    //set方法
    public void setClientId(String clientId) {
        this.clientId = clientId;
    }

    //get方法
    public String getClientPassword() {
        return clientPassword;
    }

    //set方法
    public void setClientPassword(String clientPassword) {
        this.clientPassword = clientPassword;
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
    public String getSex() {
        return sex;
    }

    //set方法
    public void setSex(String sex) {
        this.sex = sex;
    }

    //get方法
    public Date getBirthday() {
        return birthday;
    }

    //set方法
    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    //get方法
    public Date getLastLogin() {
        return lastLogin;
    }

    //set方法
    public void setLastLogin(Date lastLogin) {
        this.lastLogin = lastLogin;
    }

    //get方法
    public String getLastIp() {
        return lastIp;
    }

    //set方法
    public void setLastIp(String lastIp) {
        this.lastIp = lastIp;
    }

    //get方法
    public String getLastDevice() {
        return lastDevice;
    }

    //set方法
    public void setLastDevice(String lastDevice) {
        this.lastDevice = lastDevice;
    }

    //get方法
    public String getHeadUrl() {
        return headUrl;
    }

    //set方法
    public void setHeadUrl(String headUrl) {
        this.headUrl = headUrl;
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
