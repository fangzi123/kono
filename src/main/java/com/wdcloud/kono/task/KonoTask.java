package com.wdcloud.kono.task;

import com.wdcloud.kono.handle.*;
import com.wdcloud.kono.handle.base.Handle;
import com.wdcloud.kono.handle.base.HandleChain;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@Component
public class KonoTask {
    @Autowired
    private ErpUserHandle erpUserHandle;
    @Autowired
    private ErpAnneeScolaireHandle erpAnneeScolaireHandle;
    @Autowired
    private ErpCursusHandle erpCursusHandle;
    @Autowired
    private ErpDiplomeHandle erpDiplomeHandle;
    @Autowired
    private ErpEcoleHandle erpEcoleHandle;
    @Autowired
    private ErpEntitejuridiqueHandle erpEntitejuridiqueHandle;
    @Autowired
    private ErpInstanceCursusHandle erpInstanceCursusHandle;
    @Autowired
    private ErpInstancemoduleHandle erpInstancemoduleHandle;
    @Autowired
    private ErpInstancemoduleprofHandle erpInstancemoduleprofHandle;
    @Autowired
    private ErpLiaisongroupeinstancemoduleHandle erpLiaisongroupeinstancemoduleHandle;
    @Autowired
    private ErpModuleHandle erpModuleHandle;
    @Autowired
    private ErpSeanceHandle erpSeanceHandle;
    @Autowired
    private ErpSessionProgrammeHandle erpSessionProgrammeHandle;

    /**
     * 每天凌晨2点执行一次
     * @throws Exception
     */
//    @Scheduled(cron = "0 0/30 * * * ?")
//    @Scheduled(cron = "0/10 * * * * ?")
    @Scheduled(cron = "0 0 2 * * ?")
    public void task() throws Exception {
      log.info("【KonoTask】开始时间:{}",System.currentTimeMillis());
      work();
      log.info("【KonoTask】结束时间:{}",System.currentTimeMillis());
    }

    private void work() {
        List<Handle> handles = new ArrayList<>();
        handles.add(erpUserHandle);
        handles.add(erpAnneeScolaireHandle);
        handles.add(erpCursusHandle);
        handles.add(erpDiplomeHandle);
        handles.add(erpEcoleHandle);
        handles.add(erpEntitejuridiqueHandle);
        handles.add(erpInstanceCursusHandle);
        handles.add(erpInstancemoduleHandle);
        handles.add(erpInstancemoduleprofHandle);
        handles.add(erpLiaisongroupeinstancemoduleHandle);
        handles.add(erpModuleHandle);
        handles.add(erpSeanceHandle);
        handles.add(erpSessionProgrammeHandle);

        HandleChain chain =new HandleChain(handles);
        chain.intercept(null,null);
    }

}