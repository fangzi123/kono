package com.wdcloud.kono.handle;

import com.wdcloud.kono.handle.base.Handle;
import com.wdcloud.kono.handle.base.Request;
import com.wdcloud.kono.handle.dto.ErpDiplomeDTO;
import com.wdcloud.kono.mapper.ErpDiplomeMapper;
import com.wdcloud.kono.model.ErpDiplome;
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
@Slf4j
@Component
public class ErpDiplomeHandle implements Handle {
    @Autowired
    private ErpDiplomeMapper erpDiplomeMapper;

    @Override
    public void handleRequest(Request request) {
        log.info("{} 开始工作!",this.getClass());

        List<ErpDiplomeDTO> dtoList= SysUtils.getDataFromKono(Constants.TABLE_ERP_DIPLOME, ErpDiplomeDTO.class);
        if (ListUtils.isNotEmpty(dtoList)) {
            Example example= new Example(ErpDiplome.class);
            example.createCriteria().andNotIn("id", List.of(0));
            erpDiplomeMapper.deleteByExample(example);
            erpDiplomeMapper.batchInsert(dtoList);
        }
        log.info("{} 结束工作!",this.getClass());
    }
}
