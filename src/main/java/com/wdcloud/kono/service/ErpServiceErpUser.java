package com.wdcloud.kono.service;

import com.wdcloud.kono.constant.Constants;
import com.wdcloud.kono.mapper.ErpUserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author wangff
 * @date 2020/7/1 17:55
 */
@Service
public class ErpServiceErpUser implements ErpService {

    @Autowired
    private ErpUserMapper mapper;

    @Override
    public String support() {
        return Constants.TABLE_ERP_USER;
    }

    @Override
    public <T> List<T> getErp() {
        return (List<T>) mapper.selectAll();
    }

}
