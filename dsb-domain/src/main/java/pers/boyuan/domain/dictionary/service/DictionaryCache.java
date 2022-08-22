package pers.boyuan.domain.dictionary.service;

import com.google.common.collect.Table;
import com.google.common.collect.TreeBasedTable;
import lombok.var;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Map;

/**
 * 字典表缓存类
 *
 * @author ZhangBoyuan
 * @date 2022-08-22
 */
@Component
public class DictionaryCache implements InitializingBean {

    @Autowired
    private DictionaryDomainService dictionaryDomainService;

    public static Table<String, String, String> dictionaryTable = TreeBasedTable.create();

    @Override
    public void afterPropertiesSet() throws Exception {
        var existDictionary = dictionaryDomainService.getAll();

        existDictionary.forEach(
                item -> dictionaryTable.put(item.getType(), item.getCode(), item.getName())
        );
    }

    /**
     * 获取字典名称
     *
     * @param type 字典类别
     * @param code 字典编码
     * @return 字典名称
     */
    public String getDictionaryName(String type, String code) {
        return dictionaryTable.row(type).get(code);
    }

}
