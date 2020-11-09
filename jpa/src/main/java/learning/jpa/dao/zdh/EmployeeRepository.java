package learning.jpa.dao.zdh;

import learning.jpa.bean.zdh.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

/**
 * @Classname EmployeeRepository
 * @Description TODO
 * @Date 2020/11/5 2:34 下午
 * @Author z7-x
 */
@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long>, JpaSpecificationExecutor {
}
