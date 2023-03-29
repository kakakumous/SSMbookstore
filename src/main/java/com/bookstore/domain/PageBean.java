package com.bookstore.domain;

import java.io.Serializable;
import java.util.List;

public class PageBean implements Serializable{

    private int currentPage;// 当前页码
    private int totalCount;// 记录总数
    private int currentCount;// 每页显示条数
    private int totalPage;// 总页数
    private List<Products> ps;// 每页显示的数据

    public int getCurrentPage() {
        return currentPage;
    }

    public void setCurrentPage(int currentPage) {
        this.currentPage = currentPage;
    }

    public int getTotalCount() {
        return totalCount;
    }

    public void setTotalCount(int totalCount) {
        this.totalCount = totalCount;
    }

    public int getCurrentCount() {
        return currentCount;
    }

    public void setCurrentCount(int currentCount) {
        this.currentCount = currentCount;
    }

    public int getTotalPage() {
        return totalPage;
    }

    public void setTotalPage(int totalPage) {
        this.totalPage = totalPage;
    }

    public List<Products> getPs() {
        return ps;
    }

    public void setPs(List<Products> ps) {
        this.ps = ps;
    }


}
