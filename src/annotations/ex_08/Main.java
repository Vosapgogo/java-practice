package annotations.ex_08;

public class Main {
    public static void main(String[] args) throws IllegalAccessException {
        for (Writer w : Book.class.getAnnotationsByType(Writer.class)) {
            System.out.println(w.value());
        }
    }
}
