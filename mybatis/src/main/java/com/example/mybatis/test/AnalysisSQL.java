package com.example.mybatis.test;

import com.example.mybatis.entity.MUser;
import org.apache.ibatis.annotations.Select;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.List;
import java.util.Map;

/**
 * @Classname TestProxy
 * @Description TODO
 * @Date 2020/10/13 5:09 下午
 * @Author z7-x
 */
interface UsersMapper {
    @Select("select * from LEARN_USER where id = #{id}")
    List<MUser> selectMUserList(Integer id, String userName);
}

public class AnalysisSQL {
    public static void main(String[] args) {
        UsersMapper usersMapper = (UsersMapper) Proxy.newProxyInstance(AnalysisSQL.class.getClassLoader(), new Class<?>[]{UsersMapper.class}, new InvocationHandler() {
            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                Select annotation = method.getAnnotation(Select.class);
//                Map<String,Object> nameArgMap = biu
                if (annotation != null) {

                }
                return null;
            }
        });
        usersMapper.selectMUserList(1, "张三");
    }
}
