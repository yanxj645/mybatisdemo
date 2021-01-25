package cn.tedu.mybatis.param;

public class ParamTest {
    //可变参数指方法的参数列表中,一个参数类型后跟...的写法
    //这个写法的目的是为了方便方法的调用

    //若要使用可变参数需要在定义时遵循如下语法规则
    //1.每个方法只能定义一个可变参数,
    //  而且必须是参数列表中最后一个参数
    //2.在定义的方法体中使用这个参数时
    //  将这个参数视为一个数组来操作

    //调用带有可变参数方法时需要注意
    //1.可变参数的数量不限(0个或1个或多个皆可)
    //2.同时可变参数的位置接受数组类型的参数


    public static void sum(int... nums){
        int result=0;
        for(int i=0;i<nums.length;i++){
            result+=nums[i];
        }
        System.out.println(result);
    }
    public static void main(String[] args) {
        int[] nums={5,7,1,0,4,4,1,54,5};
        sum(nums);
    }


}
