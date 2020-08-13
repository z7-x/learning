package learning.jpa.service;

import learning.jpa.bean.Permission;
import learning.jpa.bean.Role;
import learning.jpa.dao.PermissionDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

/**
 * @Classname PermissionServices
 * @Description TODO
 * @Date 2020/8/12 5:46 下午
 * @Author z7-x
 */
@Service
@Transactional
public class PermissionServices {

    @Autowired
    private PermissionDao permissionDao;

    /**
     * @Description: 方法 createPermission 的功能描述：新增 权限
     * @param permission
     * @Return learning.jpa.bean.Permission
     * @Author z7-x
     * @Date 2020/8/13 4:05 下午
     */
    public Permission createPermission(Permission permission) {
        if (null == permission) {
            return null;
        }
        return permissionDao.save(permission);
    }
}
