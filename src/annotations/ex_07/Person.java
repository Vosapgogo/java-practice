package annotations.ex_07;

public class Person {
    @NotEmpty String name;
    @Range(min = 0, max = 150) int age;

    Person(String n, int a) {
        name = n;
        age = a;
    }
}
