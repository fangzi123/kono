package com.wdcloud.kono.task.dto;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class UserDTO {

    private String firstName;
    private String lastName;
    private String loginId;
    private Long orgId;
    private String orgTreeId;
    private String password;

    private Long roleId;

    private String email;
    private String studentNo;
    private Integer sex;
    private Integer locationId;

}
