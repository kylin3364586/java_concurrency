package org.example.thinking.in.spring.ioc.bean.scope;

import org.springframework.beans.factory.ObjectFactory;
import org.springframework.beans.factory.config.Scope;
import org.springframework.core.NamedThreadLocal;
import org.springframework.lang.NonNull;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * ThreadLocal 级别的 Scope
 * @author kylin
 * @version 1.0.0
 * @Description
 * @createTime 2022年08月17日 10:37:00
 */
public class ThreadLocalScope implements Scope {

    public static final String THREAD_LOCAL = "thread-local";

    private final NamedThreadLocal<Map<String, Object>> threadLocal = new NamedThreadLocal<Map<String, Object>>("thread-local-scope"){

        @Override
        protected Map<String, Object> initialValue() {
            return new HashMap<>();
        }
    };

    @Override
    public Object get(String name, ObjectFactory<?> objectFactory) {
        Map<String, Object> context = getContext();
        Object object = context.get(name);
        if(null == object){
            Object o = objectFactory.getObject();
            context.put(name, o);
        }
        return context.get(name);
    }

    @NonNull
    private Map<String, Object> getContext(){
        return threadLocal.get();
    }

    @Override
    public Object remove(String name) {
        Map<String, Object> context = getContext();
        return context.remove(name);
    }

    @Override
    public void registerDestructionCallback(String name, Runnable runnable) {

    }

    @Override
    public Object resolveContextualObject(String name) {
        Map<String, Object> context = getContext();
        return context.get(name);
    }

    @Override
    public String getConversationId() {
        Thread thread = Thread.currentThread();
        return String.valueOf(thread.getId());
    }
}
