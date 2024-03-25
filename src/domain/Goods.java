package domain;

public class Goods {
    private Integer cid;
    private String cname;
    private Float cprice;
    private Integer inventory;
    private Integer bid;

    public Goods() {}

    public Goods(Integer cid, String cname, Float cprice, Integer inventory, Integer bid) {
        this.cid = cid;
        this.cname = cname;
        this.cprice = cprice;
        this.inventory = inventory;
        this.bid = bid;
    }

    public Integer getCid() {
        return cid;
    }

    public void setCid(Integer cid) {
        this.cid = cid;
    }

    public String getCname() {
        return cname;
    }

    public void setCname(String cname) {
        this.cname = cname;
    }

    public Float getCprice() {
        return cprice;
    }

    public void setCprice(Float cprice) {
        this.cprice = cprice;
    }

    public Integer getInventory() {
        return inventory;
    }

    public void setInventory(Integer inventory) {
        this.inventory = inventory;
    }

    public Integer getBid() {
        return bid;
    }

    public void setBid(Integer bid) {
        this.bid = bid;
    }
}
