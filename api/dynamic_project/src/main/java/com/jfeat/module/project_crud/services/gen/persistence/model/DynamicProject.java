package com.jfeat.module.project_crud.services.gen.persistence.model;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import java.util.Date;
import com.baomidou.mybatisplus.annotation.TableId;
import java.io.Serializable;

/**
 * <p>
 * 
 * </p>
 *
 * @author Code generator
 * @since 2021-08-25
 */
@TableName("tl_dynamic_project")
public class DynamicProject extends Model<DynamicProject> {

    private static final long serialVersionUID=1L;

      /**
     * 主键id
     */
        @TableId(value = "id", type = IdType.AUTO)
      private Long id;

      /**
     * 组织id,用于数据隔离
     */
      private Long ordId;

      /**
     * 组织编号
     */
      private String orgCode;

      /**
     * 组织别名
     */
      private String orgTag;

      /**
     * 租户ID
     */
      private Long tenantId;

      /**
     * 名称
     */
      private String name;

      /**
     * 标题
     */
      private String title;

      /**
     * 编号
     */
      private String code;

      /**
     * 创建时间
     */
      private Date createdAt;

      /**
     * 更新时间
     */
      private Date updataAt;

      /**
     * 用户ID
     */
      private Long userId;

      /**
     * 一对多关联ID
     */
      private Long masterId;

      /**
     * 用于不同业务的数据隔离
     */
      private String scope;

    
    public Long getId() {
        return id;
    }

      public DynamicProject setId(Long id) {
          this.id = id;
          return this;
      }
    
    public Long getOrdId() {
        return ordId;
    }

      public DynamicProject setOrdId(Long ordId) {
          this.ordId = ordId;
          return this;
      }
    
    public String getOrgCode() {
        return orgCode;
    }

      public DynamicProject setOrgCode(String orgCode) {
          this.orgCode = orgCode;
          return this;
      }
    
    public String getOrgTag() {
        return orgTag;
    }

      public DynamicProject setOrgTag(String orgTag) {
          this.orgTag = orgTag;
          return this;
      }
    
    public Long getTenantId() {
        return tenantId;
    }

      public DynamicProject setTenantId(Long tenantId) {
          this.tenantId = tenantId;
          return this;
      }
    
    public String getName() {
        return name;
    }

      public DynamicProject setName(String name) {
          this.name = name;
          return this;
      }
    
    public String getTitle() {
        return title;
    }

      public DynamicProject setTitle(String title) {
          this.title = title;
          return this;
      }
    
    public String getCode() {
        return code;
    }

      public DynamicProject setCode(String code) {
          this.code = code;
          return this;
      }
    
    public Date getCreatedAt() {
        return createdAt;
    }

      public DynamicProject setCreatedAt(Date createdAt) {
          this.createdAt = createdAt;
          return this;
      }
    
    public Date getUpdataAt() {
        return updataAt;
    }

      public DynamicProject setUpdataAt(Date updataAt) {
          this.updataAt = updataAt;
          return this;
      }
    
    public Long getUserId() {
        return userId;
    }

      public DynamicProject setUserId(Long userId) {
          this.userId = userId;
          return this;
      }
    
    public Long getMasterId() {
        return masterId;
    }

      public DynamicProject setMasterId(Long masterId) {
          this.masterId = masterId;
          return this;
      }
    
    public String getScope() {
        return scope;
    }

      public DynamicProject setScope(String scope) {
          this.scope = scope;
          return this;
      }

      public static final String ID = "id";

      public static final String ORD_ID = "ord_id";

      public static final String ORG_CODE = "org_code";

      public static final String ORG_TAG = "org_tag";

      public static final String TENANT_ID = "tenant_id";

      public static final String NAME = "name";

      public static final String TITLE = "title";

      public static final String CODE = "code";

      public static final String CREATED_AT = "created_at";

      public static final String UPDATA_AT = "updata_at";

      public static final String USER_ID = "user_id";

      public static final String MASTER_ID = "master_id";

      public static final String SCOPE = "scope";

      @Override
    protected Serializable pkVal() {
          return this.id;
      }

    @Override
    public String toString() {
        return "DynamicProject{" +
              "id=" + id +
                  ", ordId=" + ordId +
                  ", orgCode=" + orgCode +
                  ", orgTag=" + orgTag +
                  ", tenantId=" + tenantId +
                  ", name=" + name +
                  ", title=" + title +
                  ", code=" + code +
                  ", createdAt=" + createdAt +
                  ", updataAt=" + updataAt +
                  ", userId=" + userId +
                  ", masterId=" + masterId +
                  ", scope=" + scope +
              "}";
    }
}
