package com.wdcloud.kono.mapper;

import com.wdcloud.kono.handle.dto.ErpAnneeScolaireDTO;
import com.wdcloud.kono.model.ErpAnneeScolaire;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

public interface ErpAnneeScolaireMapper extends Mapper<ErpAnneeScolaire> {
    void batchInsert(List<ErpAnneeScolaireDTO> dtoList);
}