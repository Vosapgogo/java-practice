package annotations.ex_03_04;

@Author(name = "Maria")
public class Calculator {
    @Todo
    public void divide(){}

    public static void main(String[] args) {
        System.out.println(
                Calculator.class.getAnnotation(Author.class).name()
                + " "
                + Calculator.class.getAnnotation(Author.class).year());
    }
}
