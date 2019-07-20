package com.huaa.chapter28.event.bus;

import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentLinkedQueue;

/**
 * Desc:
 *
 * @author wu_zh
 * @date 2019/7/20 10:43
 */
class Registry {

    private final ConcurrentHashMap<String, ConcurrentLinkedQueue<Subscriber>> subscriberContainer = new ConcurrentHashMap<>();

    public void bind(Object subscriber) {
        List<Method> subscriberMethods = getSubscriberMethods(subscriber);
        subscriberMethods.forEach(m -> tierSubscriber(subscriber, m));
    }

    public void unbind(Object subscriber) {
        subscriberContainer.forEach((key, queue) ->
                queue.stream().filter(s -> s.getSubscriberObject() == subscriber)
                        .forEach(s -> s.setDisable(true)));
    }

    public ConcurrentLinkedQueue<Subscriber> scanSubscriber(final String topic) {
        return subscriberContainer.get(topic);
    }

    private void tierSubscriber(Object subscriber, Method method) {
        final Subscribe subscribe = method.getDeclaredAnnotation(Subscribe.class);
        String topic = subscribe.topic();
        subscriberContainer.computeIfAbsent(topic, key -> new ConcurrentLinkedQueue<>())
                .add(new Subscriber(subscriber, method));
    }

    private List<Method> getSubscriberMethods(Object subscriber) {
        final List<Method> methods = new ArrayList<>();
        Class<?> temp = subscriber.getClass();
        while (temp != null) {
            Method[] declareMethods = temp.getDeclaredMethods();
            Arrays.stream(declareMethods)
                    .filter(m -> m.isAnnotationPresent(Subscribe.class))
                    .filter(m -> m.getParameterCount() == 1)
                    .filter(m -> m.getModifiers() == Modifier.PUBLIC)
                    .forEach(methods::add);
            temp = temp.getSuperclass();
        }
        return methods;
    }
}
