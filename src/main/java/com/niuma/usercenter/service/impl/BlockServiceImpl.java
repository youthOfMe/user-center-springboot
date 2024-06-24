package com.niuma.usercenter.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.niuma.usercenter.mapper.BlockMapper;
import com.niuma.usercenter.model.domain.Block;
import com.niuma.usercenter.service.BlockService;
import org.springframework.stereotype.Service;

/**
* @author 20406
* @description 针对表【block(帖子板块)】的数据库操作Service实现
* @createDate 2024-06-24 22:55:50
*/
@Service
public class BlockServiceImpl extends ServiceImpl<BlockMapper, Block>
    implements BlockService {

}




