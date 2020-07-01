package com.wdcloud.kono.model;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.*;

@Table(name = "erp_instancemodule")
public class ErpInstancemodule implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "id_instancemodule")
    private Long idInstancemodule;

    @Column(name = "id_anneescolaire")
    private Long idAnneescolaire;

    @Column(name = "id_module")
    private Long idModule;

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
     * @return id_instancemodule
     */
    public Long getIdInstancemodule() {
        return idInstancemodule;
    }

    /**
     * @param idInstancemodule
     */
    public void setIdInstancemodule(Long idInstancemodule) {
        this.idInstancemodule = idInstancemodule;
    }

    /**
     * @return id_anneescolaire
     */
    public Long getIdAnneescolaire() {
        return idAnneescolaire;
    }

    /**
     * @param idAnneescolaire
     */
    public void setIdAnneescolaire(Long idAnneescolaire) {
        this.idAnneescolaire = idAnneescolaire;
    }

    /**
     * @return id_module
     */
    public Long getIdModule() {
        return idModule;
    }

    /**
     * @param idModule
     */
    public void setIdModule(Long idModule) {
        this.idModule = idModule;
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