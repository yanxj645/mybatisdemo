package cn.tedu.mybatis.mapper;

import cn.tedu.mybatis.model.User;
import cn.tedu.mybatis.vo.UserVo;
import org.apache.ibatis.annotations.*;

import java.util.List;

public interface UserMapper {

    @Select("select id,username,password,age," +
            "phone,email from t_user where id=#{id}")
    User findUserById(Integer id);

    @Select("select * from t_user")
    List<User> findUsers();

    //新增功能
    @Insert("insert into t_user values(" +
            "null,#{username},#{password},#{age}," +
            "#{phone},#{email})")
    @Options(useGeneratedKeys = true,keyProperty = "id")
    Integer insertUser(User user);

    //全行修改
    @Update("update t_user set username=#{username}," +
            " password=#{password},age=#{age}," +
            " phone=#{phone},email=#{email} " +
            " where id=#{id}")
    Integer updateUser(User user);

    //按指定id修改手机号
    @Update("update t_user set phone=#{phone} " +
            "where id=#{id}")
    Integer updatePhoneById(String phone,Integer id);

    //按id删除
    @Delete("delete from t_user where id=#{id}")
    Integer deleteUserById(Integer id);

    //这个方法是xml文件实现的
    String helloXml();

    //动态sql删除
    Integer deleteByIds(Integer... ids);

    //动态sql if修改
    Integer updateUserInfo(User user);

    //动态sql 查询
    List<User> findUserByParams(
            String username,
            Integer age,
            String phone
    );

    //关联查询
    List<UserVo> findUserDept();



}
