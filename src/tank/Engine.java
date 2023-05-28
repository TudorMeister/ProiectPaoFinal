package tank;

public class Engine extends Part {
    private Integer power;
    private String configuration;
    private String fuelType;

    public Engine(int id, Maker maker, String name, Integer price, Integer weight, Integer power, String configuration, String fuelType) {
        super(id, maker, name, price, weight);
        this.power = power;
        this.configuration = configuration;
        this.fuelType = fuelType;
    }

    public Integer getPower() {
        return power;
    }

    public void setPower(Integer power) {
        this.power = power;
    }

    public String getConfiguration() {
        return configuration;
    }

    public void setConfiguration(String configuration) {
        this.configuration = configuration;
    }

    public String getFuelType() {
        return fuelType;
    }

    public void setFuelType(String fuelType) {
        this.fuelType = fuelType;
    }
}
