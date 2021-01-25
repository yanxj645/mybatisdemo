package cn.tedu.mybatis;

import cn.tedu.mybatis.mapper.DemoMapper;
import cn.tedu.mybatis.mapper.UserMapper;
import cn.tedu.mybatis.model.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;
import java.util.List;

@SpringBootTest
class MybatisApplicationTests {

    //@Autowired(required = false)
    @Resource
    DemoMapper demoMapper;

    @Test
    void contextLoads() {
        
        String name=demoMapper.hello();
        System.out.println(name);
    }

    @Resource
    UserMapper userMapper;

    //单查
    @Test
    public void testUser(){
        User u=userMapper.findUserById(5);
        System.out.println(u);
    }
    //全查
    @Test
    public void testAll(){
        List<User> users=userMapper.findUsers();
        for(User u:users){
            System.out.println(u);
        }
    }

    //新增用户的方法
    @Test
    public void insert(){
        User user=new User(null,"李大锤",
                "1234",27,
                "13318555721"
                ,"dachun@qq.com");
        Integer num=userMapper.insertUser(user);
        System.out.println(num);
        System.out.println(user.getId());
    }

    //测试全行修改
    @Test
    public void testUpdate(){
        //先从数据库查询一个对象
        User user=userMapper.findUserById(5);
        user.setAge(30);
        int num=userMapper.updateUser(user);
        System.out.println(num);
        System.out.println(user);
    }

    //测试按Id修改电话
    @Test
    public void testPhone(){
        Integer num=userMapper
             .updatePhoneById("13888808080",5);
        System.out.println(num);
    }

    //测试按id删除
    @Test
    public void delete(){
        Integer num=userMapper.deleteUserById(17);
        System.out.println(num);
    }

    @Test
    public void xml(){
        String name=userMapper.helloXml();
        System.out.println(name);
    }

    //测试动态删除
    @Test
    public void deleteIds(){
        int num=userMapper.deleteByIds(1,3,5,7);
        System.out.println(num);
    }




}
