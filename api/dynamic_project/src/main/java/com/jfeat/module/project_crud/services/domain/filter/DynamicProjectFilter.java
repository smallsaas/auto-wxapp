package com.jfeat.module.project_crud.services.domain.filter;

import com.jfeat.crud.plus.CRUDFilter;
import com.jfeat.module.project_crud.services.gen.persistence.model.DynamicProject;


/**
 * Created by Code generator on 2021-08-25
 */
public class DynamicProjectFilter implements CRUDFilter<DynamicProject> {

    private String[] ignoreFields = new String[]{};
    private String[] updateIgnoreFields = new String[]{};

    @Override
    public void filter(DynamicProject entity, boolean insertOrUpdate) {

        //if insertOrUpdate is true,means for insert, do this
        if (insertOrUpdate){

            //then insertOrUpdate is false,means for update,do this
        }else {

        }

    }

    @Override
    public String[] ignore(boolean retrieveOrUpdate) {
        //if retrieveOrUpdate is true,means for retrieve ,do this
        if (retrieveOrUpdate){
            return ignoreFields;
            //then retrieveOrUpdate  if false ,means for update,do this
        }else {
            return updateIgnoreFields;
        }
    }
}
