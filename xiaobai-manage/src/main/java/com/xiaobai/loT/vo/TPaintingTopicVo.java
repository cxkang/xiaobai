package com.xiaobai.loT.vo;

import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

@Data
public class TPaintingTopicVo {
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
    private String topic;
    /**
     * $column.comments
     */
    private String paintingUrl;
    /**
     * $column.comments
     */
    private String remark;

    /**
     * 主题id
     */
    private String topicId;


}
