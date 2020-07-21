package com.wdcloud.kono.model;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.*;
import lombok.*;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
@Table(name = "erp_userprofil")
public class ErpUserprofil implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * id_userprofil
     */
    @Column(name = "id_userprofil")
    private Long idUserprofil;

    /**
     * id_profil
     */
    @Column(name = "id_profil")
    private Long idProfil;

    /**
     * id_user
     */
    @Column(name = "id_user")
    private Long idUser;

    /**
     * Nomuser
     */
    private String nomuser;

    /**
     * prenomuser
     */
    private String prenomuser;

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