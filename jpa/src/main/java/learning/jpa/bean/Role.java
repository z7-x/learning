package learning.jpa.bean;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.List;

/**
 * @Classname Role
 * @Description 角色表
 * @Date 2020/8/12 2:38 下午
 * @Author z7-x
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "LEARN_ROLE")
public class Role implements Serializable {
    @Id
    @Column(name = "ROLE_ID")
    @GeneratedValue(generator = "learn_role_index_gen")
    @TableGenerator(name = "learn_role_index_gen", table = "sys_sequence", pkColumnName = "gen_name", pkColumnValue = "learn_role_index:id", valueColumnName = "gen_value")
    private Long roleId;

    @NotNull(message = "角色名不能为空")
    @Column(name = "ROLE_NAME", nullable = false, length = 10)
    private String roleName;

    /**
     * 角色父级id
     */
    @ManyToOne(cascade = CascadeType.REFRESH)
    @JoinColumn(name = "PID", foreignKey = @ForeignKey(name = "FK_ROLE_PID"))
    private Role pid;

    /**
     * 角色子级id
     */
    @JsonInclude(content = JsonInclude.Include.NON_NULL)
    @OneToMany(mappedBy = "pid", fetch = FetchType.LAZY, cascade = CascadeType.REMOVE)
    @OrderBy("roleId ASC ")
    private List<Role> children;

    @ManyToMany(targetEntity = User.class, mappedBy = "roles", fetch = FetchType.LAZY)
    private List<User> users;

    @ManyToMany(targetEntity = Permission.class, fetch = FetchType.LAZY)
    @JoinTable(name = "LEARN_ROLE_PERMISSION", joinColumns = @JoinColumn(name = "ROLE_ID", referencedColumnName = "ROLE_ID"),
            inverseJoinColumns = @JoinColumn(name = "PERMISSION_ID", referencedColumnName = "PERMISSION_ID"))
    private List<Permission> permissions;

}
