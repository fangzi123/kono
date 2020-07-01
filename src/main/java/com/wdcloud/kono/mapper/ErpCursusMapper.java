package com.wdcloud.kono.mapper;

import com.wdcloud.kono.handle.dto.ErpCursusDTO;
import com.wdcloud.kono.model.ErpCursus;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

public interface ErpCursusMapper extends Mapper<ErpCursus> {
    void batchInsert(List<ErpCursusDTO> dtoList);
}