package com.qinweizhao.common.core.request;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * 搜索封装类
 *
 * @author qinweizhao
 * @since 2021/11/18
 */
@Data
@ApiModel(description = "搜索条件")
public class Search implements Serializable {

    /**
     * 关键词
     */
    @ApiModelProperty(value = "关键词")
    private String keyword;

    /**
     * 开始日期
     */
    @ApiModelProperty(hidden = true)
    private String beginTime;

    /**
     * 结束日期
     */
    @ApiModelProperty(hidden = true)
    private String endTime;

    /**
     * 当前页
     */
    @ApiModelProperty(value = "当前页")
    private Integer current = 1;

    /**
     * 每页的数量
     */
    @ApiModelProperty(value = "每页的数量")
    private Integer size = 10;


    @ApiModelProperty(value = "排序规则")
    private List<Search.Sort> sorts = new ArrayList<>();


    @Getter
    @Setter
    @ApiModel("排序元素载体")
    public static class Sort {

        /**
         * 排序字段
         */
        @ApiModelProperty(value = "排序字段")
        private String field;

        /**
         * 排序方式：asc,desc
         */
        @ApiModelProperty(hidden = true)
        private String order;

    }
}
