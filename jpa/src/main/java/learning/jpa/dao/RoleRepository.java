package learning.jpa.dao;

import learning.jpa.bean.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @Classname RoleDao
 * @Description TODO
 * @Date 2020/8/12 5:34 下午
 * @Author z7-x
 */
@Repository
public interface RoleRepository extends JpaRepository<Role,Long> {
}
