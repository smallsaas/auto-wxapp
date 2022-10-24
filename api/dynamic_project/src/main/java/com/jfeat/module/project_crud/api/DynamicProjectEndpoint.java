package com.jfeat.module.project_crud.api;
    
                                            
                    import com.jfeat.crud.plus.META;
import com.jfeat.am.core.jwt.JWTKit;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.dao.DuplicateKeyException;
import com.jfeat.module.project_crud.services.domain.dao.QueryDynamicProjectDao;
import com.jfeat.crud.base.tips.SuccessTip;
import com.jfeat.crud.base.request.Ids;
import com.jfeat.crud.base.tips.Tip;
import com.jfeat.am.module.log.annotation.BusinessLog;
import com.jfeat.crud.base.exception.BusinessCode;
import com.jfeat.crud.base.exception.BusinessException;
import com.jfeat.crud.plus.CRUDObject;
import com.jfeat.module.project_crud.api.permission.*;
import com.jfeat.am.common.annotation.Permission;
import java.math.BigDecimal;

import com.jfeat.module.project_crud.services.domain.service.*;
import com.jfeat.module.project_crud.services.domain.model.DynamicProjectRecord;
import com.jfeat.module.project_crud.services.gen.persistence.model.DynamicProject;

        import org.springframework.web.bind.annotation.RestController;
        
import javax.annotation.Resource;
import java.util.Date;
import java.util.List;
import com.alibaba.fastjson.JSONArray;
/**
 * <p>
 *  api
 * </p>
 *
 * @author Code generator
 * @since 2021-08-25
 */
@RestController

