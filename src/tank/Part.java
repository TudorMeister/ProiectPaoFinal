package tank;

public abstract class Part implements Comparable<Part>{

    protected int id;
    protected Maker maker;
    protected String name;
    protected Integer price;
    protected Integer weight;

    protected Part(int id, Maker maker, String name, Integer price, Integer weight) {
        this.id = id;
        this.maker = maker;
        this.name = name;
        this.price = price;
        this.weight = weight;
    }

    public Maker getMaker() {
        return maker;
    }

    public void setMaker(Maker maker) {
        this.maker = maker;
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

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public int compareTo(Part p) {
        return this.weight - p.weight;
    }
}
