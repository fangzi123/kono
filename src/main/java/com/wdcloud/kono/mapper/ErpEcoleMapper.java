package com.wdcloud.kono.mapper;

import com.wdcloud.kono.handle.dto.ErpEcoleDTO;
import com.wdcloud.kono.model.ErpEcole;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

public interface ErpEcoleMapper extends Mapper<ErpEcole> {
    void batchInsert(List<ErpEcoleDTO> dtoList);
}