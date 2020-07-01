package com.wdcloud.kono.model;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.*;

@Table(name = "erp_seance")
public class ErpSeance implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "id_seance")
    private Long idSeance;

    @Column(name = "date_debu")
    private String dateDebu;

    @Column(name = "date_de_fin")
    private String dateDeFin;

    private String nom;

    /**
     * group of student registred in the module instance
     */
    @Column(name = "id_instancegroupetd")
    private Long idInstancegroupetd;

    /**
     * id_user
     */
    @Column(name = "id_prof")
    private Long idProf;

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
     * @return id_seance
     */
    public Long getIdSeance() {
        return idSeance;
    }

    /**
     * @param idSeance
     */
    public void setIdSeance(Long idSeance) {
        this.idSeance = idSeance;
    }

    /**
     * @return date debu
     */
    public String getDateDebu() {
        return dateDebu;
    }

    /**
     * @param dateDebu
     */
    public void setDateDebu(String dateDebu) {
        this.dateDebu = dateDebu;
    }

    /**
     * @return date_de_fin
     */
    public String getDateDeFin() {
        return dateDeFin;
    }

    /**
     * @param dateDeFin
     */
    public void setDateDeFin(String dateDeFin) {
        this.dateDeFin = dateDeFin;
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
     * 获取group of student registred in the module instance
     *
     * @return id_instancegroupetd - group of student registred in the module instance
     */
    public Long getIdInstancegroupetd() {
        return idInstancegroupetd;
    }

    /**
     * 设置group of student registred in the module instance
     *
     * @param idInstancegroupetd group of student registred in the module instance
     */
    public void setIdInstancegroupetd(Long idInstancegroupetd) {
        this.idInstancegroupetd = idInstancegroupetd;
    }

    /**
     * 获取id_user
     *
     * @return id_prof - id_user
     */
    public Long getIdProf() {
        return idProf;
    }

    /**
     * 设置id_user
     *
     * @param idProf id_user
     */
    public void setIdProf(Long idProf) {
        this.idProf = idProf;
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