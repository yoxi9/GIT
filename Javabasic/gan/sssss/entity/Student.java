package entity;

public class Student {
	
    private int id;
    private String grade;
    private String  name;
    private int number;

    public Student(){

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    @Override
    public String toString() {
        return "ĞòºÅ£º"+this.id+",ĞÕÃû£º"+this.name+",°à¼¶:"+
                this.grade+",Ñ§ºÅ£º"+this.number;
    }
}
