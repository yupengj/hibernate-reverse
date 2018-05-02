package com.gantang.prd.bommgmt.controllers

import com.gantang.framework.web.GApi
import com.gantang.framework.web.GOperation
import com.gantang.framework.web.BaseController
import com.gantang.framework.web.dto.IdRequest
import com.gantang.framework.bo.DataContainer
import com.gantang.framework.bo.PageResult;
import com.gantang.framework.web.dto.ChangeDataDto
import com.gantang.framework.web.dto.QueryRequest
import com.gantang.framework.util.bean.ClassConverter

import com.gantang.prd.bommgmt.model.PartAssembly;
import com.gantang.prd.bommgmt.service.PartAssemblyService;

@GApi(description = "partAssembly服务")
class PartAssemblyController extends BaseController {

	PartAssemblyService partAssemblyService;

 	@GOperation(notes = "根据id查询")
    def findById(IdRequest idRequest) {
        webReturn partAssemblyService.doFindById(idRequest.id);
    }
    
    @GOperation(notes = "分页查询")
    def find(QueryRequest queryRequest) {
        webReturn partAssemblyService.doFindByCriteria(queryRequest.toQueryCriteria());
    }

    @GOperation(notes = "批量保存")
    def batchSave(ChangeDataDto changeDataDto) {
        DataContainer<PartAssembly> dataContainer = ClassConverter.convertToDataContainer(changeDataDto.getAddedData(),
                changeDataDto.getModifiedData(), changeDataDto.getRemovedData(), PartAssembly.class);
        partAssemblyService.doSave(dataContainer);
        webReturn dataContainer;
    }
}
