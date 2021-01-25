package cn.tedu.mybatis.mapper;

import cn.tedu.mybatis.model.Dept;

public interface DeptMapper {

    //部门的关联查询
    //按照id查询部门和部门中员工的信息
    Dept findDeptWithUsersById(Integer id);


}
