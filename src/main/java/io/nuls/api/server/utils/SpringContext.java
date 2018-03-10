package io.nuls.api.server.utils;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public enum SpringContext {
    CONTEXT;

    private ClassPathXmlApplicationContext context;

    public synchronized void initialize() {
        if(context == null) {
            context = new ClassPathXmlApplicationContext(
                    new String[] { "classpath:ApplicationContext.xml" });
            context.start();
        }
    }

    public Object getBean(String name) {
        return context.getBean(name);
    }

    public <T> T getBean(String name, Class<T> requiredType) {
        return context.getBean(name, requiredType);
    }

    public <T> T getBean(Class<T> requiredType) {
        return context.getBean(requiredType);
    }




}
