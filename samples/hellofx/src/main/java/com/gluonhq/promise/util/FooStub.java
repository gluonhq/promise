package com.gluonhq.promise.util;

import org.apidesign.bck2brwsr.core.*;

@JavaScriptPrototype(prototype="", container="vm.com_gluonhq_promise_hellofx_Foo(false)")
public class FooStub {

    @JavaScriptBody(body = "console.log('barsubs'); return 15;", args = {"l"})
    private native static int bar(int l);
}
