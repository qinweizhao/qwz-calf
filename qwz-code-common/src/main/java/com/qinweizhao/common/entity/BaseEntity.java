package com.qinweizhao.common.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * @author qinweizhao
 * @date 2021/7/19
 */
public class BaseEntity implements Serializable {

    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    private LocalDateTime created;

    private LocalDateTime updated;

    private Integer status;
}
