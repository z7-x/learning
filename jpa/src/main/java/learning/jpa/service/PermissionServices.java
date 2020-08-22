package learning.jpa.service;

import learning.jpa.bean.Permission;
import learning.jpa.dao.PermissionRepository;
import learning.jpa.service.impl.BasisServiceImpl;
import learning.jpa.specification.PermissionSpecification;
import org.apache.commons.collections.ListUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import javax.transaction.Transactional;
import java.util.*;
import java.util.function.Function;
import java.util.function.Predicate;

/**
 * @Classname PermissionServices
 * @Description TODO
 * @Date 2020/8/12 5:46 下午
 * @Author z7-x
 */
@Service
@Transactional
public class PermissionServices implements BasisServiceImpl<Permission> {

    @Autowired
    private PermissionRepository permissionRepository;
    @Autowired
    private PermissionSpecification permissionSpecification;

    @Override
    public List<Permission> add(List<Permission> params) {
        if (CollectionUtils.isEmpty(params)) {
            return ListUtils.EMPTY_LIST;
        }
        return permissionRepository.saveAll(params);
    }

    @Override
    public boolean remove(Number... id) {
        Function<Long[], Permission> function =
                (param) -> {
                    Arrays.stream(param).forEach(item -> {
                        Permission permission = permissionRepository.findById(item).orElse(null);
                        if (null != permission) {
                            permissionRepository.delete(permission);
                        }
                    });
                    return null;
                };
        function.apply((Long[]) id);
        return true;
    }

    @Override
    public Permission modify(Permission param) {
        Permission permission = null;
        Predicate<Permission> predicate = (par ->
        {
            if (null == par.getPermissionId()) {
                return false;
            }
            return true;
        });
        if (predicate.test(param)) {
            permission = permissionRepository.save(param);
        }
        return permission;
    }

    @Override
    public Permission findById(Number id) {
        Permission permission = null;
        if (null == id) {
            return null;
        }
        permission = permissionRepository.findById((Long) id).orElse(null);
        return permission;
    }

    @Override
    public Page findAll(Permission filter, Integer page, Integer size) {
        Sort sort = Sort.by(Sort.Direction.DESC, "permissionId");
        PageRequest pageRequest = PageRequest.of(page, size, sort);
        //组装 过滤条件
        Specification specification = permissionSpecification.condition(filter);
        return permissionRepository.findAll(specification, pageRequest);
    }
}
