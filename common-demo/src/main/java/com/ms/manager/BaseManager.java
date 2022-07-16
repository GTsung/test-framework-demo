package com.ms.manager;

import com.ms.constant.UserConstant;
import com.ms.domain.BaseDO;
import com.ms.enums.DelFlagEnum;
import com.ms.util.BaseDao;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.CollectionUtils;

import java.util.Date;
import java.util.List;

@Slf4j
public class BaseManager<T extends BaseDO> {

    @Autowired
    private BaseDao<T> dao;

    public int save(T model) {
        String operator = getOperator(model.getCreateUser());
        return this.save(model, operator);
    }

    private String getOperator(String createUser) {
        return StringUtils.isBlank(createUser)
                ? UserConstant.username : createUser;
    }

    public int save(T model, String operator) {
        if (null == model) {
            return 0;
        }
        model.setDelFlag(DelFlagEnum.PERSISTENT.getCode());
        model.setCreateTime(new Date());
        model.setCreateUser(operator);
        model.setUpdateTime(new Date());
        model.setUpdateUser(operator);
        return dao.insertSelective(model);
    }

    public int save(List<T> models) {
        if (CollectionUtils.isEmpty(models)) {
            return 0;
        }
        for (T model : models) {
            model.setDelFlag(DelFlagEnum.PERSISTENT.getCode());
            model.setCreateTime(new Date());
            model.setCreateUser(UserConstant.username);
            model.setUpdateUser(UserConstant.username);
            model.setUpdateTime(new Date());
        }
        return dao.insertList(models);
    }

}
