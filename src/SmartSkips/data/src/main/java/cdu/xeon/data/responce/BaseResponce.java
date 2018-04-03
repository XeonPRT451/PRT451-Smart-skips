package cdu.xeon.data.responce;

/**
 * Created by Administrator on 3/04/2018.
 */

public class BaseResponce<T> {
    private int status;

    private String msg;

    private int requestTime;

    private int responceTime;

    private T data;

    public void setStatus(int status){
        this.status = status;
    }
    public int getStatus(){
        return this.status;
    }
    public void setMsg(String msg){
        this.msg = msg;
    }
    public String getMsg(){
        return this.msg;
    }
    public void setRequestTime(int requestTime){
        this.requestTime = requestTime;
    }
    public int getRequestTime(){
        return this.requestTime;
    }
    public void setResponceTime(int responceTime){
        this.responceTime = responceTime;
    }
    public int getResponceTime(){
        return this.responceTime;
    }
    public void setData(T data){
        this.data = data;
    }
    public T getData(){
        return this.data;
    }


}
