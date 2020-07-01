package com.wdcloud.kono.handle.dto;

import lombok.Data;

/**
 * @author wangff
 * @date 2020/6/30 16:37
 */
@Data
public class ErpUserDTO {
    private String id_user;
    private String Username;
    private String Password;
    private String Prenom;
    private String Nom;
    private String MailGEM;
    private String Role_user;

}
