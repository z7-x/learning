package learning.jpa.service;

import learning.jpa.bean.Role;
import learning.jpa.dao.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

/**
 * @Classname RoleService
 * @Description TODO
 * @Date 2020/8/12 5:46 下午
 * @Author z7-x
 */
@Service
@Transactional
public class RoleService {

    @Autowired
    private RoleRepository roleRepository;

    /**
     * @Description: 方法 createRole 的功能描述：新增角色
     * @param role
     * @Return learning.jpa.bean.Role
     * @Author z7-x
     * @Date 2020/8/13 2:32 下午
     */
    public Role createRole(Role role) {
        if (null == role) {
            return null;
        }
        return roleRepository.save(role);
    }

}
