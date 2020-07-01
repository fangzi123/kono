package com.wdcloud.kono.handle;

import com.wdcloud.kono.constant.Constants;
import com.wdcloud.kono.handle.base.Handle;
import com.wdcloud.kono.handle.base.Request;
import com.wdcloud.kono.handle.dto.ErpInstancemoduleDTO;
import com.wdcloud.kono.mapper.ErpInstancemoduleMapper;
import com.wdcloud.kono.model.ErpInstancemodule;
import com.wdcloud.kono.utils.SysUtils;
import com.wdcloud.utils.ListUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import tk.mybatis.mapper.entity.Example;

import java.util.List;

/**
 * @author wangff
 * @date 2020/6/30 10:13
 */
@Slf4j
@Component
public class ErpInstancemoduleHandle implements Handle {

    @Autowired
    private ErpInstancemoduleMapper mapper;

    @Override
    public void handleRequest(Request request) {
        log.info("{} 开始工作!",this.getClass());

        List<ErpInstancemoduleDTO> dtoList= SysUtils.getDataFromKono(Constants.TABLE_ERP_INSTANCEMODULE,ErpInstancemoduleDTO.class);
        if (ListUtils.isNotEmpty(dtoList)) {
            Example example= new Example(ErpInstancemodule.class);
            example.createCriteria().andNotIn("id", List.of(0));
            mapper.deleteByExample(example);
            mapper.batchInsert(dtoList);
        }
        log.info("{} 结束工作!",this.getClass());
    }
}
