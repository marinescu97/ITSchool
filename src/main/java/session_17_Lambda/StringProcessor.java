package session_17_Lambda;

@FunctionalInterface
public interface StringProcessor {
    String processor(String input);

    default StringProcessor andThen(StringProcessor after){
        return input -> after.processor(this.processor(input));
    }
}
