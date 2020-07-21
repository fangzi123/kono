package com.wdcloud.kono.mapper;

import com.wdcloud.kono.handle.dto.ErpUserprofilDTO;
import com.wdcloud.kono.model.ErpUserprofil;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

public interface ErpUserprofilMapper extends Mapper<ErpUserprofil> {
    void batchInsert(List<ErpUserprofilDTO> dtoList);
}