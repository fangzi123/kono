package com.wdcloud.kono.mapper;

import com.wdcloud.kono.handle.dto.ErpInstanceCursusDTO;
import com.wdcloud.kono.model.ErpInstanceCursus;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

public interface ErpInstanceCursusMapper extends Mapper<ErpInstanceCursus> {
    void batchInsert(List<ErpInstanceCursusDTO> dtoList);
}