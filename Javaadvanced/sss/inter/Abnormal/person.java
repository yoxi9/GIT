package Abnormal;

public class person {
    private int age;
    
    public void setAge(int age)  throws AgelnputException{
            if (age < 1 || age > 100) {
                 throw new AgelnputException();
            } else {
               this.age = age;
                System.out.println("ÄêÁä£º" + this.age + "Ëê¡£");
            }
        }
    
    public int getAge() {
        return age;
    }

    public person(){

    }

    public person(int age) {
        this.age = age;
    }
    
}


