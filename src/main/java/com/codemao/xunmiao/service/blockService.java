package com.codemao.xunmiao.service;

import com.codemao.xunmiao.domain.blockEntity;

public interface blockService {
    /**
     * 获得小组信息
     * @param id 组号
     * @param floor 楼层号
     * @return
     */
    blockEntity getBlockEntity(Integer id, Integer floor);
}
