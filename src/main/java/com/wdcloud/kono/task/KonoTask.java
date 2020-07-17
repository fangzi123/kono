package com.wdcloud.kono.task;

import com.wdcloud.kono.handle.base.Handle;
import com.wdcloud.kono.handle.base.HandleChain;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.List;

@Slf4j
@Component
public class KonoTask {

    @Autowired
    private List<Handle> handles;

    /**
     * 每天凌晨2点执行一次
     * sync kono to lms
     * @throws Exception
     */
    @Scheduled(cron = "0 0/5 * * * ?")
//    @Scheduled(cron = "0/10 * * * * ?")
//    @Scheduled(cron = "0 0 2 * * ?")
    public void task() throws Exception {
      log.info("【KonoTask】开始时间:{}",System.currentTimeMillis());
      work();
      log.info("【KonoTask】结束时间:{}",System.currentTimeMillis());
    }

    private void work() {
        HandleChain chain =new HandleChain(handles);
        chain.intercept(null,null);
    }

}