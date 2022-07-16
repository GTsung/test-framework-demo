package com.ms.util;

import com.ms.exception.TestException;
import tk.mybatis.mapper.common.ConditionMapper;
import tk.mybatis.mapper.common.Mapper;
import tk.mybatis.mapper.common.MySqlMapper;
import tk.mybatis.mapper.entity.Condition;
import tk.mybatis.mapper.entity.Example;

import java.util.List;

public interface BaseDao<T> extends Mapper<T>, ConditionMapper<T>, MySqlMapper<T> {

    /**
     * 根据条件更新一条数据
     *
     * @param model
     * @param example
     * @return
     */
    default int updateOneByExample(T model, Example example) {
        List<T> selectedModelList = selectByExample(example);
        if (null != selectedModelList && selectedModelList.size() > 1) {
            // 如果根据条件查询出的数据条数不止一条，报错
            throw new TestException("更新数量指定为1，但是根据条件查询数量大于一，请联系人员检查数据");
        }
        // 此处为非强制更新，null值不会更新
        return updateByExampleSelective(model, example);
    }

    /**
     * 根据条件更新一条数据
     *
     * @param model
     * @param condition
     * @return
     */
    default int updateOneByCondition(T model, Condition condition) {
        List<T> selectedModelList = selectByCondition(condition);
        if (null != selectedModelList && selectedModelList.size() > 1) {
            // 如果根据条件查询出的数据条数不止一条，报错
            throw new TestException("更新数量指定为1，但是根据条件查询数量大于一，请联系人员检查数据");
        }
        // 此处为非强制更新，null值不会更新
        return updateByConditionSelective(model, condition);
    }

    /**
     * 根据条件强制更新
     * @param model
     * @param example
     * @return
     */
    default int forceUpdateOneByExample(T model, Example example) {
        List<T> selectedModelList = selectByExample(example);
        if (null != selectedModelList && selectedModelList.size() > 1) {
            // 如果根据条件查询出的数据条数不止一条，报错
            throw new TestException("更新数量指定为1，但是根据条件查询数量大于一，请联系人员检查数据");
        }
        // 此处为强制更新，null值会更新
        return updateByExample(model, example);
    }

    /**
     * 根据条件强制更新一条数据
     *
     * @param model
     * @param condition
     * @return
     */
    default int forceUpdateOneByCondition(T model, Condition condition) {
        List<T> selectedModelList = selectByCondition(condition);
        if (null != selectedModelList && selectedModelList.size() > 1) {
            // 如果根据条件查询出的数据条数不止一条，报错
            throw new TestException("更新数量指定为1，但是根据条件查询数量大于一，请联系人员检查数据");
        }
        // 此处为强制更新，null也会更新
        return updateByCondition(model, condition);
    }
}
