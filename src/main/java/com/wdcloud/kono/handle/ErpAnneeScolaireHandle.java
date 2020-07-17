package com.wdcloud.kono.handle;

import com.wdcloud.kono.constant.Constants;
import com.wdcloud.kono.handle.base.Handle;
import com.wdcloud.kono.handle.base.Request;
import com.wdcloud.kono.handle.dto.ErpAnneeScolaireDTO;
import com.wdcloud.kono.mapper.ErpAnneeScolaireMapper;
import com.wdcloud.kono.model.ErpAnneeScolaire;
import com.wdcloud.kono.utils.SysUtils;
import com.wdcloud.utils.ListUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import tk.mybatis.mapper.entity.Example;

import java.util.List;

/**
 * @author wangff
 * @date 2020/6/30 10:05
 */
@Slf4j
@Component
public class ErpAnneeScolaireHandle implements Handle {

    @Autowired
    private ErpAnneeScolaireMapper erpAnneeScolaireMapper;

    @Override
    public void handleRequest(Request request) {
        log.info("{} 开始工作!",this.getClass());

        List<ErpAnneeScolaireDTO> dtoList= SysUtils.getDataFromKono(Constants.TABLE_ERP_ANNEESCOLAIRE, ErpAnneeScolaireDTO.class);
        if (ListUtils.isNotEmpty(dtoList)) {
            Example example= new Example(ErpAnneeScolaire.class);
            example.createCriteria().andNotIn("id", List.of(0));
            erpAnneeScolaireMapper.deleteByExample(example);
            erpAnneeScolaireMapper.batchInsert(dtoList);
        }
        log.info("{} 结束工作!",this.getClass());
    }
}
