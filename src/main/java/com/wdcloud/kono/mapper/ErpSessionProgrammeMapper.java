package com.wdcloud.kono.mapper;

import com.wdcloud.kono.handle.dto.ErpSessionProgrammeDTO;
import com.wdcloud.kono.model.ErpSessionProgramme;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

public interface ErpSessionProgrammeMapper extends Mapper<ErpSessionProgramme> {
    void batchInsert(List<ErpSessionProgrammeDTO> dtoList);
}