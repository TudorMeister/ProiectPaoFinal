package tank;

public class Cannon extends Part {
    private Integer caliber;
    private Integer length;

    public Cannon(int id, Maker maker, String name, Integer price, Integer weight, Integer caliber, Integer length) {
        super(id, maker, name, price, weight);
        this.caliber = caliber;
        this.length = length;
    }

    public Integer getCaliber() {
        return caliber;
    }

    public void setCaliber(Integer caliber) {
        this.caliber = caliber;
    }

    public Integer getLength() {
        return length;
    }

    public void setLength(Integer length) {
        this.length = length;
    }
}
