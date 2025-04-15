package session_16_Hash;

public class Box<T>{
    private T obj;

    public T getObj() {
        return obj;
    }

    public void setObj(T obj) {
        this.obj = obj;
    }
}

class BoxTest{
    public static void main(String[] args) {
        Box<String> stringBox = new Box<>();
        stringBox.setObj("Hello");
        System.out.println(stringBox.getObj());

        Box<Integer> integerBox = new Box<>();
        integerBox.setObj(23);
        System.out.println(integerBox.getObj());
    }
}
