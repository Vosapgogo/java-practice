package annotations.ex_05;

class Jobs {
    @Run(times = 2)
    public void hello() {
        System.out.println("hello");
    }

    @Run
    public void bye() {
        System.out.println("bye");
    }

    public void skip() {
        System.out.println("SHOULD NOT RUN");
    }
}
