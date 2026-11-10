package annotations.ex_09;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class CalcTests {
    static void run(Class<?> c) throws Exception {
        int ok = 0, fail = 0;
        Object inst = c.getDeclaredConstructor().newInstance();

        for (Method m : c.getDeclaredMethods()) {
            MyTest t = m.getAnnotation(MyTest.class);
            if (t == null) continue;

            try {
                m.invoke(inst);
                if (t.expected() == MyTest.None.class) {
                    ok++;
                    System.out.println("PASS " + m.getName());
                }
                else {
                    fail++;
                    System.out.println("FAIL " + m.getName() + ": expected " + t.expected().getSimpleName());
                }
            } catch (InvocationTargetException e) {
                Throwable cause = e.getCause();

                if (t.expected().isInstance(cause)) {
                    ok++;
                    System.out.println("PASS " + m.getName());
                }
                else {
                    fail++;
                    System.out.println("FAIL " + m.getName() + ": " + cause);
                }
            }
        }
        System.out.println("Passed: " + ok + ", failed: " + fail);
    }


    @MyTest
    public void addWorks() {
        if (2 + 2 != 4) throw new AssertionError("2+2");
    }

    @MyTest
    public void broken() {
        if (2 * 2 != 5)
            throw new AssertionError("2*2 should be 5");
    }

    @MyTest(expected = ArithmeticException.class)
    public void divByZero() {
        int x = 1 / 0;
    }

    public void helper() {}
}
