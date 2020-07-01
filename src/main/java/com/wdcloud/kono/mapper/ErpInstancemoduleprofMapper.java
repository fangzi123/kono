package com.wdcloud.kono.mapper;

import com.wdcloud.kono.handle.dto.ErpInstancemoduleprofDTO;
import com.wdcloud.kono.model.ErpInstancemoduleprof;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

public interface ErpInstancemoduleprofMapper extends Mapper<ErpInstancemoduleprof> {
    void batchInsert(List<ErpInstancemoduleprofDTO> dtoList);
}