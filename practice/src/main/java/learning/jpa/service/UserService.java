package learning.jpa.service;

import learning.jpa.bean.User;
import learning.jpa.dao.UserRepository;
import learning.jpa.specification.UserSpecification;
import learning.jpa.utils.MD5Util;
import org.apache.commons.collections.ListUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import javax.transaction.Transactional;
import java.util.List;

/**
 * @Classname UserService
 * @Description TODO
 * @Date 2020/8/12 5:37 下午
 * @Author z7-x
 */
@Service
@Transactional
public class UserService {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private UserSpecification userSpecification;

    /**
     * @param
     * @Description: 方法 findAll 的功能描述：查询 所有用户
     * @Return java.util.List<learning.jpa.bean.User>
     * @Author z7-x
     * @Date 2020/8/12 6:22 下午
     */
    public List<User> findUsers() {
        List<User> users = userRepository.findAll();
        if (CollectionUtils.isEmpty(users)) {
            return ListUtils.EMPTY_LIST;
        }
        return users;
    }

    /**
     * @param user
     * @Description: 方法 createUser 的功能描述：新增 用户
     * @Return learning.jpa.bean.User
     * @Author z7-x
     * @Date 2020/8/12 6:28 下午
     */
    public User createUser(User user) {
        if (null == user) {
            return null;
        }
        user.setPassWord(MD5Util.backMD5(user.getPassWord()));
        return userRepository.save(user);
    }

    /**
     * @param user
     * @Description: 方法 updateUser 的功能描述：修改 用户信息
     * @Return learning.jpa.bean.User
     * @Author z7-x
     * @Date 2020/8/12 7:04 下午
     */
    public User updateUser(User user) {
        if (null == user.getUserId()) {
            return null;
        }
        user.setPassWord(MD5Util.backMD5(user.getPassWord()));
        return userRepository.save(user);
    }

    /**
     * @param userId
     * @Description: 方法 deleteUser 的功能描述：删除 用户信息
     * @Return java.lang.Boolean
     * @Author z7-x
     * @Date 2020/8/12 7:16 下午
     */
    public Boolean deleteUser(Long userId) {
        if (null == userId) {
            return null;
        }
        User all = userRepository.findById(userId).orElse(null);
        if (null == all) {
            return false;
        }
        userRepository.delete(all);
        return true;
    }

    /**
     * @param user
     * @Description: 方法 findUsers 的功能描述：TODD 根据 user参数列表 分页 模糊查询
     * @Return org.springframework.data.jpa.domain.Specification<learning.jpa.bean.User>
     * @Author z7-x
     * @Date 2020/8/19 10:20 上午
     */
    public Page findUsers(User user, Integer page, Integer size) {
        Sort sort = Sort.by(Sort.Direction.DESC, "userId");
        PageRequest pageRequest = PageRequest.of(page, size, sort);
        //组装 过滤条件
        Specification userQuery = userSpecification.condition(user);
        return userRepository.findAll(userQuery, pageRequest);
    }

}
