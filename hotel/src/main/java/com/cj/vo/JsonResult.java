package com.cj.vo;

public class JsonResult {
    private Integer state;
    private String message;
    private Object data;

    public JsonResult() {
    }

    public JsonResult(Throwable e) {
        this.message = e.getMessage();
        this.state=0;
    }

    public JsonResult(Integer state, String message, Object data) {
        super();
        this.state = state;
        this.message = message;
        this.data = data;
    }



    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }
}
