package com.wdcloud.kono.service;

import java.util.List;

/**
 * @author wangff
 * @date 2020/7/1 17:33
 */
public interface ErpService {
    String support();

    <T> List<T> getErp();
}
