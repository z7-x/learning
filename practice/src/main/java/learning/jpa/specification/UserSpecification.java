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

    public Specification<User> condition(User filter) {
        Specification<User> specification = new Specification<User>() {
            @Override
            public Predicate toPredicate(Root<User> root, CriteriaQuery<?> criteriaQuery, CriteriaBuilder criteriaBuilder) {
                List<Predicate> predicates = new ArrayList<>();
                predicates.add(criteriaBuilder.like(root.get("userName").as(String.class), "%" + filter.getUserName() + "%"));

                Predicate[] pres = new Predicate[predicates.size()];
                Predicate predicate = criteriaBuilder.and(predicates.toArray(pres));
                return predicate;
            }
        };
        return specification;
    }
}
