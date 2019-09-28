package com.huaa.chapter28.event.bus;

import java.lang.reflect.Method;

/**
 * Desc:
 *
 * @author wu_zh
 * @date 2019/7/20 10:46
 */
public class Subscriber {

    private final Object subscriberObject;
    private final Method subscriberMethod;
    private boolean disable = false;

    public Subscriber(Object subscriberObject, Method subscriberMethod) {
        this.subscriberObject = subscriberObject;
        this.subscriberMethod = subscriberMethod;
    }

    public Object getSubscriberObject() {
        return subscriberObject;
    }

    public Method getSubscriberMethod() {
        return subscriberMethod;
    }

    public boolean isDisable() {
        return disable;
    }

    public void setDisable(boolean disable) {
        this.disable = disable;
    }

}
