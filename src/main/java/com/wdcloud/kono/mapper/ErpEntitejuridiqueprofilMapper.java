package com.wdcloud.kono.mapper;

import com.wdcloud.kono.handle.dto.ErpEntitejuridiqueprofilDTO;
import com.wdcloud.kono.model.ErpEntitejuridiqueprofil;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

public interface ErpEntitejuridiqueprofilMapper extends Mapper<ErpEntitejuridiqueprofil> {
    void batchInsert(List<ErpEntitejuridiqueprofilDTO> dtoList);
}