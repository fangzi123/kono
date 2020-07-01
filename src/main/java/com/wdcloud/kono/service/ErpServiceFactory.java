package com.wdcloud.kono.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author wangff
 * @date 2019/12/2 15:38
 */
@Component
public class ErpServiceFactory {
    private Map<String,ErpService> serviceMap = new ConcurrentHashMap<String,ErpService>(32);

    public   ErpService getInstance(String type){
        return serviceMap.get(type);
    }

    @Autowired
    private void init(ErpService[] services) {
        for (ErpService service : services) {
            serviceMap.put(service.support(), service);
        }
    }
}
