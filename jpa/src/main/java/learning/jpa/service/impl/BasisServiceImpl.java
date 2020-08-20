package learning.jpa.service.impl;

import java.util.List;

/**
 * @Classname UserServiceImpl
 * @Description TODO 基础方法接口
 * @Date 2020/8/19 10:50 上午
 * @Author z7-x
 */
public interface BasisServiceImpl<T> {
    /**
     * 新增操作对象
     */
    List<T> add(List<T> params);

    /**
     * 移除操作对象
     */
    boolean remove(Long id);

    /**
     * 修改操作对象
     */
    T modify(T param);

    /**
     * 根据id查询
     */
    T findById(Long id);

    /**
     * 按照过滤条件筛选操作对象
     */
    List<T> findAll(T param);
}
