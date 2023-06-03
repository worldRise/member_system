package com.auther.fan.member_system.util;

import com.auther.fan.member_system.vo.QueryMemberVo;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;

import java.util.ArrayList;
import java.util.List;

public class QueryPageUtils {
    /**
     * 自定义分页工具类
     * @param queryMemberVos 查询成员列表
     * @param pageNum 当前页码
     * @param pageSize 每页显示的记录数
     * @return IPage<QueryMemberVo> 分页后的数据列表
     */
    public static <T> IPage<T> getPage(List<T> queryMemberVos, int pageNum, int pageSize) {
        // 计算分页所需的参数
        int startIndex = (pageNum - 1) * pageSize;
        int endIndex = Math.min(startIndex + pageSize, queryMemberVos.size());
        List<T> pageData = new ArrayList<>();
        for (int i = startIndex; i < endIndex; i++) {
            pageData.add(queryMemberVos.get(i));
        }
        IPage<T> page = new Page<>(pageNum,pageSize);
        page.setRecords(pageData);
        page.setTotal(queryMemberVos.size());
        return page;
    }
}


