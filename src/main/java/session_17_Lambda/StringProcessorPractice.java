package session_17_Lambda;

public class StringProcessorPractice {
    public static void main(String[] args) {
        StringProcessor removeWhiteSpaces = str -> str.replace(" ", "");
        StringProcessor toUpperCase = str -> str.toUpperCase();

//        System.out.println(removeWhiteSpaces.processor("Hello from lambda."));
//        System.out.println(toUpperCase.processor(removeWhiteSpaces.processor("Hello from lambda.")));

        StringProcessor combined = removeWhiteSpaces.andThen(toUpperCase);
        System.out.println(combined.processor("Hello Lambda"));

        StringProcessor reverseCombined = toUpperCase.andThen(removeWhiteSpaces);
        System.out.println(reverseCombined.processor("Hello Lambda"));
    }
}
