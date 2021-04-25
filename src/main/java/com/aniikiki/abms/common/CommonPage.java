package com.aniikiki.abms.common;

import com.github.pagehelper.PageInfo;
import lombok.Data;

import java.util.List;

/**
 * 分页数据封装类
 * @author aniikiki
 * @date 2021-04-16 14:13:37
 */
@Data
public class CommonPage<T> {

    private Integer pageNum; //当前页码
    private Integer pageSize; //每页显示记录数
    private Integer totalPage; //总页数
    private Long total; //总记录数
    private List<T> list;

    /**
     * 将PageHelper分页后的list转为分页信息
     */
    public static <T> CommonPage<T> restPage(List<T> list) {
        CommonPage<T> result = new CommonPage<T>();
        PageInfo<T> pageInfo = new PageInfo<T>(list);
        result.setTotalPage(pageInfo.getPages());
        result.setPageNum(pageInfo.getPageNum());
        result.setPageSize(pageInfo.getPageSize());
        result.setTotal(pageInfo.getTotal());
        result.setList(pageInfo.getList());
        return result;
    }

    /**
     * 将PageHelper分页后的list转为pageInfo分页信息
     */
    public static <T> PageInfo<T> restPageInfo(List<T> list) {
        return new PageInfo<T>(list);
    }

}
