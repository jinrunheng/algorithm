package BasicSorting.SelectionSort;

public class Student implements Comparable<Student> {

    private String name;
    private int id;

    public Student(String name, int id) {
        this.name = name;
        this.id = id;
    }

    @Override
    public boolean equals(Object student) {

        if (this == student) {
            return true;
        }
        if (student == null) {
            return false;
        }
        if (this.getClass() != student.getClass()) {
            return false;
        }
        Student another = (Student) student;
        return this.name.equalsIgnoreCase(another.name);
    }

    @Override
    public int compareTo(Student s) {
        return this.id - s.id;
//        // 按照学生的id排序
//        if (this.id < s.id) {
//            return -1;
//        } else if (this.id == s.id) {
//            return 0;
//        } else {
//            return 1;
//        }
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", id=" + id +
                '}';
    }
}
