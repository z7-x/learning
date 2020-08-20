package learning.jpa.service;

import learning.jpa.bean.Permission;
import learning.jpa.dao.PermissionRepository;
import learning.jpa.service.impl.BasisServiceImpl;
import org.apache.commons.collections.ListUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import javax.transaction.Transactional;
import java.util.*;

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

    @Override
    public List<Permission> add(List<Permission> permissions) {
        if (CollectionUtils.isEmpty(permissions)) {
            return ListUtils.EMPTY_LIST;
        }
        return permissionRepository.saveAll(permissions);
    }

    @Override
    public boolean remove(Long id) {
        Permission permission = permissionRepository.findById(id).orElse(null);
        if (null == permission) {
            return false;
        }
        permissionRepository.delete(permission);
        return true;
    }

    @Override
    public Permission modify(Permission param) {
        return null;
    }

    @Override
    public Permission findById(Long id) {
        return null;
    }

    @Override
    public List<Permission> findAll(Permission param) {
        return null;
    }
}
