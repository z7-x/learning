package com.example.springboot.repository;
import com.example.springboot.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 *
 * User表操作接口
 */
@Repository
public interface UserRepositoty extends JpaRepository<User,Long> {
    /*
     * 根据用户名查询
     * 注意：hql语句中的表名应该是ORM映射的类名，而不是数据库中的表
     * */
    User findByName(String name);//findByName中的name为数据库的列名

    /**
     *  User findByName(String name); 相当于===>
     *  Query("select t from User t where t.name = :name");
     *  User findByName(@Param("name") String name);
     */

    /*
     * 查询全部
     *  List<User> findByColumns();
     * */
    @Query("select t from User t")
    List<User> findByColumns();

    /*
     * 删除  必须加入@Modifying和@Transactional
     * */
    @Modifying
    @Transactional
    @Query("delete from User u where u.id=:id")
    int deleteUserById(@Param("id") Integer id);

    @Modifying
    @Transactional
    @Query("update User u set u.name = :name where u.id=:id")
    int queryUserById(@Param("id") Integer id,@Param("name") String name);

    @Query(value = "insert into User value(?,?,?)", nativeQuery = true)
    @Transactional
    @Modifying
    int countUserBy(@Param("id")Integer id,@Param("name") String name,@Param("password") String password);
}