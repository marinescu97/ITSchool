package session_8_Arrays.Homework;

public class TestDiary {
    public static void main(String[] args) {
        PersonalDiary diary = new PersonalDiary();

        diary.add("2025-03-24", "I finished reading a great book.");
        diary.add("2025-03-02", "The weather was sunny and warm.");
        diary.add("2025-04-12", "I called my parents and caught up with them.");
        diary.add("2025-03-15", "I felt happy and confident today.");

        diary.add("02-03-2025", "I learned something new today.");
        diary.add("2025-02-03", "I learned something new today.");

        diary.delete("2025-04-12");

        diary.edit("2025-03-15", "I went for a walk in the park.");

        diary.display();
    }
}
