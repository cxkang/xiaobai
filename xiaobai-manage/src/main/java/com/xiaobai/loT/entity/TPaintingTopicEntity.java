package com.xiaobai.loT.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import java.io.Serializable;
import java.util.Date;

import lombok.Data;

/**
 * 画作标签
 *
 * @author chen
 * @email sunlightcs@gmail.com
 * @date 2020-08-28 14:01:01
 */
@Data
@TableName("t_painting_topic")
public class TPaintingTopicEntity implements Serializable {
    private static final long serialVersionUID = 1L;

    /**
     * $column.comments
     */
    @TableId
    private Integer id;
    /**
     * $column.comments
     */
    private String dateUuid;
    /**
     * $column.comments
     */
    private String paintingUuid;
    /**
     * $column.comments
     */
    private String topicUuid;
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
