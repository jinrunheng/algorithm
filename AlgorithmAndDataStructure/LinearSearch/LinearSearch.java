package LinearSearch;

public class LinearSearch {

    private LinearSearch() {
    }

    public static <E> int search(E[] data, E target) {
        for (int i = 0; i < data.length; i++) {
            if (data[i].equals(target)) {
                return i;
            }
        }
        return -1;
    }

    public static void main(String[] args) {

        int[] dataSize = {1000000,10000000};
        for(int n : dataSize){
            Integer[] data = ArrayGenerator.generateOrderedArray(n);
            long start = System.nanoTime();
            for(int i = 0; i < 10; i++){
                LinearSearch.search(data, n);
            }
            long end = System.nanoTime();
            System.out.println("time:" + (end - start) / 1000000000.0 + "s");
        }




        Student[] students = {new Student("Alice"),
                new Student("Duby"),
                new Student("Charles")};
        Student duby = new Student("Duby");
        int res = LinearSearch.search(students, duby);
        System.out.println(res);
    }
}


