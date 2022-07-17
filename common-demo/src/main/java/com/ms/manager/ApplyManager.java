package com.ms.manager;

import com.ms.dao.ApplyDao;
import com.ms.domain.ApplyDO;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import tk.mybatis.mapper.entity.Example;

import java.util.Date;
import java.util.List;

@Component
public class ApplyManager extends BaseManager<ApplyDO> {

    @Autowired
    private ApplyDao applyDao;

    public int save(ApplyDO applyDO) {
        applyDO.setApplyDate(new Date());
        return super.save(applyDO);
    }

    public List<ApplyDO> selectAll() {
        return applyDao.selectAll();
    }

    public ApplyDO getByApplyCode(String applyCode) {
        if (StringUtils.isBlank(applyCode)) {
            return null;
        }
        Example example = new Example(ApplyDO.class);
        example.and().andEqualTo("applyCode", applyCode);
        return applyDao.selectOneByExample(example);
    }
}
