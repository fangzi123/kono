package com.wdcloud.kono.mapper;

import com.wdcloud.kono.handle.dto.ErpModuleDTO;
import com.wdcloud.kono.model.ErpModule;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

public interface ErpModuleMapper extends Mapper<ErpModule> {
    void batchInsert(List<ErpModuleDTO> dtoList);
}