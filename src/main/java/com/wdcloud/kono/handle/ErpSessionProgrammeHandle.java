package com.wdcloud.kono.handle;

import com.wdcloud.kono.constant.Constants;
import com.wdcloud.kono.handle.base.Handle;
import com.wdcloud.kono.handle.base.Request;
import com.wdcloud.kono.handle.dto.ErpSessionProgrammeDTO;
import com.wdcloud.kono.handle.dto.ErpUserDTO;
import com.wdcloud.kono.mapper.ErpSessionProgrammeMapper;
import com.wdcloud.kono.mapper.ErpUserMapper;
import com.wdcloud.kono.model.ErpSessionProgramme;
import com.wdcloud.kono.model.ErpUser;
import com.wdcloud.kono.utils.SysUtils;
import com.wdcloud.utils.ListUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import tk.mybatis.mapper.entity.Example;

import java.util.List;

/**
 * @author wangff
 * @date 2020/6/29 17:07
 */
@Slf4j
@Component
public class ErpSessionProgrammeHandle implements Handle {

    @Autowired
    private ErpSessionProgrammeMapper erpSessionProgrammeMapperr;

    @Override
    public void handleRequest(Request request) {
        log.info("{} 开始工作!",this.getClass());

        List<ErpSessionProgrammeDTO> dtoList= SysUtils.getDataFromKono(Constants.TABLE_ERP_SESSIONPROGRAMME, ErpSessionProgrammeDTO.class);
        if (ListUtils.isNotEmpty(dtoList)) {
            Example example= new Example(ErpSessionProgramme.class);
            example.createCriteria().andNotIn("id", List.of(0));
            erpSessionProgrammeMapperr.deleteByExample(example);
            erpSessionProgrammeMapperr.batchInsert(dtoList);
        }
        log.info("{} 结束工作!",this.getClass());
    }
}
