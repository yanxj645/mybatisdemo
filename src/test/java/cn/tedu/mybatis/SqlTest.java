package cn.tedu.mybatis;

import cn.tedu.mybatis.mapper.DeptMapper;
import cn.tedu.mybatis.mapper.UserMapper;
import cn.tedu.mybatis.model.Dept;
import cn.tedu.mybatis.model.User;
import cn.tedu.mybatis.vo.UserVo;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;
import java.util.List;

@SpringBootTest
public class SqlTest {
    @Resource
    UserMapper userMapper;
    @Test
    public void updateInfo(){
        User user=new User();
        user.setId(4);
        //user.setEmail("163@qq.com");
        user.setAge(35);
        user.setPassword("6666");
        Integer num=userMapper.updateUserInfo(user);
        System.out.println(num);

    }

    @Test
    public void sqlSelect(){

        List<User> users=userMapper.findUserByParams(
                null,27,"138%");
        for(User u: users){
            System.out.println(u);
        }
    }

    @Test
    public void testVo(){
        List<UserVo> list=userMapper.findUserDept();
        for(UserVo u : list){
            System.out.println(u);
        }
    }

    @Resource
    DeptMapper deptMapper;
    @Test
    public void dept(){
        Dept dept=deptMapper.
                findDeptWithUsersById(1);
        System.out.println(dept);
        for(User u:dept.getUsers()){
            System.out.println(u);
        }
    }



}
