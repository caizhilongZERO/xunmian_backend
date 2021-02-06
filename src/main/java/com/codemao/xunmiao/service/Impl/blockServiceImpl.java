package com.codemao.xunmiao.service.Impl;

import com.codemao.xunmiao.domain.blockEntity;
import com.codemao.xunmiao.mapper.BlockInfoMapper;
import com.codemao.xunmiao.service.blockService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class blockServiceImpl implements blockService {
    @Autowired
    BlockInfoMapper blockInfoMapper;

    @Override
    public blockEntity getBlockEntity(Integer id, Integer floor) {
        blockEntity blockEntity = blockInfoMapper.getBlockEntityByidAndfloor(id, floor);
        return blockEntity != null ? blockEntity : null;
    }
}
