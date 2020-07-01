package com.wdcloud.kono.handle.base;

import java.util.Iterator;
import java.util.List;

/**
 * @author wangff
 * @date 2019/9/16 18:11
 */
public class HandleChain {
    private Iterator<Handle> iterator;

    public HandleChain(List<Handle> handles) {
        this.iterator = handles.iterator();
    }

    public void intercept(Request request, Response response){
        if (iterator.hasNext()) {
            Handle handle = iterator.next();
            handle.handleRequest(request);
            handle.aroundProcess(request, response, this);
        }
    }
}
