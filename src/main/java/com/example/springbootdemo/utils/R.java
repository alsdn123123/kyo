package com.example.springbootdemo.utils;


import java.util.HashMap;
import java.util.Map;

/**
 * 返回数据
 *
 */
public class R extends HashMap<String, Object> {


    private static final long serialVersionUID = 1L;

    public R() {
        put("errcode", 0);
        put("errmsg", "ok");
    }

    public static R error() {
        return error(500, "未知异常，请联系管理员");
    }

    public static R error(String msg) {
        return error(500, msg);
    }

    public static R error(int code, String msg) {
        R r = new R();
        r.put("errcode", code);
        r.put("errmsg", msg);
        return r;
    }

    public static R ok(String msg) {
        R r = new R();
        r.put("errmsg", msg);
        return r;
    }

//	public static R ok(Map<String, Object> map) {
//		R r = new R();
//		r.putAll(map);
//		return r;
//	}

    public static R ok() {
        return new R();
    }

    /**
     * 设置返回值
     *
     * @param data
     * @return
     */
    public R data(Object data) {
        this.put("data", data);
        return this;
    }

    /**
     * 只有当data为Map时才有效
     * @param key
     * @param value
     * @return
     */
    public R add(String key, Object value) {
        Object obj = this.get("data");
        if(obj==null){
            obj = new HashMap<String,Object>();
            this.put("data",obj);
        }
        if(!(obj instanceof Map)){
            throw  new IllegalArgumentException("无效的参数！！");
        }
        Map<String,Object> data =(Map<String,Object>)obj;
        data.put(key,value);
        return this;
    }
}
