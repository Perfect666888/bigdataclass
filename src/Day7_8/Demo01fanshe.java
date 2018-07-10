package Day7_8;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.ArrayList;

public class Demo01fanshe {
    public static void main(String[] args)  throws Exception{
        //获取class对象的方式1
        Person p1 =new Person("老王",24);
        Class c1 =  p1.getClass();

        //获取class对象的方式2
        Class c2 =Person.class;

        //获取class对象的方式3
        Class c3 =Class.forName("Day7_8.Person");

        System.out.println("---------------------------------------");
        //获得类的公共构造方法
        Constructor[] gggz = c3.getConstructors();
        System.out.println("遍历公共构造方法");
        for (Constructor gz : gggz) {
            System.out.println(gz);
        }
        System.out.println("---------------------------------------");
        //获得所有的构造方法
        Constructor[] dcgz = c3.getDeclaredConstructors();
        System.out.println("遍历全部构造方法");
        for (Constructor gz : dcgz) {
            System.out.println(gz);
        }
        System.out.println("---------------------------------------");
        //获得单个构造方法
        Constructor dggz = c3.getConstructor();
        System.out.println("单个的无参构造方法"+dggz);

        System.out.println("---------------------------------------");
        //实例化对象
        Person slh =(Person) dggz.newInstance();
        System.out.println("无参构造生成对象"+slh);

        System.out.println("---------------------------------------");
        //获得指定的构造方法
        Constructor zdgz = c3.getConstructor(String.class, int.class);
        System.out.println("指定的构造方法"+zdgz);
        Person pp = (Person)zdgz.newInstance("L", 20);
        System.out.println("指定构造生成的对象"+pp);

        System.out.println("---------------------------------------");
        //获得全部公共属性
        Field[] ggsx = c3.getFields();
        System.out.println("公共属性");
        for (Field field : ggsx) {
            System.out.println(field);
        }

        System.out.println("---------------------------------------");
        //获得的全部属性
        Field[] qbsx = c3.getDeclaredFields();
        System.out.println("全部属性");
        for (Field field : qbsx) {
            System.out.println(field);
        }

        System.out.println("---------------------------------------");
        //获取公共方法
        Method[] ggm = c3.getMethods();
        System.out.println("遍历公共方法");
        for (Method method : ggm) {
            System.out.println(method);
        }

        System.out.println("---------------------------------------");
        //获得全部方法
        Method[] allm = c3.getDeclaredMethods();
        System.out.println("遍历全部方法");
        for (Method method : allm) {
            System.out.println(method);
        }
        System.out.println("---------------------------------------");
        //获得指定方法
        Method zdggff = c3.getDeclaredMethod("setAge", int.class);
        //获得方法的各种属性
        System.out.println("指定方法的修饰符"+Modifier.toString(zdggff.getModifiers()));
        System.out.println("指定方法的名字"+zdggff.getName());
        System.out.println("指定方法的参数类型"+zdggff.getParameterTypes()[0]);


        //通过无参构造生成对象
        Person pp2 =(Person) c3.getConstructor().newInstance();
        //使用指定方法赋值
        zdggff.invoke(pp2, 100);
        System.out.println(pp2);





        System.out.println("---------------------------------------");
        //获得指定方法
        Method zdfa = c3.getMethod("setName", String.class);
        Method zdfa2 = c3.getMethod("toString");
        //创建对象
        Person pnew = (Person)c3.getConstructor().newInstance();
        zdfa.invoke(pnew, "指定方法");
        System.out.println(pnew);
        zdfa2.invoke(pnew);
        System.out.println("toString"+pnew);

        System.out.println("---------------------------------------");
        //反射跳过泛型检查
        ArrayList<Person> parr = new ArrayList<>();
        parr.add(new Person("小一",1));
        parr.add(new Person("小二",2));
        parr.add(new Person("小三",3));
        parr.add(new Person("小四",4));
        parr.add(new Person("小五",5));
        parr.add(new Person("小六",6));

        System.out.println("遍历原来的集合");
        System.out.println("原本集合有的元素个数"+parr.size());
        for (Person person : parr) {
            System.out.println(person);
        }

        System.out.println("-------------------------------" );

        Class<? extends ArrayList> arrc = parr.getClass();
        //获得指定的方法,带参数
        Method cadd = arrc.getMethod("add",Object.class);
        //调用方法存放参数
        cadd.invoke(parr, "我跳过了泛型检查");

        System.out.println("遍历跳过检查后的集合 ");
        System.out.println("添加元素之后的集合个数"+parr.size());
        //因为添加了不是Person类的元素，所以使用object作为元素类型
        for (Object o : parr) {
            System.out.println(o);
        }

    }
}
