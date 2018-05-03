package cdu.xeon.data.bean;

import java.io.Serializable;
import java.util.List;


public class Pager<T> implements Serializable {

    private int size;

    private int offset;

    private long total;

    private List<T> datas;

    public int getSize() {
        return size;
    }
    public void setSize(int size) {
        this.size = size;
    }
    public int getOffset() {
        return offset;
    }
    public void setOffset(int offset) {
        this.offset = offset;
    }
    public long getTotal() {
        return total;
    }
    public void setTotal(long total) {
        this.total = total;
    }
    public List<T> getDatas() {
        return datas;
    }
    public void setDatas(List<T> datas) {
        this.datas = datas;
    }

    @Override
    public String toString() {
        return "Pager{" +
                "size=" + size +
                ", offset=" + offset +
                ", total=" + total +
                ", datas=" + datas +
                '}';
    }
}