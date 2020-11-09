package learning.jpa.bean.zdh;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import javax.persistence.*;
import java.util.*;

/**
 * 此表用与数据解析 存储用 与人员权限没有丝毫关系
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "AUTH_USER")
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
public class UserDistrict extends BaseBusEntity {

    private static final long serialVersionUID = 5507435998232223911L;

    @Id
    @Column(name = "ID", nullable = false, updatable = false, precision = 22)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * 用户登录名称
     */
    @Column(name = "USERNAME", length = 20, updatable = false, nullable = false, unique = true)
    private String username;

//    /**
//     * 登录密码
//     */
//    @Column(name = "PASSWORD", length = 50, nullable = false)
//    private String password;
//
//    /**
//     * 用户类型
//     */
//    @Column(name = "USER_TYPE", length = 20, nullable = false)
//    private String userType;
//
//    /**
//     * 用户显示昵称
//     */
//    @Column(name = "NICK_NAME", length = 50)
//    private String nickName;
//
//    /**
//     * 是否启用
//     */
//    @Column(name = "ENABLED")
//    private Boolean enabled;
//
//    /**
//     * 未过期
//     */
//    @Column(name = "NON_EXPIRED")
//    private Boolean accountNonExpired;
//
//    /**
//     * 未锁定
//     */
//    @Column(name = "NON_LOCKED")
//    private Boolean accountNonLocked;
//
//    /**
//     * 未失效
//     */
//    @Column(name = "CREDENTIALS_NON_EXPIRED")
//    private Boolean credentialsNonExpired;
//
//    /**
//     * 锁定时间
//     */
//    @Column(name = "LOCK_TIME")
//    private Date lockTime;
//
//    /**
//     * 最后登录时间
//     */
//    @Column(name = "LAST_LOGIN_TIME")
//    private Date lastLoginTime;

//
//    /**
//     * 扩展字段
//     */
//    @Column(name = "PROPERTIES")
//    private String properties;


    /**
     * 人员
     */
    @Column(name = "EMPLOYEE_ID")
    private Long employee;

//    /**
//     * 所属组织
//     */
//    @Column(name = "ORGANIZATION_ID")
//    private String organization;
//
//    /**
//     * 部门
//     */
//    @Column(name = "DEPARTMENT_ID")
//    private Long department;

}