package session_10_OOP.Homework.CollegeManagementSystem;

public enum CourseName {
    MATH, COMPUTER_SCIENCE, PHYSICS, CHEMISTRY, BIOLOGY, GEOGRAPHY, ENGLISH, HISTORY;

    @Override
    public String toString() {
        if (name().contains("_")){
            String[] splitName = name().split("_");
            for (int i = 0; i < splitName.length; i++){
                splitName[i] = splitName[i].charAt(0) + splitName[i].substring(1).toLowerCase();
            }

            return String.join(" ", splitName);
        } else {
            return name().charAt(0) + name().substring(1).toLowerCase();
        }
    }
}
