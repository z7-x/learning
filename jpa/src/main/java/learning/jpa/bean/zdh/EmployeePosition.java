package learning.jpa.bean.zdh;

import lombok.*;

import javax.persistence.*;

/**
 * 此表用与数据解析 存储用 与人员权限没有丝毫关系
 */
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "ORG_EMPLOYEE_POSITION")
public class EmployeePosition extends BaseBusEntity {

    @Id
    @Column(name = "ID", precision = 22)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    /**
     * 是否为主部门
     */
    @Column(name = "IS_PRIMARY")
    private Boolean primary;

    /**
     * 员工
     */
    @Column(name = "EMPLOYEE_ID", nullable = false, updatable = false)
    private Long employee;

    /**
     * 职位
     */
    @Column(name = "POSITION_ID")
    private Long position;

    /**
     * 所在部门
     */
    @Column(name = "DEPARTMENT_ID", nullable = false)
    private Long department;

    /**
     * 所属组织
     */
    @JoinColumn(name = "ORGANIZATION_ID", updatable = false, nullable = false)
    private String organization;

    /**
     * ORGANIZATIONEMPLOYEE_ID 的VALUE 对于应 ORG_ORGANIZATION_EMPLOYEE表的ID
     */
    @Column(name = "ORGANIZATIONEMPLOYEE_ID", updatable = false, nullable = false)
    private Long organizationEmployeeId;
}
