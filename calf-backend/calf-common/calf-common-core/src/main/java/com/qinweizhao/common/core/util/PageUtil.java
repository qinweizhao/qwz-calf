package com.qinweizhao.common.core.util;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.qinweizhao.common.core.request.PageQry;
import com.qinweizhao.common.core.request.Query;
import com.qinweizhao.common.core.request.Search;

/**
 * 分页工具类
 *
 * @author qinweizhao
 * @since 2021/11/18
 */
public class PageUtil {


    public static <T> Page<T> getPage(PageQry query) {
        return new Page<T>(query.getCurrent(), query.getSize());
    }
}
