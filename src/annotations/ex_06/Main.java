package annotations.ex_06;

public class Main {
    public static void main(String[] args) throws NoSuchMethodException {
        System.out.println(P.class.getMethod("m").getAnnotation(NoRetention.class));
    }
}