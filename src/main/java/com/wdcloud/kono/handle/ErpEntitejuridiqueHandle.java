package com.wdcloud.kono.handle;

import com.wdcloud.kono.handle.base.Handle;
import com.wdcloud.kono.handle.base.Request;
import com.wdcloud.kono.handle.dto.ErpEntitejuridiqueDTO;
import com.wdcloud.kono.mapper.ErpEntitejuridiqueMapper;
import com.wdcloud.kono.model.ErpEntitejuridique;
import com.wdcloud.kono.constant.Constants;
import com.wdcloud.kono.utils.SysUtils;
import com.wdcloud.utils.ListUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import tk.mybatis.mapper.entity.Example;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @author wangff
 * @date 2020/6/30 10:09
 */
@Slf4j
@Component
public class ErpEntitejuridiqueHandle implements Handle {

    @Autowired
    private ErpEntitejuridiqueMapper erpEntitejuridiqueMapper;

    @Override
    public void handleRequest(Request request) {
        log.info("{} 开始工作!",this.getClass());
        if (ListUtils.isNotEmpty(erpEntitejuridiqueMapper.selectAll())) {
            return;
        }
        List<ErpEntitejuridiqueDTO> dtoList= SysUtils.getDataFromKono(Constants.TABLE_ERP_ENTITEJURIDIQUE, ErpEntitejuridiqueDTO.class);
        if (ListUtils.isNotEmpty(dtoList)) {
            Example example= new Example(ErpEntitejuridique.class);
            example.createCriteria().andNotIn("id", List.of(0));
            erpEntitejuridiqueMapper.deleteByExample(example);

            List<ErpEntitejuridique> modelList = new ArrayList<>();
            dtoList.forEach(dto -> {
                ErpEntitejuridique model = new ErpEntitejuridique();
                model.setIdEntitejuridique(Long.valueOf(dto.getIdEntitejuridique()));
                model.setNom(dto.getNom());
                model.setCode(dto.getCode());
                model.setStatus(0);
                model.setCreateTime(new Date());
                model.setUpdateTime(new Date());
                modelList.add(model);
                erpEntitejuridiqueMapper.insert(model);
            });
//            erpEntitejuridiqueMapper.batchInsert(modelList);

        }

        log.info("{} 结束工作!",this.getClass());
    }
}
