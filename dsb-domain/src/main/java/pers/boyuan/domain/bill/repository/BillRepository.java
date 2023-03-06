package pers.boyuan.domain.bill.repository;

import com.baomidou.mybatisplus.core.metadata.IPage;
import pers.boyuan.domain.bill.model.BillModel;

import java.util.List;

/**
 * 账单表底层数据库接口
 *
 * @author ZhangBoyuan
 * @date 2022-06-22
 */
public interface BillRepository {

    /**
     * 创建账单表数据
     *
     * @param modelList 创建账单表数据入参列表
     * @return 是否创建成功
     */
    Boolean create(List<BillModel> modelList);

    /**
     * 根据主键id删除账单表数据
     *
     * @param idList 主键id列表
     * @return 是否删除成功
     */
    Boolean delete(List<Long> idList);

    /**
     * 更新账单表数据
     *
     * @param model 更新账单表数据入参
     * @return 是否更新成功
     */
    Boolean update(BillModel model);

    /**
     * 根据指定条件查询账单表数据
     *
     * @param model 指定条件
     * @return 查询账单表数据
     */
    List<BillModel> query(BillModel model);

    /**
     * 查询账单表数据分页
     *
     * @param model 查询账单表数据分页入参
     * @return 查询账单表分页数据
     */
    IPage<BillModel> queryPage(BillModel model);

}
