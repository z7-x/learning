package learning.jpa.bean;

import learning.jpa.bean.basis.BaseBusEntity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.List;

/**
 * @Classname Permission
 * @Description 权限表
 * @Date 2020/8/12 2:37 下午
 * @Author z7-x
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "LEARN_PERMISSION")
public class Permission extends BaseBusEntity {
    @Id
    @Column(name = "PERMISSION_ID")
    @GeneratedValue(generator = "learn_permission_index_gen")
    @TableGenerator(name = "learn_permission_index_gen", table = "sys_sequence", pkColumnName = "gen_name", pkColumnValue = "learn_permission_index:id", valueColumnName = "gen_value")
    private Long permissionId;

    @NotNull(message = "权限名不能为空")
    @Column(name = "PERMISSION_NAME", nullable = false, length = 10)
    private String permissionName;

//    /**
//     * 权限父级id
//     */
//    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.REFRESH)
//    @JoinColumn(name = "PID", foreignKey = @ForeignKey(name = "FK_PERMISSION_PID"))
//    private Permission pid;
//
//    /**
//     * 权限子级id
//     */
//    @JsonInclude(content = JsonInclude.Include.NON_NULL)
//    @OneToMany(mappedBy = "pid", fetch = FetchType.LAZY, cascade = CascadeType.REMOVE)
//    @OrderBy("permissionId ASC ")
//    private List<Permission> children;

    @ManyToMany(targetEntity = Role.class, mappedBy = "permissions", fetch = FetchType.LAZY)
    private List<Role> roles;
}
