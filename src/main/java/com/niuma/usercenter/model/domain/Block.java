package com.niuma.usercenter.model.domain;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import java.io.Serializable;
import java.util.Date;

/**
 * 帖子板块
 * @TableName block
 */
@TableName(value ="block")
public class Block implements Serializable {
    /**
     * 主键ID
     */
    @TableId(type = IdType.AUTO)
    private Long id;

    /**
     * 板块名称
     */
    private String name;

    /**
     * 板块信息
     */
    private String info;

    /**
     * 创建时间
     */
    private Date createtime;

    /**
     * 更新时间
     */
    private Date updatetime;

    /**
     * 板块状态 0 = 可用 1 = 不可用
     */
    private Integer status;

    /**
     * 是否删除板块 0 =不删除 1 = 删除
     */
    private Integer isdelete;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;
}