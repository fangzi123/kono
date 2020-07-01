package com.wdcloud.kono.mapper;

import com.wdcloud.kono.handle.dto.ErpLiaisongroupeinstancemoduleDTO;
import com.wdcloud.kono.model.ErpLiaisongroupeinstancemodule;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

public interface ErpLiaisongroupeinstancemoduleMapper extends Mapper<ErpLiaisongroupeinstancemodule> {
    void batchInsert(List<ErpLiaisongroupeinstancemoduleDTO> dtoList);
}