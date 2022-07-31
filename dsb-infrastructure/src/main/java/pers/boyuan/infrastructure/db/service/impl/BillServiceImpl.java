package pers.boyuan.infrastructure.db.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import pers.boyuan.infrastructure.db.entity.Bill;
import pers.boyuan.infrastructure.db.mapper.BillMapper;
import pers.boyuan.infrastructure.db.service.IBillService;

/**
 * 消费账单表 服务实现类
 *
 * @author ZhangBoyuan
 * @date 2022-06-22
 */
@Service
public class BillServiceImpl extends ServiceImpl<BillMapper, Bill> implements IBillService {

}
