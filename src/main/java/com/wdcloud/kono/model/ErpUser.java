package com.wdcloud.kono.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.*;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
@Table(name = "erp_user")
public class ErpUser implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * id_user
     */
    @Column(name = "id_user")
    private Long idUser;

    /**
     * 用户名
     */
    private String username;

    /**
     * 密码
     */
    private String password;

    /**
     * first_name
     */
    private String prenom;

    /**
     * last_name
     */
    private String nom;

    /**
     * email
     */
    private String mailgem;

    /**
     * role_user
     */
    @Column(name = "role_user")
    private String roleUser;

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