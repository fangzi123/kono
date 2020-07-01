package com.wdcloud.kono.controller.dto;

import lombok.Data;

import javax.validation.constraints.NotBlank;

/**
 * @author wangff
 * @date 2020/7/1 17:26
 */
@Data
public class TableDTO {
    @NotBlank
    private String nameTable;
    @NotBlank
    private String secureKey;
}
