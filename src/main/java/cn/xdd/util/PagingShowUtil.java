package cn.xdd.util;

import cn.xdd.po.Employee;

import java.util.ArrayList;
import java.util.List;

/**
 * @author xchb
 * @version 1.0
 * @ClassName EmpPaging
 * @description 分页查询结果返回对象。
 * @createTime 2019年09月14日 21:30
 */
public class PagingShowUtil<T> {
    private final static int SUCCESS_STATUS= 200;
    private final static int FAIL_STATUS=500;

    private int status;  //状态码，200表示成功，500表示失败

    private long currentPageNum;  //当前页码

    private long totalPageNum;  //总页码数

    private long totalDataCount; //总数据量

    private List<T> data;   //数据

    private String description;   //当前状态描述信息（成功、失败、等等）



    public PagingShowUtil() {
    }

    public PagingShowUtil(int status, long currentPageNum, long totalPageNum, long totalDataCount, List<T> data, String description) {
        this.status = status;
        this.currentPageNum = currentPageNum;
        this.totalPageNum = totalPageNum;
        this.totalDataCount = totalDataCount;
        this.data = data;
        this.description = description;
    }

    public void addData(T t){
        if(this.data == null){
            this.data=new ArrayList<>();
        }
        this.data.add(t);
    }

    public long getTotalDataCount() {
        return totalDataCount;
    }

    public void setTotalDataCount(long totalDataCount) {
        this.totalDataCount = totalDataCount;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public long getCurrentPageNum() {
        return currentPageNum;
    }

    public void setCurrentPageNum(long currentPageNum) {
        this.currentPageNum = currentPageNum;
    }

    public long getTotalPageNum() {
        return totalPageNum;
    }

    public void setTotalPageNum(long totalPageNum) {
        this.totalPageNum = totalPageNum;
    }

    public List<T> getData() {
        return data;
    }

    public void setData(List<T> data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "PagingShowUtil{" +
                "status=" + status +
                ", currentPageNum=" + currentPageNum +
                ", totalPageNum=" + totalPageNum +
                ", totalDataCount=" + totalDataCount +
                ", data=" + data +
                ", description='" + description + '\'' +
                '}';
    }
}
