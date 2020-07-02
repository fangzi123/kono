package com.wdcloud.kono.task;

import com.alibaba.fastjson.JSON;
import com.wdcloud.kono.config.rltconfig.Code;
import com.wdcloud.kono.mapper.ErpUserMapper;
import com.wdcloud.kono.model.ErpUser;
import com.wdcloud.kono.task.dto.UserSignUpVo;
import com.wdcloud.kono.utils.HttpClientUtil;
import com.wdcloud.utils.ListUtils;
import com.wdcloud.utils.StringUtil;
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

    @Autowired
    private ErpUserMapper  mapper;

    /**
     * 每天凌晨2点执行一次
     * @throws Exception
     */
//    @Scheduled(cron = "0 0/5 * * * ?")
    @Scheduled(cron = "0/5 * * * * ?")
//    @Scheduled(cron = "0 0 2 * * ?")
    public void task() throws Exception {
      log.info("【ResiterLmsUserByKonoTask】开始时间:{}",System.currentTimeMillis());
      work();
      log.info("【ResiterLmsUserByKonoTask】结束时间:{}",System.currentTimeMillis());
    }

    private void work() {
       List<ErpUser> erpUserList= mapper.select(ErpUser.builder().status(0).build());
        if (ListUtils.isNotEmpty(erpUserList)) {
            erpUserList.forEach(erpUser -> {

                UserSignUpVo signUpVo = UserSignUpVo.builder()
                        .firstName(erpUser.getPrenom())
                        .lastName(erpUser.getNom())
                        .locationId(7)
                        .password(erpUser.getPassword())
                        .username(erpUser.getUsername())
                        .email(StringUtil.isEmpty(erpUser.getMailgem())?"lms@lms.com":erpUser.getMailgem())
                        .build();
                String rlt=HttpClientUtil.sendPostRequestByJson(lmsUrl, JSON.toJSONString(signUpVo));
                log.info("======注册结果======>\n{}",rlt);
                if (Code.OK.code == JSON.parseObject(rlt).getIntValue("code")) {
                    mapper.updateByPrimaryKeySelective(ErpUser.builder().id(erpUser.getId()).status(1).build());
                }
            });
        }
    }

}