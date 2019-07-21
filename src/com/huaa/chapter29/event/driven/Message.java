package com.huaa.chapter29.event.driven;

/**
 * Desc:
 *
 * @author wu_zh
 * @date 2019/7/21 14:10
 */
public interface Message {

    /**
     * 返回Message的类型
     */
    Class<? extends Message> getType();
    
}
