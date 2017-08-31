package mytest;

public class Single {
    private static Single ourInstance = new Single();

    public static Single getInstance() {
        return ourInstance;
    }

    private Single() {
    }

    public static void main(String[] args) {
        List<String> list =new ArrayList<>();
        list.add("sdaff");
        list.add("121416");
    }
}
