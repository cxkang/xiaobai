package com.xiaobai.loT.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import java.io.Serializable;
import java.util.Date;

import lombok.Data;

/**
 * 画作表
 *
 * @author chen
 * @email sunlightcs@gmail.com
 * @date 2020-08-28 14:01:00
 */
@Data
@TableName("t_painting")
public class TPaintingEntity implements Serializable {
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
    private String categoryUuid;
    /**
     * $column.comments
     */
    private String paintingName;
    /**
     * $column.comments
     */
    private String author;
    /**
     * $column.comments
     */
    private String paintingPeriod;
    /**
     * $column.comments
     */
    private String paintingOrientation;
    /**
     * $column.comments
     */
    private String description;
    /**
     * $column.comments
     */
    private String topicStr;
    /**
     * $column.comments
     */
    private String paintingUrl;
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
