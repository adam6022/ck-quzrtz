package com.ck.quartz.VO;

/**
 * 描述:
 *
 * @author yd
 * @create 2019-03-02 09:51
 */

import lombok.Data;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

/**
 * 返回结果
 */
@Data
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
    /**自定义分页**/
    private Page page;

}
