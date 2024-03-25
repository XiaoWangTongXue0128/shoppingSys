package domain;
//种类
public class Kind {
    private Integer bid;
    private String bname;

    public Kind() {}

    public Kind(Integer bid, String bname) {
        this.bid = bid;
        this.bname = bname;
    }

    public Integer getBid() {
        return bid;
    }

    public void setBid(Integer bid) {
        this.bid = bid;
    }

    public String getBname() {
        return bname;
    }

    public void setBname(String bname) {
        this.bname = bname;
    }
}
