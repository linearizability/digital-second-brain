package pers.boyuan.boot.dictionary;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import pers.boyuan.api.in.dictionary.CreateDictionaryAO;
import pers.boyuan.api.in.dictionary.DeleteDictionaryAO;
import pers.boyuan.api.in.dictionary.QueryDictionaryAO;
import pers.boyuan.api.in.dictionary.UpdateDictionaryAO;
import pers.boyuan.application.dictionary.DictionaryAppService;

import java.util.Arrays;

/**
 * 字典表相关测试类
 *
 * @author ZhangBoyuan
 * @date 2022-07-19
 */
@SpringBootTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class DictionaryTests {
    @Autowired
    private DictionaryAppService dictionaryAppService;

    @Test
    @Order(1)
    void createTest() {
        var ao1 = new CreateDictionaryAO();
        ao1.setCode("1");
        ao1.setType("test");
        ao1.setName("test1");
        ao1.setRemark("测试");
        var ao2 = new CreateDictionaryAO();
        ao2.setCode("2");
        ao2.setType("test");
        ao2.setName("test2");
        ao2.setRemark("测试");
        var aoList = Arrays.asList(ao1, ao2);

        var flag = dictionaryAppService.create(aoList);

        System.out.println("----------createFlag = " + flag);
    }

    @Test
    @Order(2)
    void updateTest() {
        var param = new QueryDictionaryAO();
        param.setType("test");

        var testEntity = dictionaryAppService.query(param);

        var ao = new UpdateDictionaryAO();
        ao.setName("updateTest");
        ao.setId(testEntity.get("test").get(0).getId());

        var flag = dictionaryAppService.update(ao);

        System.out.println("----------updateFlag = " + flag);
    }

    @Test
    void queryAllTest() {
        var allEntity = dictionaryAppService.query(null);

        allEntity.keySet().forEach(
                key -> allEntity.get(key).forEach(System.out::println)
        );
    }

    @Test
    void queryPartTest() {
        var param = new QueryDictionaryAO();
        param.setType("test");

        var partEntity = dictionaryAppService.query(param);

        partEntity.keySet().forEach(
                key -> partEntity.get(key).forEach(System.out::println)
        );
    }

    @Test
    void deleteTest() {
        var ao = new DeleteDictionaryAO();
        ao.setType("test");

        var flag = dictionaryAppService.delete(ao);

        System.out.println("----------deleteFlag = " + flag);
    }

}
