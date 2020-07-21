package com.wdcloud.kono.model;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.*;
import lombok.*;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
@Table(name = "erp_entitejuridiqueprofil")
public class ErpEntitejuridiqueprofil implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * id_entitejuridiqueprofil
     */
    @Column(name = "id_entitejuridiqueprofil")
    private Long idEntitejuridiqueprofil;

    /**
     * id_profil
     */
    @Column(name = "id_profil")
    private Long idProfil;

    /**
     * id_entitejuridique
     */
    @Column(name = "id_entitejuridique")
    private Long idEntitejuridique;

    /**
     * NomEntite
     */
    @Column(name = "nom_entite")
    private String nomEntite;

    /**
     * Nomprofil
     */
    @Column(name = "nom_profil")
    private String nomProfil;

    /**
     * 0:初始化 1：已同步至lms
     */
    private Integer status;

    @Column(name = "create_time")
    private Date createTime;

    @Column(name = "update_time")
    private Date updateTime;

    private static final long serialVersionUID = 1L;
}