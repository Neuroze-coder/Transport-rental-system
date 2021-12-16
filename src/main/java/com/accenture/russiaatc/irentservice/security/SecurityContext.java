package com.accenture.russiaatc.irentservice.security;

public class SecurityContext {
    private final static ThreadLocal<CallContext> context = new ThreadLocal<CallContext>();

    public static void set(CallContext callContext) {
        context.set(callContext);
    }

    public static CallContext get() {
        return context.get();
    }

    public static void clear() {
        context.remove();
    }
}
