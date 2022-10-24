package com.jfeat.module.project_crud.services.domain.dao;

import com.jfeat.module.project_crud.services.domain.model.DynamicProjectRecord;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.jfeat.crud.plus.QueryMasterDao;
import org.apache.ibatis.annotations.Param;
import com.jfeat.module.project_crud.services.gen.persistence.model.DynamicProject;
import com.jfeat.module.project_crud.services.gen.crud.model.DynamicProjectModel;

import java.util.Date;
import java.util.List;

/**
 * Created by Code generator on 2021-08-25
 */
public interface QueryDynamicProjectDao extends QueryMasterDao<DynamicProject> {
   /*
    * Query entity list by page
    */
    List<DynamicProjectRecord> findDynamicProjectPage(Page<DynamicProjectRecord> page, @Param("record") DynamicProjectRecord record,
                                            @Param("search") String search, @Param("orderBy") String orderBy,
                                            @Param("startTime") Date startTime, @Param("endTime") Date endTime);

    /*
     * Query entity model for details
     */
    DynamicProjectModel queryMasterModel(@Param("id") Long id);
}