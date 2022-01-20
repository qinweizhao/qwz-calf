package com.qinweizhao.common.core.request;

/**
 * Page Query Param
 *
 * @author qinweizhao
 * @since 2021/11/18
 */
public abstract class PageQry extends Query {
    public static final String ASC = "ASC";
    public static final String DESC = "DESC";
    private static final long serialVersionUID = 1L;
    private static final int DEFAULT_PAGE_SIZE = 10;

    private int size = DEFAULT_PAGE_SIZE;

    private int current = 1;

    private String orderBy;

    private String orderDirection = DESC;

    private String groupBy;

    private boolean needTotalCount = true;

    public int getCurrent() {
        return Math.max(current, 1);
    }

    public PageQry setCurrent(int current) {
        this.current = current;
        return this;
    }

    public int getSize() {
        if (size < 1) {
            size = DEFAULT_PAGE_SIZE;
        }
        return size;
    }

    public PageQry setSize(int size) {
        if (size < 1) {
            size = DEFAULT_PAGE_SIZE;
        }
        this.size = size;
        return this;
    }

    public int getOffset() {
        return (getCurrent() - 1) * getSize();
    }

    public String getOrderBy() {
        return orderBy;
    }

    public PageQry setOrderBy(String orderBy) {
        this.orderBy = orderBy;
        return this;
    }

    public String getOrderDirection() {
        return orderDirection;
    }

    public PageQry setOrderDirection(String orderDirection) {
        if (ASC.equalsIgnoreCase(orderDirection) || DESC.equalsIgnoreCase(orderDirection)) {
            this.orderDirection = orderDirection;
        }
        return this;
    }

    public String getGroupBy() {
        return groupBy;
    }

    public void setGroupBy(String groupBy) {
        this.groupBy = groupBy;
    }

    public boolean isNeedTotalCount() {
        return needTotalCount;
    }

    public void setNeedTotalCount(boolean needTotalCount) {
        this.needTotalCount = needTotalCount;
    }

}
