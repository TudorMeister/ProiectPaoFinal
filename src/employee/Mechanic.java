package employee;

public class Mechanic extends Employee {

    private Integer experience;

    public Mechanic(int id, String firstName, String lastName, Integer salary, String address, Integer experience) {
        super(id, firstName, lastName, salary, address);
        this.experience = experience;
    }

    public Integer getExperience() {
        return experience;
    }

    public void setExperience(Integer experience) {
        this.experience = experience;
    }

    public void addExperience(Integer experience) {
        this.experience += experience;
    }

}
