package tank;

public class Tank {

    private int id;
    private String name;
    private Integer price;
    private Integer weight;
    private Engine engine;
    private Cannon cannon;
    private Turret turret;

    public Tank(int id, String name, Integer price, Integer weight, Engine engine, Cannon cannon, Turret turret) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.weight = weight;
        this.engine = engine;
        this.cannon = cannon;
        this.turret = turret;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public Integer getWeight() {
        return weight;
    }

    public void setWeight(Integer weight) {
        this.weight = weight;
    }

    public Engine getEngine() {
        return engine;
    }

    public void setEngine(Engine engine) {
        this.engine = engine;
    }

    public Cannon getCannon() {
        return cannon;
    }

    public void setCannon(Cannon cannon) {
        this.cannon = cannon;
    }

    public Turret getTurret() {
        return turret;
    }

    public void setTurret(Turret turret) {
        this.turret = turret;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
