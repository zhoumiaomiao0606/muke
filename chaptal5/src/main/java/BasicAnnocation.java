import org.testng.annotations.*;

public class BasicAnnocation {
    @Test
    public void  testng(){
System.out.print("test1这是测试的基本注解");}

@Test
        public  void testng1(){


            System.out.print("test2这是测试的基本注解");
        }


    @AfterMethod
    public void afterMethod(){
        System.out.print("afterMethod在测试方法之后");
    }
    @BeforeMethod
    public void beforeMethod(){
        System.out.print("beforeMethod在测试方法之前");
    }

    @BeforeClass
    public void beforeClass(){
        System.out.print("beforeClass在测试类之前");
    }

    @AfterClass
    public void afterClass(){
        System.out.print("afterClass在测试类之后");
    }
    @BeforeSuite
    public void beforeSuite(){
        System.out.print("beforeSuite在   beforeClass之前");
    }

    @AfterSuite
    public void afterSuite(){
        System.out.print("afterSuite在afterClass之后");
    }
}
