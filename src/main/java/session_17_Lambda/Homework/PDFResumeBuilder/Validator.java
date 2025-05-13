package session_17_Lambda.Homework.PDFResumeBuilder;

import java.util.function.Predicate;

@FunctionalInterface
public interface Validator {
    String validate(String value);

    static Validator checkNull(String categoryName) {
        return (val) -> {
            if (val != null && !val.trim().isEmpty()) {
                return val;
            } else {
                System.out.println("The " + categoryName + " doesn't exist!");
                System.exit(1);
                return null;
            }
        };
    }

    default Validator thenCheck(Predicate<String> condition, String errorMessage) {
        return (v) -> {
            String result = this.validate(v);
            if (condition.test(result)) {
                return result;
            } else {
                System.out.println(errorMessage);
                System.exit(1);
                return null;
            }
        };
    }
}
