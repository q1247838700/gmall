package com.atguigu.core.bean;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@ApiModel
@Data
public class Resp<T> {

    @ApiModelProperty(name = "code",value = "响应状态码")
    private Integer code;

    @ApiModelProperty(name = "msg",value = "提示消息")
    private String msg;

    @ApiModelProperty(name = "data",value = "响应数据")
    private T data;

    public Resp(Integer code, String msg, T data) {
        this.code = code;
        this.msg = msg;
        this.data = data;
    }

    public Resp() {
    }

    public Resp(T data) {
        this.data = data;
    }

    public static<T> Resp<T> ok(T data){
        Resp<T> resp = new Resp<T>(data);
        //操作成功
        resp.setCode(0);
        resp.setMsg("success");
        return resp;
    }

    public static<T> Resp<T> fail(String data){
        Resp<T> resp = new Resp<T>();
        //操作失败
        resp.setCode(1);
        resp.setMsg(data);
        return resp;
    }

    public Resp<T> msg(String msg){
        this.setMsg(msg);
        return this;
    }

    public Resp<T> code(Integer code){
        this.setCode(code);
        return this;
    }


}
