package com.wdcloud.kono.mapper;

import com.wdcloud.kono.handle.dto.ErpDiplomeDTO;
import com.wdcloud.kono.model.ErpDiplome;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

public interface ErpDiplomeMapper extends Mapper<ErpDiplome> {
    void batchInsert(List<ErpDiplomeDTO> dtoList);
}