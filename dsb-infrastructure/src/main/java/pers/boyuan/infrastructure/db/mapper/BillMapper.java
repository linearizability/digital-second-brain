package pers.boyuan.infrastructure.db.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import pers.boyuan.infrastructure.db.entity.Bill;

/**
 * 消费账单表 Mapper 接口
 *
 * @author ZhangBoyuan
 * @date 2022-06-22
 */
@Mapper
public interface BillMapper extends BaseMapper<Bill> {

}
