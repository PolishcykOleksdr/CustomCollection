package app;

/**
 * author: user,
 * date: 17.01.2026
 */
public class Main {
    public static void main(String[] args) {
        CustomCollection array = new CustomCollection();

        System.out.println("Add even numbers to 10");
        for (int i = 0; i <= 10; i+=2) {
            array.add(String.valueOf(i));
        }
        System.out.println(array);

        System.out.println("Add numbers from the start (from 1 to 5)");
        for (int i = 0; i <= 5; i++) {
            array.add(0, String.valueOf(i));
        }
        System.out.println(array);

        System.out.println("Add x,y,z instead 0,1,2 idx");
        array.set(0,"x");
        array.set(1,"y");
        array.set(2,"z");
        System.out.println(array);

        System.out.println("Remove only first of 2, 4, 6, 8");
        for (int i = 2; i < 10; i+=2) {
            array.delete(String.valueOf(i));
        }
        System.out.println(array);

        System.out.println("Remove all 0");
        array.deleteAll("0");
        System.out.println(array);

        System.out.println("Get str on idx 2");
        System.out.println(array.get(2));
        System.out.println("Get str on idx 1");
        System.out.println(array.get(1));
        System.out.println("Get str on idx 0");
        System.out.println(array.get(0));

        System.out.println("If contain 0");
        System.out.println(array.contain("0"));
        System.out.println("If contain 2");
        System.out.println(array.contain("2"));

        System.out.println("Array:");
        System.out.println(array);
        System.out.println("Size:");
        System.out.println(array.size());
        System.out.println("Clear...");
        array.clear();
        System.out.println("Array:");
        System.out.println(array);
        System.out.println("Size:");
        System.out.println(array.size());
    }
}
