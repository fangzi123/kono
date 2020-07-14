package com.wdcloud.kono.controller.dto;

import lombok.Data;
import org.apache.poi.ss.formula.functions.T;

import javax.validation.constraints.NotBlank;
import java.util.Date;

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

    private Integer pageIndex=1;
    private Integer pageSize=1000;
    private Date syncDate;
    private Class<T>  clazz;
}
