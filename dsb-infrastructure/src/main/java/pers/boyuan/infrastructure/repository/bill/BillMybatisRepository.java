package pers.boyuan.infrastructure.repository.bill;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import pers.boyuan.domain.bill.model.BillModel;
import pers.boyuan.domain.bill.repository.BillRepository;
import pers.boyuan.infrastructure.converter.bill.BillEntityConverter;
import pers.boyuan.infrastructure.db.entity.Bill;
import pers.boyuan.infrastructure.db.mapper.BillMapper;
import pers.boyuan.infrastructure.db.service.IBillService;

import java.util.Collection;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import static java.lang.Boolean.FALSE;
import static java.lang.Boolean.TRUE;

/**
 * 账单表底层数据库接口 Mybatis 实现类
 *
 * @author ZhangBoyuan
 * @since 2022-06-22
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
        var billList = BillEntityConverter.INSTANCE.modelToEntity(modelList);
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

        return billMapper.updateById(bill) > 0 ? TRUE : FALSE;
    }

    /**
     * 根据指定条件查询账单表数据
     *
     * @param model 指定条件
     * @return 查询账单表数据
     */
    @Override
    public List<BillModel> query(BillModel model) {
        var queryWrapper = buildBasicQueryWrapper(model);

        var queryResult = billService.list(queryWrapper);

        return outputParametersProcessor(queryResult);
    }

    /**
     * 查询账单表数据分页
     *
     * @param param 查询账单表数据分页入参
     * @return 查询账单表分页数据
     */
    @Override
    public IPage<BillModel> queryPage(BillModel param) {
        IPage<Bill> pageParam = new Page<>(param.getPageIndex(), param.getPageSize());

        var queryWrapper = buildBasicQueryWrapper(param);
        var queryResult = billMapper.selectPage(pageParam, queryWrapper);

        return queryResult.convert(BillEntityConverter.INSTANCE::entityToModel);
    }

    /**
     * 查询账单通用wrapper
     *
     * @param model 查询条件
     * @return 生成wrapper
     */
    private LambdaQueryWrapper<Bill> buildBasicQueryWrapper(BillModel model) {
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

    /**
     * 函数出参处理器
     *
     * @param entityList 实例集合
     * @return 领域模型类
     */
    private List<BillModel> outputParametersProcessor(Collection<Bill> entityList) {
        return CollectionUtils.emptyIfNull(entityList)
                .stream()
                .map(BillEntityConverter.INSTANCE::entityToModel)
                .collect(Collectors.toList());
    }

}
