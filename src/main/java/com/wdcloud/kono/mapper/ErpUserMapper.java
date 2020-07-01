package com.wdcloud.kono.mapper;

import com.wdcloud.kono.handle.dto.ErpUserDTO;
import com.wdcloud.kono.model.ErpUser;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

public interface ErpUserMapper extends Mapper<ErpUser> {
    void batchInsert(List<ErpUserDTO> dtoList);
}