package learning.jpa.specification;

import learning.jpa.bean.User;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Component;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.List;

/**
 * @Classname UserSpecification
 * @Description TODO 匿名内部类的方式，处理分页
 * @Date 2020/8/19 11:20 上午
 * @Author z7-x
 */
@Component
public class UserSpecification {

    public Specification<User> where(User user) {
        return new Specification<User>() {
            @Override
            public Predicate toPredicate(Root<User> root, CriteriaQuery<?> criteriaQuery, CriteriaBuilder criteriaBuilder) {
                List<Predicate> predicates = new ArrayList<>();
                //用户地址模糊查询
                if (null != user) {
                    predicates.add(criteriaBuilder.like(root.get("userName"), "%" + user.getUserName() + "%"));
                }
                return criteriaQuery.where(predicates.toArray(new Predicate[predicates.size()])).getRestriction();
            }
        };
    }
}
