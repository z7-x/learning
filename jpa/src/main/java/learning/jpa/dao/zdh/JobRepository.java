package learning.jpa.dao.zdh;

import learning.jpa.bean.zdh.Job;
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
public interface JobRepository extends JpaRepository<Job, Long>, JpaSpecificationExecutor {
}
