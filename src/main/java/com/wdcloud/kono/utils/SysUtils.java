package com.wdcloud.kono.utils;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.wdcloud.kono.constant.Constants;
import lombok.extern.slf4j.Slf4j;

import java.util.List;

/**
 * @author wangff
 * @date 2020/6/30 16:52
 */
@Slf4j
public class SysUtils {

    public static <T> List<T>  getDataFromKono(String tableName,Class clazz) {
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("NameTable",tableName);
        jsonObject.put("SecureKey", Constants.SECUREKEY);

        String rlt =   HttpClientUtil.sendPostRequestByJson(Constants.KONOSYS, jsonObject.toJSONString());
        if (!HttpClientUtil.COMMUNICATION_FAILURE.equals(rlt)) {
            List<T> dtoList= JsonUtil.parseArray(JSON.parseObject(rlt).getString("d"),clazz);
            if (dtoList != null&&dtoList.size()>0) {
                dtoList.remove(0);
            }
            return dtoList;
        }
        return null;
    }
}
