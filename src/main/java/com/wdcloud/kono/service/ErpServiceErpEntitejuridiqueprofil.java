package com.wdcloud.kono.service;

import com.wdcloud.kono.constant.Constants;
import com.wdcloud.kono.controller.dto.TableDTO;
import com.wdcloud.kono.mapper.ErpEntitejuridiqueprofilMapper;
import com.wdcloud.kono.model.ErpUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

import java.util.List;

/**
 * @author wangff
 * @date 2020/7/1 17:55
 */
@Service
public class ErpServiceErpEntitejuridiqueprofil implements ErpService {

    @Autowired
    private ErpEntitejuridiqueprofilMapper mapper;

    @Override
    public String support() {
        return Constants.TABLE_ERP_ENTITEJURIDIQUEPROFIL;
    }

    @Override
    public <T> List<T> getErp(TableDTO dto) {
        Example example = new Example(ErpUser.class);
        example.createCriteria().andBetween("createTime", DateUtil.getDayStartOfDate(dto.getSyncDate()),DateUtil.getDayEndOfDate(dto.getSyncDate()));
        return (List<T>)  mapper.selectByExample(example);
    }

}
