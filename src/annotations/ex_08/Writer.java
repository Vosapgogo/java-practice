package annotations.ex_08;

import java.lang.annotation.*;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
@Repeatable(Authors.class)
public @interface Writer {
    String value();
}
