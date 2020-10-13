package learning.jpa.dao;

import learning.jpa.bean.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

/**
 * @Classname UserDao
 * @Description TODO
 * @Date 2020/8/12 5:34 下午
 * @Author z7-x
 */
@Repository
public interface UserRepository extends JpaRepository<User, Long>, JpaSpecificationExecutor {

}
