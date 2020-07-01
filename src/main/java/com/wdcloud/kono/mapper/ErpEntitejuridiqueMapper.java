package com.wdcloud.kono.mapper;

import com.wdcloud.kono.model.ErpEntitejuridique;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

public interface ErpEntitejuridiqueMapper extends Mapper<ErpEntitejuridique> {
    void batchInsert(List<ErpEntitejuridique> dtoList);
}