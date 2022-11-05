package com.mycode.domain;

import lombok.Data;

@Data
public class RespondData {
    private boolean success;//响应状态
    private Integer state;//响应代码
    private String message;//响应提示
    private Object content;//响应数据

    public static RespondData success(Object o){
        RespondData respondData = new RespondData();
        respondData.setSuccess(true);
        respondData.setState(200);
        respondData.setMessage("响应成功");
        respondData.setContent(o);
        return respondData;
    }

    public static RespondData success(){
        RespondData respondData = new RespondData();
        respondData.setSuccess(true);
        respondData.setState(200);
        respondData.setMessage("响应成功");
        return respondData;
    }

    public static RespondData error(String msg){
        RespondData respondData = new RespondData();
        respondData.setSuccess(false);
        respondData.setState(123);
        respondData.setMessage(msg);
        return respondData;
    }

}
