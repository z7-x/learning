package learning.jpa.dao.zdh;

import learning.jpa.bean.zdh.Position;
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
public interface PositionRepository extends JpaRepository<Position, Long>, JpaSpecificationExecutor {

    /**
     *
     * @param departmentId
     * @param typeName
     * @return
     */
    Position findPositionByDepartmentAndName(Long departmentId,String typeName);
}
