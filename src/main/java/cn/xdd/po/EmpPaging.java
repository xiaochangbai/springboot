package cn.xdd.po;

import java.util.List;

/**
 * @author xchb
 * @version 1.0
 * @ClassName EmpPaging
 * @description 分页查询结果返回对象。
 * @createTime 2019年09月14日 21:30
 */
public class EmpPaging {
    private int status;  //状态码，200表示成功，500表示失败

    private long currentPageNum;  //当前页码

    private long totalPageNum;  //总页码数

    private List<Object> data;   //数据

    private String description;   //当前状态描述信息（成功、失败、等等）


    public EmpPaging() {
    }

    public EmpPaging(int status, long currentPageNum, long totalPageNum, List<Object> data,String description) {
        this.status = status;
        this.currentPageNum = currentPageNum;
        this.totalPageNum = totalPageNum;
        this.data = data;
        this.description=description;
    }

    public void addData(Object object){
        this.data.add(object);
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

    public List<Object> getData() {
        return data;
    }

    public void setData(List<Object> data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "EmpPaging{" +
                "status=" + status +
                ", currentPageNum=" + currentPageNum +
                ", totalPageNum=" + totalPageNum +
                ", data=" + data +
                ", description='" + description + '\'' +
                '}';
    }
}
