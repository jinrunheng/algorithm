package primary.Lesson2;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

public class MyComparator {
    public static class Student {
        public int id;
        public String name;
        public int age;

        public Student(int id, String name, int age) {
            this.id = id;
            this.name = name;
            this.age = age;
        }

        @Override
        public String toString() {
            return "Student{" +
                    "id=" + id +
                    ", name='" + name + '\'' +
                    ", age=" + age +
                    '}';
        }
    }

    // 按照学生id由小到大
    public static class IdAscendingComparator implements Comparator<Student> {

        @Override
        public int compare(Student o1, Student o2) {
            return o1.id - o2.id;
        }
    }

    // 按照学生id由大到小
    public static class IdDescendingComparator implements Comparator<Student> {

        @Override
        public int compare(Student o1, Student o2) {
            return o2.id - o1.id;
        }
    }

    // 按照学生age由小到大
    public static class AgeAscendingComparator implements Comparator<Student> {

        @Override
        public int compare(Student o1, Student o2) {
            return o1.age - o2.age;
        }
    }

    // 按照学生age由大到小
    public static class AgeDescendingComparator implements Comparator<Student> {

        @Override
        public int compare(Student o1, Student o2) {
            return o2.age - o1.age;
        }
    }

    public static void main(String[] args) {
        Student student1 = new Student(1, "小王", 23);
        Student student2 = new Student(3, "小红", 21);
        Student student3 = new Student(2, "小张", 28);
        Student student4 = new Student(4, "小李", 18);
        Student student5 = new Student(5, "小强", 31);
        List<Student> students = new ArrayList<>();

        students.add(student1);
        students.add(student2);
        students.add(student3);
        students.add(student4);
        students.add(student5);

        PriorityQueue<Student> heap1 = new PriorityQueue<>(new IdDescendingComparator());
        PriorityQueue<Student> heap2 = new PriorityQueue<>(new IdAscendingComparator());
        PriorityQueue<Student> heap3 = new PriorityQueue<>(new AgeDescendingComparator());
        PriorityQueue<Student> heap4 = new PriorityQueue<>(new AgeAscendingComparator());


        for (Student s : students) {
            heap1.add(s);
            heap2.add(s);
            heap3.add(s);
            heap4.add(s);
        }
        System.out.println("按照id升序打印：");
        while (!heap2.isEmpty()) {
            System.out.println(heap2.poll());
        }
        System.out.println("按照id降序打印：");
        while (!heap1.isEmpty()) {
            System.out.println(heap1.poll());
        }
        System.out.println("按照age升序打印：");
        while (!heap4.isEmpty()) {
            System.out.println(heap4.poll());
        }
        System.out.println("按照age降序打印：");
        while (!heap3.isEmpty()) {
            System.out.println(heap3.poll());
        }
    }
}
