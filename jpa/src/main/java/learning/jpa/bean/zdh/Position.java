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
@Table(name = "ORG_POSITION")
public class Position extends BaseBusEntity {

    private static final long serialVersionUID = -7020427994563623645L;
    /**
     * 职位编码
     */
    @Id
    @Column(name = "ID", precision = 22)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    /**
     * 职位名称
     */
    @Column(name = "NAME", nullable = false, length = 50)
    private String name;
    /**
     * 职位描述信息
     */
    @Column(name = "DESCRIPTION", length = 250)
    private String description;
    /**
     * 对应的职务
     */
    @Column(name = "JOB_ID")
    private Long job;

    /**
     * 所属部门
     */
    @Column(name = "DEPARTMENT_ID")
    private Long department;

    /**
     * 所属组织
     */
    @Column(name = "ORGANIZATION_ID", updatable = false, nullable = false)
    private String organization;

}
