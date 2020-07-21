package com.wdcloud.kono.model;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.*;
import lombok.*;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
@Table(name = "sys_org")
public class SysOrg implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "sis_id")
    private String sisId;

    /**
     * 上级机构ID
     */
    @Column(name = "parent_id")
    private Long parentId;

    /**
     * 机构树ID
     */
    @Column(name = "tree_id")
    private String treeId;

    /**
     * 机构名称
     */
    private String name;

    /**
     * 机构类型: 1. 学校, 2. 非学校
     */
    private Integer type;

    /**
     * 机构使用语言（预留）
     */
    private String language;

    /**
     * 机构时区（预留）
     */
    @Column(name = "time_zone")
    private String timeZone;

    /**
     * 区域城市ID
     */
    @Column(name = "city_id")
    private Integer cityId;

    @Column(name = "create_time")
    private Date createTime;

    @Column(name = "update_time")
    private Date updateTime;

    @Column(name = "create_user_id")
    private Long createUserId;

    @Column(name = "update_user_id")
    private Long updateUserId;

    /**
     * 机构描述
     */
    private String description;

    private static final long serialVersionUID = 1L;
}