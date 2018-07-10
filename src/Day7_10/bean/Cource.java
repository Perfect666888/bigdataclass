package Day7_10.bean;

public class Cource {
    private String cno;
    private String cname;
    private int grade;

    public Cource() {
        super();
    }

    public Cource(String cno, String cname, int grade) {
        this.cno = cno;
        this.cname = cname;
        this.grade = grade;
    }

    public String getCno() {
        return cno;
    }

    public void setCno(String cno) {
        this.cno = cno;
    }

    public String getCname() {
        return cname;
    }

    public void setCname(String cname) {
        this.cname = cname;
    }

    public int getGrade() {
        return grade;
    }

    public void setGrade(int grade) {
        this.grade = grade;
    }

    @Override
    public String
    toString() {
        return "Cource{" +
                "cno='" + cno + '\'' +
                ", cname='" + cname + '\'' +
                ", grade=" + grade +
                '}';
    }
}
