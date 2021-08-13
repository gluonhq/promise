package com.gluonhq.promise.hellofx;

public class Foo extends SuperFoo {
    @Override
    public int callBar(int l) {
        return bar(l);
    }

    private native static int bar(int l);
}
