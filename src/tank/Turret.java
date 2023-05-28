package tank;

public class Turret extends Part {
    private Integer totalCrew;
    private Integer armor;
    private Integer rotationSpeed;

    public Turret(int id, Maker maker, String name, Integer price, Integer weight, Integer totalCrew, Integer armor, Integer rotationSpeed) {
        super(id, maker, name, price, weight);
        this.totalCrew = totalCrew;
        this.armor = armor;
        this.rotationSpeed = rotationSpeed;
    }

    public Integer getTotalCrew() {
        return totalCrew;
    }

    public void setTotalCrew(Integer totalCrew) {
        this.totalCrew = totalCrew;
    }

    public Integer getArmor() {
        return armor;
    }

    public void setArmor(Integer armor) {
        this.armor = armor;
    }

    public Integer getRotationSpeed() {
        return rotationSpeed;
    }

    public void setRotationSpeed(Integer rotationSpeed) {
        this.rotationSpeed = rotationSpeed;
    }
}
