package day60.day15;

public class FunctionalInterFace {
    public static void main(String[] args) {
        String a = "Laxmi", b = "Samal";
        Example lengthSum = (x, y) -> x.length() + y.length();
        int result = lengthSum.test(a, b);
        System.out.println(result);

    }
}
