package com.xiaobai.loT.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import java.io.Serializable;
import java.util.Date;

import lombok.Data;

/**
 * 画作主题
 *
 * @author chen
 * @email sunlightcs@gmail.com
 * @date 2020-08-28 14:01:01
 */
@Data
@TableName("t_topic")
public class TTopicEntity implements Serializable {
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
    private String name;
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
