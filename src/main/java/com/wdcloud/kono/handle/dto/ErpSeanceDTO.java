package com.wdcloud.kono.handle.dto;

import lombok.Data;

/**
 * @author wangff
 * @date 2020/7/1 15:07
 */
@Data
public class ErpSeanceDTO {
    private String Id_seance;
    private String Date_debut;
    private String Date_de_fin;
    private String Nom;
    private String id_instancegroupetd;
    private String Id_prof ;
}
