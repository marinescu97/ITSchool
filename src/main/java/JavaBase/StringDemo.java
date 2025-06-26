package JavaBase;

public class StringDemo {
    public static void main(String[] args) {
        String s = "Java";
        String s2 = "Java";
        String t = new String("Java");

        System.out.println(s == t);
        System.out.println(s == s2);
        System.out.println(s.equals(t));
    }
}
