package com.aniikiki.abms.service.system.impl;

import com.aniikiki.abms.constant.DataStatus;
import com.aniikiki.abms.dao.system.DictDao;
import com.aniikiki.abms.entity.system.DictEntity;
import com.aniikiki.abms.service.system.DictService;
import com.github.pagehelper.PageHelper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class DictServiceImpl implements DictService {

    @Autowired
    private DictDao dictDao;

    @Override
    public List<DictEntity> getDictList(DictEntity dict, Integer pageNum, Integer pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        return dictDao.selectByCriteria(dict);
    }

    @Override
    public List<DictEntity> getDictListByType(String dictTypeNameEn) {
        DictEntity dict = new DictEntity();
        dict.setDictTypeEn(dictTypeNameEn);
        dict.setStatus(DataStatus.ENABLE.getCode());
        return dictDao.selectByCriteria(dict);
    }


}
