package com.wdcloud.kono.model;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.*;

@Table(name = "erp_liaisongroupeinstancemodule")
public class ErpLiaisongroupeinstancemodule implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "id_instancemodule")
    private Long idInstancemodule;

    @Column(name = "id_instancegroupetd")
    private Long idInstancegroupetd;

    private String groupe;

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
     * @return id_instancegroupetd
     */
    public Long getIdInstancegroupetd() {
        return idInstancegroupetd;
    }

    /**
     * @param idInstancegroupetd
     */
    public void setIdInstancegroupetd(Long idInstancegroupetd) {
        this.idInstancegroupetd = idInstancegroupetd;
    }

    /**
     * @return groupe
     */
    public String getGroupe() {
        return groupe;
    }

    /**
     * @param groupe
     */
    public void setGroupe(String groupe) {
        this.groupe = groupe;
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