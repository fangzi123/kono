package com.wdcloud.kono.handle.dto;

import com.alibaba.fastjson.annotation.JSONField;
import com.alibaba.fastjson.annotation.JSONType;
import lombok.Data;

/**
 * @author wangff
 * @date 2020/6/30 18:49
 */
@Data
public class ErpEntitejuridiqueDTO {
    @JSONField(name ="id_entitejuridique")
    private String idEntitejuridique;
    @JSONField(name ="Nom")
    private String nom;
    @JSONField(name ="Code")
    private String code;
}
