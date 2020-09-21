package com.xiaobai.loT.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

/**
 * 商品分类表
 *
 * @author chen
 * @email sunlightcs@gmail.com
 * @date 2020-08-28 14:01:01
 */
@Data
@TableName("t_category")
public class TCategoryEntity implements Serializable {
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
    private String parentUuid;
    /**
     * $column.comments
     */
    private String categoryName;
    /**
     * $column.comments
     */
    private Integer enableFlag;
    /**
     * $column.comments
     */
    private Integer seqNo;
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
    /**
     * $column.comments
     */
    private Integer cateLevel;

    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    @TableField(exist = false)
    private List<TCategoryEntity> children;

}
