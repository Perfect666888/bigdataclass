package Day7_9.bean;

public class Student {
    private String sno;
    private String sname;
    private int age;
    private String sex;
    private String classname;

    public Student() {
    }

    @Override
    public String toString() {
        return "Student{" +
                "sno='" + sno + '\'' +
                ", sname='" + sname + '\'' +
                ", age=" + age +
                ", sex='" + sex + '\'' +
                ", classname='" + classname + '\'' +
                '}';
    }

    public String getSno() {
        return sno;
    }

    public void setSno(String sno) {
        this.sno = sno;
    }

    public String getSname() {
        return sname;
    }

    public void setSname(String sname) {
        this.sname = sname;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getClassname() {
        return classname;
    }

    public void setClassname(String classname) {
        this.classname = classname;
    }

    public Student(String sno, String sname, int age, String sex, String classname) {

        this.sno = sno;
        this.sname = sname;
        this.age = age;
        this.sex = sex;
        this.classname = classname;
    }
}
