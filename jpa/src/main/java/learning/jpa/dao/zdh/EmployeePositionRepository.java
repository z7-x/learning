package learning.jpa.dao.zdh;

import learning.jpa.bean.zdh.EmployeePosition;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

/**
 * @Classname EmployeePositionRepository
 * @Description TODO
 * @Date 2020/11/5 2:34 下午
 * @Author z7-x
 */
@Repository
public interface EmployeePositionRepository extends JpaRepository<EmployeePosition, Long>, JpaSpecificationExecutor {
    EmployeePosition findEmployeePositionByDepartmentAndEmployee(Long department,Long employee);
}
