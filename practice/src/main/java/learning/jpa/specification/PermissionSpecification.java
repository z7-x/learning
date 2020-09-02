package learning.jpa.specification;

import learning.jpa.bean.Permission;
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
 * @Classname PermissionSpecification
 * @Description TODO 匿名内部类的方式，处理分页
 * @Date 2020/8/21 9:55 上午
 * @Author z7-x
 */
@Component
public class PermissionSpecification {

    public Specification<Permission> condition(Permission filter) {
        Specification<Permission> specification = new Specification<Permission>() {
            @Override
            public Predicate toPredicate(Root<Permission> root, CriteriaQuery<?> criteriaQuery, CriteriaBuilder criteriaBuilder) {
                List<Predicate> predicates = new ArrayList<>();
                predicates.add(criteriaBuilder.like(root.get("permissionName").as(String.class), "%" + filter.getPermissionName() + "%"));

                Predicate[] pres = new Predicate[predicates.size()];
                Predicate predicate = criteriaBuilder.and(predicates.toArray(pres));
                return predicate;
            }
        };
        return specification;
    }
}
