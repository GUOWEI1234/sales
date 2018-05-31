package com.my.pojo;

/**
 * @Author
 * Created by GUOwei on 2018/5/1.
 */
public class Page {
    /**
     * 一次性显示行数
     */
    private int count = 5;
    /**
     * 起始行
     */
    private int start = 1;
    /**
     * 最后行
     */
    private int last = 0;
    /**
     * 总共页数
     */
    private int totalPage = 0;
    /**
     * 当前页数
     */
    private int currentPage = 1;

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public int getStart() {
        return start;
    }

    public void setStart(int start) {
        this.start = start;
    }

    public int getLast() {
        return last;
    }

    public void setLast(int last) {
        this.last = last;
    }

    public int getTotalPage() {
        return totalPage;
    }

    public void setTotalPage(int totalPage) {
        this.totalPage = totalPage;
    }

    public int getCurrentPage() {
        return currentPage;
    }

    public void setCurrentPage(int currentPage) {
        this.currentPage = currentPage;
    }
}
