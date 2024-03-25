package domain;

public class GoodsList {
    private String bname;
    private String cname;
    private Float cprice;
    private Integer quantity;

    public GoodsList(String bname, String cname, Float cprice, Integer quantity) {
        this.bname = bname;
        this.cname = cname;
        this.cprice = cprice;
        this.quantity = quantity;
    }

    public GoodsList() {}

    public String getBname() {
        return bname;
    }

    public void setBname(String bname) {
        this.bname = bname;
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

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }
}
