package com.xiaobai.loT.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import java.io.Serializable;
import java.util.Date;

import lombok.Data;

/**
 * 设备注册表
 *
 * @author chen
 * @email sunlightcs@gmail.com
 * @date 2020-09-14 08:46:44
 */
@Data
@TableName("t_device")
public class TDeviceEntity implements Serializable {
    private static final long serialVersionUID = 1L;

    /**
     * $column.comments
     */
    @TableId
    private Integer id;
    /**
     * $column.comments
     */
    private String dataUuid;
    /**
     * $column.comments
     */
    private String category;
    /**
     * $column.comments
     */
    private String deviceId;
    /**
     * $column.comments
     */
    private Integer registerState;
    /**
     * $column.comments
     */
    private Date registerTime;
    /**
     * $column.comments
     */
    private String province;
    /**
     * $column.comments
     */
    private String city;
    /**
     * $column.comments
     */
    private String area;
    /**
     * $column.comments
     */
    private String address;
    /**
     * $column.comments
     */
    private String hotelName;
    /**
     * $column.comments
     */
    private String roomNo;
    /**
     * $column.comments
     */
    private Date lastCheckTime;
    /**
     * $column.comments
     */
    private String lastCheckIp;
    /**
     * $column.comments
     */
    private String remark;
    /**
     * $column.comments
     */
    private Date createTime;
    /**
     * $column.comments
     */
    private Date updateTime;

}