@Api("DynamicProject")
@RequestMapping("/api/crud/dynamicProject/dynamicProjects")
public class DynamicProjectEndpoint {

@Resource
            DynamicProjectService dynamicProjectService;



@Resource
    QueryDynamicProjectDao queryDynamicProjectDao;

@BusinessLog(name = "DynamicProject", value = "create DynamicProject")
@Permission(DynamicProjectPermission.DYNAMICPROJECT_NEW)
@PostMapping
@ApiOperation(value = "新建 DynamicProject",response = DynamicProject.class)
public Tip createDynamicProject(@RequestBody DynamicProject entity){

        Integer affected=0;
        try{
                affected= dynamicProjectService.createMaster(entity);
    
        }catch(DuplicateKeyException e){
        throw new BusinessException(BusinessCode.DuplicateKey);
        }

        return SuccessTip.create(affected);
        }

@Permission(DynamicProjectPermission.DYNAMICPROJECT_VIEW)
@GetMapping("/{id}")
@ApiOperation(value = "查看 DynamicProject",response = DynamicProject.class)
public Tip getDynamicProject(@PathVariable Long id){
                            return SuccessTip.create(dynamicProjectService.queryMasterModel(queryDynamicProjectDao, id));
            }

@BusinessLog(name = "DynamicProject", value = "update DynamicProject")
@Permission(DynamicProjectPermission.DYNAMICPROJECT_EDIT)
@PutMapping("/{id}")
@ApiOperation(value = "修改 DynamicProject",response = DynamicProject.class)
public Tip updateDynamicProject(@PathVariable Long id,@RequestBody DynamicProject entity){
        entity.setId(id);
                return SuccessTip.create(dynamicProjectService.updateMaster(entity));
            }

@BusinessLog(name = "DynamicProject", value = "delete DynamicProject")
@Permission(DynamicProjectPermission.DYNAMICPROJECT_DELETE)
@DeleteMapping("/{id}")
@ApiOperation("删除 DynamicProject")
public Tip deleteDynamicProject(@PathVariable Long id){
                return SuccessTip.create(dynamicProjectService.deleteMaster(id));
            }

@Permission(DynamicProjectPermission.DYNAMICPROJECT_VIEW)
@ApiOperation(value = "DynamicProject 列表信息",response = DynamicProjectRecord.class)
@GetMapping
@ApiImplicitParams({
        @ApiImplicitParam(name= "pageNum", dataType = "Integer"),
        @ApiImplicitParam(name= "pageSize", dataType = "Integer"),
        @ApiImplicitParam(name= "search", dataType = "String"),
                                                                                        @ApiImplicitParam(name = "id", dataType = "Long"),
                                                                                                    @ApiImplicitParam(name = "ordId", dataType = "Long"),
                                                                                            @ApiImplicitParam(name = "orgCode", dataType = "String"),
                                                                                            @ApiImplicitParam(name = "orgTag", dataType = "String"),
                                                                                                    @ApiImplicitParam(name = "tenantId", dataType = "Long"),
                                                                                    @ApiImplicitParam(name = "name", dataType = "String"),
                                                                                    @ApiImplicitParam(name = "title", dataType = "String"),
                                                                                    @ApiImplicitParam(name = "code", dataType = "String"),
                                                                                                    @ApiImplicitParam(name = "createdAt", dataType = "Date"),
                                                                                                    @ApiImplicitParam(name = "updataAt", dataType = "Date"),
                                                                                                    @ApiImplicitParam(name = "userId", dataType = "Long"),
                                                                                                    @ApiImplicitParam(name = "masterId", dataType = "Long"),
                                                                                    @ApiImplicitParam(name = "scope", dataType = "String") ,
                @ApiImplicitParam(name = "orderBy", dataType = "String"),
                @ApiImplicitParam(name = "sort", dataType = "String")
            })
public Tip queryDynamicProjects(Page<DynamicProjectRecord> page,
@RequestParam(name = "pageNum", required = false, defaultValue = "1") Integer pageNum,
@RequestParam(name = "pageSize", required = false, defaultValue = "10") Integer pageSize,
  @RequestParam(name = "search", required = false) String search,
                                                                                                                            @RequestParam(name = "id", required = false) Long id,
        
                                                                                                                                @RequestParam(name = "ordId", required = false) Long ordId,
        
                                                                                                                        @RequestParam(name = "orgCode", required = false) String orgCode,
        
                                                                                                                        @RequestParam(name = "orgTag", required = false) String orgTag,
        
                                                                                                                                @RequestParam(name = "tenantId", required = false) Long tenantId,
        
                                                                                                                @RequestParam(name = "name", required = false) String name,
        
                                                                                                                @RequestParam(name = "title", required = false) String title,
        
                                                                                                                @RequestParam(name = "code", required = false) String code,
        
                                                                                                                    @DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
                                    @RequestParam(name = "createdAt", required = false) Date createdAt,
        
                                                                                                                    @DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
                                    @RequestParam(name = "updataAt", required = false) Date updataAt,
        
                                                                                                                                @RequestParam(name = "userId", required = false) Long userId,
        
                                                                                                                                @RequestParam(name = "masterId", required = false) Long masterId,
        
                                                                                                                @RequestParam(name = "scope", required = false) String scope,
        @RequestParam(name = "orderBy", required = false) String orderBy,
        @RequestParam(name = "sort", required = false)  String sort) {
        
            if(orderBy!=null&&orderBy.length()>0){
        if(sort!=null&&sort.length()>0){
        String pattern = "(ASC|DESC|asc|desc)";
        if(!sort.matches(pattern)){
        throw new BusinessException(BusinessCode.BadRequest.getCode(), "sort must be ASC or DESC");//此处异常类型根据实际情况而定
        }
        }else{
        sort = "ASC";
        }
        orderBy = "`"+orderBy+"`" +" "+sort;
        }
        page.setCurrent(pageNum);
        page.setSize(pageSize);

    DynamicProjectRecord record = new DynamicProjectRecord();
                                                                                    record.setId(id);
                                                                                                record.setOrdId(ordId);
                                                                                                record.setOrgCode(orgCode);
                                                                                                record.setOrgTag(orgTag);
                                                                                                record.setTenantId(tenantId);
                                                                                        record.setName(name);
                                                                                        record.setTitle(title);
                                                                                        record.setCode(code);
                                                                                                record.setCreatedAt(createdAt);
                                                                                                record.setUpdataAt(updataAt);
                                                                                                record.setUserId(userId);
                                                                                                record.setMasterId(masterId);
                                                                                        record.setScope(scope);
            
    
        List<DynamicProjectRecord> dynamicProjectPage = queryDynamicProjectDao.findDynamicProjectPage(page, record, search, orderBy, null, null);

            page.setRecords(dynamicProjectPage);

        return SuccessTip.create(page);
        }
        }
