package session_17_Lambda.Homework.PDFResumeBuilder.Data;

import java.util.ArrayList;
import java.util.List;

public class Resume {
    private String name;
    private final PersonalInformation personalInformation;
    private String objective;
    private final Education education;
    private final WorkExperience workExperience;
    private final List<String> skills;

    public Resume() {
        this.personalInformation = new PersonalInformation();
        this.education = new Education();
        this.workExperience = new WorkExperience();
        this.skills = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public PersonalInformation getPersonalInformation() {
        return personalInformation;
    }

    public String getObjective() {
        return objective;
    }

    public Education getEducation() {
        return education;
    }

    public WorkExperience getWorkExperience() {
        return workExperience;
    }

    public List<String> getSkills() {
        return skills;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setObjective(String objective) {
        this.objective = objective;
    }

    public void addSkill(String skill){
        skills.add(skill);
    }
}
