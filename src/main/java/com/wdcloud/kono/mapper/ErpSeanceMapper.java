package com.wdcloud.kono.mapper;

import com.wdcloud.kono.handle.dto.ErpSeanceDTO;
import com.wdcloud.kono.model.ErpSeance;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

public interface ErpSeanceMapper extends Mapper<ErpSeance> {
    void batchInsert(List<ErpSeanceDTO> dtoList);
}