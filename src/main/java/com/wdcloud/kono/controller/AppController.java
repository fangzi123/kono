package com.wdcloud.kono.controller;

import com.wdcloud.kono.mapper.ErpUserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author wangff
 * @date 2020/6/29 11:16
 */
@RestController
public class AppController {

    @Autowired
    private ErpUserMapper erpUserMapper;

    @GetMapping("/test")
    public Object get(){
        return erpUserMapper.selectAll();
    }
}
