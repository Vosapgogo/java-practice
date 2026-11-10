package annotations.ex_07;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IllegalAccessException {
        System.out.println(validate(new Person("", 200)));
        System.out.println(validate(new Person("Ira", 20)));
    }

    public static List<String> validate(Object o) throws IllegalAccessException {
        List<String> errors = new ArrayList<>();

        for (Field f : o.getClass().getDeclaredFields()) {
            f.setAccessible(true);

            if (f.isAnnotationPresent(NotEmpty.class)){
                Object v = f.get(o);
                if (v == null || v.toString().isEmpty())
                    errors.add(f.getName() + ": " + f.getAnnotation(NotEmpty.class).message());
            }

            if (f.isAnnotationPresent(Range.class)){
                Range r = f.getAnnotation(Range.class);
                int v = f.getInt(o);
                if (v < r.min() || v > r.max())
                    errors.add(f.getName() + ": " + v + " not in [" + r.min() + ", " + r.max() + "]");
            }
        }
        return errors;
    }
}
