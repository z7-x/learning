package learning.jpa.dao.zdh;

import learning.jpa.bean.zdh.UserDistrict;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

/**
 * @Classname JobRepository
 * @Description TODO
 * @Date 2020/11/5 2:36 下午
 * @Author z7-x
 */
@Repository
public interface UserDistrictRepository extends JpaRepository<UserDistrict, Long>, JpaSpecificationExecutor {
    UserDistrict findByUsername(String userName);
}
