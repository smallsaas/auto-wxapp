package com.jfeat.module.project_crud.services.gen.crud.service.impl;
// ServiceImpl start

            
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.jfeat.crud.plus.FIELD;
import com.jfeat.module.project_crud.services.gen.persistence.model.DynamicProject;
import com.jfeat.module.project_crud.services.gen.persistence.dao.DynamicProjectMapper;
import com.jfeat.module.project_crud.services.gen.crud.service.CRUDDynamicProjectService;
import org.springframework.stereotype.Service;
import com.jfeat.crud.base.exception.BusinessCode;
import com.jfeat.crud.base.exception.BusinessException;
import javax.annotation.Resource;
import com.jfeat.crud.plus.impl.CRUDServiceOnlyImpl;

/**
 * <p>
 *  implementation
 * </p>
 *CRUDDynamicProjectService
 * @author Code generator
 * @since 2021-08-25
 */

@Service
public class CRUDDynamicProjectServiceImpl  extends CRUDServiceOnlyImpl<DynamicProject> implements CRUDDynamicProjectService {





        @Resource
        protected DynamicProjectMapper dynamicProjectMapper;

        @Override
        protected BaseMapper<DynamicProject> getMasterMapper() {
                return dynamicProjectMapper;
        }







}


