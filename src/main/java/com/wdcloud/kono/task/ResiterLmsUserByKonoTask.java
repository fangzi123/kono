package com.wdcloud.kono.task;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.wdcloud.kono.config.rltconfig.Code;
import com.wdcloud.kono.mapper.*;
import com.wdcloud.kono.model.*;
import com.wdcloud.kono.task.dto.UserDTO;
import com.wdcloud.kono.utils.HttpClientUtil;
import com.wdcloud.utils.ListUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.List;

@Slf4j
@Component
public class ResiterLmsUserByKonoTask {

    @Value("${lms.url}")
    private String lmsUrl;
    @Value("${lms.initRootOrg}")
    private String initRootOrg;

    @Autowired
    private ErpUserMapper  erpUserMapper;

    @Autowired
    private ErpUserprofilMapper erpUserprofilMapper;

    @Autowired
    private ErpEntitejuridiqueprofilMapper erpEntitejuridiqueprofilMapper;

    @Autowired
    private ErpEntitejuridiqueMapper erpEntitejuridiqueMapper;

    @Autowired
    private SysOrgMapper sysOrgMapper;
    /**
     * 每天凌晨2点执行一次
     * 注册lms用户
     * @throws Exception
     */
//    @Scheduled(cron = "0 0/5 * * * ?")
//    @Scheduled(cron = "0/5 * * * * ?")
    @Scheduled(cron = "0 0 2 * * ?")
    public void task() throws Exception {
      log.info("【ResiterLmsUserByKonoTask】开始时间:{}",System.currentTimeMillis());
      work();
      log.info("【ResiterLmsUserByKonoTask】结束时间:{}",System.currentTimeMillis());
    }

    private void work() {
       List<ErpUser> erpUserList= erpUserMapper.select(ErpUser.builder().status(0).build());
        if (ListUtils.isNotEmpty(erpUserList)) {
            erpUserList.forEach(erpUser -> {

                ErpUserprofil erpUserprofil= erpUserprofilMapper.selectOne(ErpUserprofil.builder().idUser(erpUser.getIdUser()).build());
                if (erpUserprofil == null) {
                    log.info("IdUser===={}没有机构",erpUser.getIdUser());
                }

                ErpEntitejuridiqueprofil erpEntitejuridiqueprofil = erpEntitejuridiqueprofilMapper.selectOne(ErpEntitejuridiqueprofil.builder().idProfil(erpUserprofil.getIdProfil()).build());
                if (erpEntitejuridiqueprofil != null) {
                    //机构ID
                    ErpEntitejuridique que=erpEntitejuridiqueMapper.selectOne(ErpEntitejuridique.builder().idEntitejuridique(erpEntitejuridiqueprofil.getIdEntitejuridique()).build());
                    SysOrg sysOrg=sysOrgMapper.selectOne(SysOrg.builder().sisId(que.getNom()).build());
                    if (sysOrg == null) {
                        JSONObject json = new JSONObject();
                        json.put("userName",que.getNom());
                        json.put("pwd","12345678");
                        json.put("orgName",que.getNom());
                        String org=HttpClientUtil.sendPostRequestByJson(initRootOrg, json.toJSONString());
                        log.info("org注册结果==>{}",org);
                        sysOrg = sysOrgMapper.selectOne(SysOrg.builder().sisId(que.getCode()).build());
                    }
                    UserDTO signUpVo = UserDTO.builder()
                            .firstName(erpUser.getPrenom())
                            .lastName(erpUser.getNom())
                            .loginId(erpUser.getNom())
                            .orgId(sysOrg.getId())
                            .orgTreeId(sysOrg.getTreeId())
                            .locationId(64)
                            .roleId(getRoleId(erpUser.getRoleUser()))
                            .password(erpUser.getPassword())
                            .email(erpUser.getMailgem())
                            .build();
                    String rlt=HttpClientUtil.sendPostRequestByJson(lmsUrl, JSON.toJSONString(signUpVo));
                    log.info("======用户注册结果======>\n{}",rlt);
                    if (Code.OK.code == JSON.parseObject(rlt).getIntValue("code")) {
                        erpUserMapper.updateByPrimaryKeySelective(ErpUser.builder().id(erpUser.getId()).status(1).build());
                    }

                }else{
                    log.info("IdUser={},IdProfil={} 查无机构 erpEntitejuridiqueprofil",erpUserprofil.getIdUser(),erpUserprofil.getIdProfil());
                }
            });
        }
    }

    private Long getRoleId(String roleUser) {
        if ("Enseignant".equals(roleUser)) {
            return 2L;
        }else if ("Utilistateur".equals(roleUser)) {
            return 4L;
        }
        return 4L;
    }

}