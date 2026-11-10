package annotations.ex_03_04;

import java.lang.reflect.Method;

public class Main {
    public static void main(String[] args) {
        for (Method m : Calculator.class.getDeclaredMethods()) {
            if (m.isAnnotationPresent(Todo.class)) {
                System.out.println("TODO: "+m.getName());
            }
        }
    }
}
