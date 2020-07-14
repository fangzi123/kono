package com.wdcloud.kono.service;

import com.wdcloud.kono.controller.dto.TableDTO;

import java.util.List;

/**
 * @author wangff
 * @date 2020/7/1 17:33
 */
public interface ErpService {
    String support();

    <T> List<T> getErp(TableDTO dto);
}
