package com.wdcloud.kono.service;

import com.wdcloud.kono.constant.Constants;
import com.wdcloud.kono.mapper.ErpDiplomeMapper;
import com.wdcloud.kono.mapper.ErpEcoleMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author wangff
 * @date 2020/7/1 17:55
 */
@Service
public class ErpServiceErpEcole implements ErpService {

    @Autowired
    private ErpEcoleMapper mapper;

    @Override
    public String support() {
        return Constants.TABLE_ERP_ECOLE;
    }

    @Override
    public <T> List<T> getErp() {
        return (List<T>) mapper.selectAll();
    }

}
