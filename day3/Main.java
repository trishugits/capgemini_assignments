package CapgeminiTraining.day3;
class Student{
    int rollNo;
    String name;
    int marks;

    public Student(int rollNo, String name, int marks) {
        this.rollNo = rollNo;
        this.name = name;
        this.marks = marks;
    }
}

interface Function<T,K>{
    K call (T obj);
}

class DymanicExtractor<T, K> {
    private Function<T, K> func;
    public DymanicExtractor(Function <T, K> func) {
        this.func = func;
    }
    K extract (T obj) {
        return func.call(obj);
    }
}
public class Main {
    public static void main(String[] args) {
        Student s = new Student(1, "Dymanic", 5);
        DymanicExtractor<Student, String> ex = new DymanicExtractor<Student, String>(student -> student.name);
        System.out.println(ex.extract(s));
    }
}

