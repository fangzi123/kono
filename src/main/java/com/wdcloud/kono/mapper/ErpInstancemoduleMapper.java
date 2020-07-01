package com.wdcloud.kono.mapper;

import com.wdcloud.kono.handle.dto.ErpInstancemoduleDTO;
import com.wdcloud.kono.model.ErpInstancemodule;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

public interface ErpInstancemoduleMapper extends Mapper<ErpInstancemodule> {
    void batchInsert(List<ErpInstancemoduleDTO> dtoList);
}