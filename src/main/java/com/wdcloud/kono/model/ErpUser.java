package com.wdcloud.kono.model;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.*;

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

    /**
     * @return id
     */
    public Long getId() {
        return id;
    }

    /**
     * @param id
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * 获取id_user
     *
     * @return id_user - id_user
     */
    public Long getIdUser() {
        return idUser;
    }

    /**
     * 设置id_user
     *
     * @param idUser id_user
     */
    public void setIdUser(Long idUser) {
        this.idUser = idUser;
    }

    /**
     * 获取用户名
     *
     * @return username - 用户名
     */
    public String getUsername() {
        return username;
    }

    /**
     * 设置用户名
     *
     * @param username 用户名
     */
    public void setUsername(String username) {
        this.username = username;
    }

    /**
     * 获取密码
     *
     * @return password - 密码
     */
    public String getPassword() {
        return password;
    }

    /**
     * 设置密码
     *
     * @param password 密码
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * 获取first_name
     *
     * @return prenom - first_name
     */
    public String getPrenom() {
        return prenom;
    }

    /**
     * 设置first_name
     *
     * @param prenom first_name
     */
    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    /**
     * 获取last_name
     *
     * @return nom - last_name
     */
    public String getNom() {
        return nom;
    }

    /**
     * 设置last_name
     *
     * @param nom last_name
     */
    public void setNom(String nom) {
        this.nom = nom;
    }

    /**
     * 获取email
     *
     * @return mailgem - email
     */
    public String getMailgem() {
        return mailgem;
    }

    /**
     * 设置email
     *
     * @param mailgem email
     */
    public void setMailgem(String mailgem) {
        this.mailgem = mailgem;
    }

    /**
     * 获取role_user
     *
     * @return role_user - role_user
     */
    public String getRoleUser() {
        return roleUser;
    }

    /**
     * 设置role_user
     *
     * @param roleUser role_user
     */
    public void setRoleUser(String roleUser) {
        this.roleUser = roleUser;
    }

    /**
     * 获取0:初始化 1：已同步至lms
     *
     * @return status - 0:初始化 1：已同步至lms
     */
    public Integer getStatus() {
        return status;
    }

    /**
     * 设置0:初始化 1：已同步至lms
     *
     * @param status 0:初始化 1：已同步至lms
     */
    public void setStatus(Integer status) {
        this.status = status;
    }

    /**
     * @return create_time
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * @param createTime
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    /**
     * @return update_time
     */
    public Date getUpdateTime() {
        return updateTime;
    }

    /**
     * @param updateTime
     */
    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }
}