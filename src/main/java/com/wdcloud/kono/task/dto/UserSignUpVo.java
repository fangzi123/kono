package com.wdcloud.kono.task.dto;

import lombok.Builder;
import lombok.Data;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
    @Builder
    @Data
    public  class UserSignUpVo {
        @NotEmpty
        @Size(max = 100)
        private String username;
        @NotEmpty
        private String email;
        @NotEmpty
        @Size(max = 60, min = 6)
        private String password;
        @NotEmpty
        @Size(max = 60)
        private String firstName;
        @NotEmpty
        @Size(max = 50)
        private String lastName;
        @Size(max = 30)
        private String phone;
        //64 fr
        private Integer locationId;
    }