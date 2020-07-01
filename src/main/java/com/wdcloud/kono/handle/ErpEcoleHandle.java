package com.wdcloud.kono.handle;

import com.wdcloud.kono.handle.base.Handle;
import com.wdcloud.kono.handle.base.Request;
import com.wdcloud.kono.handle.dto.ErpEcoleDTO;
import com.wdcloud.kono.mapper.ErpEcoleMapper;
import com.wdcloud.kono.model.ErpEcole;
import com.wdcloud.kono.constant.Constants;
import com.wdcloud.kono.utils.SysUtils;
import com.wdcloud.utils.ListUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import tk.mybatis.mapper.entity.Example;

import java.util.List;

/**
 * @author wangff
 * @date 2020/6/30 10:09
 */
@Component
@Slf4j
public class ErpEcoleHandle implements Handle {
    @Autowired
    private ErpEcoleMapper erpEcoleMapper;
    @Override
    public void handleRequest(Request request) {
        log.info("{} 开始工作!",this.getClass());

        List<ErpEcoleDTO> dtoList= SysUtils.getDataFromKono(Constants.TABLE_ERP_ECOLE, ErpEcoleDTO.class);
        if (ListUtils.isNotEmpty(dtoList)) {
            Example example= new Example(ErpEcole.class);
            example.createCriteria().andNotIn("id", List.of(0));
            erpEcoleMapper.deleteByExample(example);
            erpEcoleMapper.batchInsert(dtoList);
        }
        log.info("{} 结束工作!",this.getClass());
    }

}
