package com.aniikiki.abms.controller.system;

import com.aniikiki.abms.common.CommonPage;
import com.aniikiki.abms.common.CommonResult;
import com.aniikiki.abms.controller.BaseController;
import com.aniikiki.abms.entity.system.DictEntity;
import com.aniikiki.abms.service.system.DictService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/dict")
@Api(tags = "数据字典")
@Slf4j
public class DictController extends BaseController {

    @Autowired
    private DictService dictService;

    @ApiOperation("数据字典列表")
    @PostMapping("/list")
    public CommonResult<CommonPage<DictEntity>> getDictList(@RequestBody DictEntity dict,
                                                            @RequestParam(value = "pageNum", defaultValue = "1") Integer pageNum,
                                                            @RequestParam(value = "pageSize", defaultValue = "10") Integer pageSize) {
        List<DictEntity> dictList = dictService.getDictList(dict, pageNum, pageSize);
        return CommonResult.success(CommonPage.restPage(dictList));
    }

    @ApiOperation("数据字典列表")
    @GetMapping("/list/{dictTypeNameEn}")
    public CommonResult<List<DictEntity>> getDictByType(@PathVariable(value = "dictTypeNameEn") String dictTypeNameEn) {
        List<DictEntity> dictList = dictService.getDictListByType(dictTypeNameEn);
        return CommonResult.success(dictList);
    }

}
