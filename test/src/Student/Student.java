package Student;

public class Student {
    private Integer age;
    private String name;

    public void setAge(Integer age) {
        this.age = age;
    }
    public Integer getAge() {
        return age;
    }

    public void setName(String name) {
        this.name = name;
    }
    @Loggable
    public String getName() {
        return name;
    }

    public void printThrowException(){
        System.out.println("Exception raised");
        throw new IllegalArgumentException();
    }
    @Override
    public String toString() {
        return "Student, name: " + name + ", age: " +age;
    }
}
