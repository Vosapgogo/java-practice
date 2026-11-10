package annotations.ex_05;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class Main {
    public static void main(String[] args) throws InvocationTargetException, IllegalAccessException {
        Jobs jobs = new Jobs();
        for (Method m : Jobs.class.getDeclaredMethods()) {
            Run r = m.getAnnotation(Run.class);
            if (r != null) {
                for (int i = 0; i < r.times(); i++) {
                    m.invoke(jobs);
                }
            }
        }
    }
}
