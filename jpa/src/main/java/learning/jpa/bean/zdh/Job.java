package learning.jpa.bean.zdh;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
/**
 * 此表用与数据解析 存储用 与人员权限没有丝毫关系
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "ORG_JOB")
public class Job extends BaseBusEntity {

    private static final long serialVersionUID = -7020427994563623645L;

    @Id
    @Column(name = "ID", precision = 22)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * 职务名称
     */
    @Column(name = "NAME", nullable = false, length = 50)
    private String name;
    /**
     * 职务描述信息
     */
    @Column(name = "DESCRIPTION", length = 250)
    private String description;
    /**
     * 职务所属组织
     */
    @Column(name = "ORGANIZATION_ID", updatable = false, nullable = false)
    private String organization;

    /**
     * 职务所属组织
     */
    @Column(name = "DEPARTMENT_ID")
    private Long departmentId;

    /**
     * 职务级别
     */
    @Column(name = "level",length = 10)
    private Long level;

    /**
     * 类型
     */
    @Column(name = "TYPE",length = 255)
    private String type;

    /**
     * 类型
     */
    @Column(name = "ROLES",length = 255)
    private String roles;
}
