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
@Table(name = "erp_entitejuridique")
public class ErpEntitejuridique implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * id_entitejuridique
     */
    @Column(name = "id_entitejuridique")
    private Long idEntitejuridique;

    private String nom;

    private String code;

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
     * 获取id_entitejuridique
     *
     * @return id_entitejuridique - id_entitejuridique
     */
    public Long getIdEntitejuridique() {
        return idEntitejuridique;
    }

    /**
     * 设置id_entitejuridique
     *
     * @param idEntitejuridique id_entitejuridique
     */
    public void setIdEntitejuridique(Long idEntitejuridique) {
        this.idEntitejuridique = idEntitejuridique;
    }

    /**
     * @return nom
     */
    public String getNom() {
        return nom;
    }

    /**
     * @param nom
     */
    public void setNom(String nom) {
        this.nom = nom;
    }

    /**
     * @return code
     */
    public String getCode() {
        return code;
    }

    /**
     * @param code
     */
    public void setCode(String code) {
        this.code = code;
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