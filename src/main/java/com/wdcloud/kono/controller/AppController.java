package com.wdcloud.kono.controller;

import com.wdcloud.kono.config.rltconfig.BaseException;
import com.wdcloud.kono.constant.Constants;
import com.wdcloud.kono.controller.dto.TableDTO;
import com.wdcloud.kono.mapper.ErpUserMapper;
import com.wdcloud.kono.service.ErpService;
import com.wdcloud.kono.service.ErpServiceFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

/**
 * @author wangff
 * @date 2020/6/29 11:16
 */
@RestController
public class AppController {

    @Autowired
    private ErpServiceFactory erpServiceFactory;

    @PostMapping("/lms")
    public Object lms(@Valid @RequestBody TableDTO dto){
        if (!Constants.LMS_SECUREKEY.equals(dto.getSecureKey())) {
            throw new BaseException();
        }
        ErpService erpService= erpServiceFactory.getInstance(dto.getNameTable());
        return erpService.getErp();
    }
}
