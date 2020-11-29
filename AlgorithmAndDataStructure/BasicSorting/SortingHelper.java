package BasicSorting;

import java.lang.reflect.Method;
import java.util.Arrays;

public class SortingHelper {

    private SortingHelper() {
    }

    // 验证是否排好序  1
    public static <E extends Comparable<E>> boolean isSorted(E[] arr) {
        for (int i = 1; i < arr.length; i++) {
            if (arr[i - 1].compareTo(arr[i]) > 0) {
                return false;
            }
        }
        return true;
    }

    // 验证是否排好序  2
    public static <E extends Comparable<E>> boolean success(E[] arr, String sortname) throws Exception {
        E[] copyArr = Arrays.copyOfRange(arr, 0, arr.length);
        Class<?> clazz = Class.forName(sortname);
        Method method = clazz.getMethod("sort", Comparable[].class);
        method.invoke(null, (Object) arr);
        Arrays.sort(copyArr);
        for (int i = 0; i < arr.length; i++) {
            if (!arr[i].equals(copyArr[i])) {
                return false;
            }
        }
        return true;
    }

    public static <E extends Comparable<E>> void sortTest(String sortname, E[] arr) throws Exception {
        Class<?> clazz = Class.forName(sortname);
        Method method = clazz.getMethod("sort", Comparable[].class);
        long startTime = System.nanoTime();

        method.invoke(null, (Object) arr);

        long endTime = System.nanoTime();
        double time = (endTime - startTime) / 1000000000.0;
        if (!SortingHelper.isSorted(arr)) {
            throw new RuntimeException(sortname + "failed");
        }
        System.out.println(String.format("%s,n = %d : %f s", sortname.substring(sortname.lastIndexOf(".") + 1), arr.length, time));
    }
}
