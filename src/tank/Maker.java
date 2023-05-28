package tank;

public class Maker {

    protected int id;
    protected String name;
    protected String hqLocation;

    public Maker(int id, String name, String hqLocation) {
        this.id = id;
        this.name = name;
        this.hqLocation = hqLocation;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getHqLocation() {
        return hqLocation;
    }

    public void setHqLocation(String hqLocation) {
        this.hqLocation = hqLocation;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
