package learning.jpa.bean.zdh;

import lombok.*;

import javax.persistence.*;
import java.util.*;


/**
 * 此表用与数据解析 存储用 与人员权限没有丝毫关系
 */
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "ORG_EMPLOYEE")
public class Employee extends BaseBusEntity {
    @Id
    @Column(name = "ID", precision = 22)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * 头像
     */
    @Column(name = "avatar", precision = 500)
    private String avatar;

    /**
     * 工号
     */
    @Column(name = "SN", nullable = false, precision = 20)
    private String jobNumber;
    /**
     * 用户标签，用于筛选用户
     */
    @Column(name = "TAGS", precision = 255)
    private String tags;
    /**
     * 名称
     */
    @Column(name = "NAME", length = 30)
    private String name;
    /**
     * 生日
     */
    @Column(name = "BIRTHDAY")
    @Temporal(TemporalType.DATE)
    private Date birthday;
    /**
     * 性别
     */
    @Column(name = "SEX", length = 10)
    private String sex;
    /**
     * 移动电话
     */
    @Column(name = "MOBILE", length = 20)
    private String mobile;
    /**
     * 固定电话
     */
    @Column(name = "TEL", length = 20)
    private String tel;
    /**
     * E-mail
     */
    @Column(name = "EMAIL", length = 50)
    private String email;

    /**
     * englishName
     */
    @Column(name = "ENGLISHNAME", length = 50)
    private String englishName;

    /**
     * signatureImgName
     */
    @Column(name = "SIGNATUREIMGNAME", length = 50)
    private String signatureImgName;

    /**
     * status
     */
    @Column(name = "status", length = 255)
    private String status;

    /**
     * userOrderCode
     */
    @Column(name = "USERORDERCODE", length = 20)
    private String userOrderCode;

    /**
     * userSimpleName
     */
    @Column(name = "USERSIMPLENAME", length = 50)
    private String userSimpleName;

    /**
     * userSuperBegin
     */
    @Column(name = "USERSUPERBEGIN")
    private String userSuperBegin;

    /**
     * userSuperEnd
     */
    @Column(name = "USERSUPEREND")
    private String userSuperEnd;

    /**
     * position
     */
    @Column(name = "position",length = 20)
    private String position;

    /**
     * orgId
     */
    @Column(name = "orgid",length = 10)
    private String orgId;

    /**
     * org_id
     */
    @Column(name = "org_id",length = 255)
    private String org_id;




}
