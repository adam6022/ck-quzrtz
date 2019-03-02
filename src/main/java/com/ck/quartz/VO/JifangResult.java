package com.ck.quartz.VO;

/**
 * 描述:
 *
 * @author yd
 * @create 2019-03-02 09:51
 */

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

/**
 * 返回结果
 */
public class JifangResult implements Serializable {

    /**
     *
     */
    private static final long serialVersionUID = 2267751680865696851L;
    /**是否成功**/
    private Boolean success = false ;
    /**返回消息**/
    private String message;
    /**返回数据**/
    private Object data;
    /**自定义数据集合**/
    private Map<String, Object> map = new HashMap();



    public Boolean getSuccess() {
        return success;
    }
    public void setSuccess(Boolean success) {
        this.success = success;
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

    public Map<String, Object> getMap() {
        return map;
    }
    public void setMap(Map<String, Object> map) {
        this.map = map;
    }
    public void clear() {
        this.success=false;
        this.message=null;
        this.data=null;
        this.map=null;
    }
}
