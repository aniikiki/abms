package com.aniikiki.abms.service.system;

import com.aniikiki.abms.entity.system.DictEntity;

import java.util.List;

public interface DictService {

    List<DictEntity> getDictList(DictEntity dict, Integer pageNum, Integer pageSize);

    List<DictEntity> getDictListByType(String dictTypeNameEn);

}
