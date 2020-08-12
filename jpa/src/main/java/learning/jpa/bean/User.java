package learning.jpa.bean;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.List;

/**
 * @Classname User
 * @Description 用户表
 * @Date 2020/8/12 2:38 下午
 * @Author z7-x
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "LEARN_USER")
public class User implements Serializable {
    @Id
    @Column(name = "USER_ID")
    @GeneratedValue(generator = "learn_user_index_gen")
    @TableGenerator(name = "learn_user_index_gen", table = "sys_sequence", pkColumnName = "gen_name", pkColumnValue = "learn_user_index:id", valueColumnName = "gen_value")
    private Long userId;

    @NotNull(message = "用户名不能为空")
    @Column(name = "USER_NAME", nullable = false, length = 10)
    private String userName;

    @NotNull(message = "密码不能为空")
    @Column(name = "PASS_WORD", nullable = false, length = 32)
    private String passWord;

    @ManyToMany(targetEntity = Role.class, fetch = FetchType.LAZY)
    @JoinTable(name = "LEARN_USER_ROLE", joinColumns = @JoinColumn(name = "USER_ID", referencedColumnName = "USER_ID"),
            inverseJoinColumns = @JoinColumn(name = "ROLE_ID", referencedColumnName = "ROLE_ID"))
    private List<Role> roles;
}
