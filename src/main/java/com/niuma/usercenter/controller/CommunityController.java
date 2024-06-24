package com.niuma.usercenter.controller;

import com.niuma.usercenter.common.BaseResponse;
import com.niuma.usercenter.common.ResultUtils;
import com.niuma.usercenter.model.domain.Block;
import com.niuma.usercenter.service.BlockService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("/community")
@Slf4j
public class CommunityController {

    @Resource
    BlockService blockService;

    /**
     * 获取板块列表
     * @return
     */
    @GetMapping("/listBlock")
    public BaseResponse<List<Block>> listBlock() {
        List<Block> blockList = blockService.list();
        return ResultUtils.success(blockList);
    }

}
