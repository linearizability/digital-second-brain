package pers.boyuan.infrastructure.repository.bill;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import lombok.var;
import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import pers.boyuan.domain.bill.model.BillModel;
import pers.boyuan.domain.bill.repository.BillRepository;
import pers.boyuan.infrastructure.converter.bill.BillEntityConverter;
import pers.boyuan.infrastructure.db.entity.Bill;
import pers.boyuan.infrastructure.db.mapper.BillMapper;
import pers.boyuan.infrastructure.db.service.IBillService;

import java.util.Collections;
import java.util.List;
import java.util.Objects;

/**
 * 字典表底层数据库接口 Mybatis 实现类
 *
 * @author ZhangBoyuan
 * @date 2022-06-22
 */
@Component
public class BillMybatisRepository implements BillRepository {

    @Autowired
    private BillMapper billMapper;

    @Autowired
    private IBillService billService;

    /**
     * 创建账单表数据
     *
     * @param modelList 创建账单表数据入参列表
     * @return 是否创建成功
     */
    @Override
    public Boolean create(List<BillModel> modelList) {
        var billList = BillEntityConverter.INSTANCE.modelToEntityList(modelList);
        return billService.saveBatch(billList);
    }

    /**
     * 根据主键id删除账单表数据
     *
     * @param idList 主键id列表
     * @return 是否删除成功
     */
    @Override
    public Boolean delete(List<Long> idList) {
        return billService.removeByIds(idList);
    }

    /**
     * 更新账单表数据
     *
     * @param model 更新账单表数据入参
     * @return 是否更新成功
     */
    @Override
    public Boolean update(BillModel model) {
        Bill bill = BillEntityConverter.INSTANCE.modelToEntity(model);

        return billMapper.updateById(bill) > 0 ? Boolean.TRUE : Boolean.FALSE;
    }

    /**
     * 根据指定条件查询账单表数据
     *
     * @param model 指定条件
     * @return 查询账单表数据
     */
    @Override
    public List<BillModel> query(BillModel model) {
        var queryWrapper = getQueryBillWrapper(model);

        var queryResult = billService.list(queryWrapper);

        if (CollectionUtils.isNotEmpty(queryResult)) {
            return BillEntityConverter.INSTANCE.entityToModelList(queryResult);
        }

        return Collections.emptyList();
    }

    /**
     * 查询账单表数据分页
     *
     * @param model 查询账单表数据分页入参
     * @param iPage 分页page
     * @return 查询账单表分页数据
     */
    @Override
    public IPage<BillModel> queryPage(BillModel model, IPage<BillModel> iPage) {
        var queryWrapper = getQueryBillWrapper(model);

        IPage<Bill> billIPage = new Page<>(iPage.getCurrent(), iPage.getSize());
        IPage<BillModel> result = new Page<>();

        var queryResult = billMapper.selectPage(billIPage, queryWrapper);

        if (CollectionUtils.isEmpty(queryResult.getRecords())) {
            return result;
        }

        BeanUtils.copyProperties(queryResult, result);
        result.setRecords(BillEntityConverter.INSTANCE.entityToModelList(queryResult.getRecords()));

        return result;
    }

    /**
     * 查询账单通用wrapper
     *
     * @param model 查询条件
     * @return 生成wrapper
     */
    private LambdaQueryWrapper<Bill> getQueryBillWrapper(BillModel model) {
        Bill bill = BillEntityConverter.INSTANCE.modelToEntity(model);

        return Wrappers.<Bill>lambdaQuery()
                .eq(Objects.nonNull(bill.getId()), Bill::getId, bill.getId())
                .eq(Objects.nonNull(bill.getType()), Bill::getType, bill.getType())
                .eq(Objects.nonNull(bill.getCategoryCode()), Bill::getCategoryCode, bill.getCategoryCode())
                .like(StringUtils.isNotBlank(bill.getContent()), Bill::getContent, bill.getContent())
                .like(StringUtils.isNotBlank(bill.getRemark()), Bill::getRemark, bill.getRemark())
                .eq(Objects.nonNull(bill.getAmount()), Bill::getAmount, bill.getAmount())
                .between(StringUtils.isNotBlank(model.getBeginPaymentTime())
                                && StringUtils.isNotBlank(model.getEndPaymentTime()),
                        Bill::getPaymentTime,
                        model.getBeginPaymentTime(), model.getEndPaymentTime());
    }

}
