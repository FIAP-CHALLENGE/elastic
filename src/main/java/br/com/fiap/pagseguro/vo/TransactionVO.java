package br.com.fiap.pagseguro.vo;

public class TransactionVO {

    private Long id;
    private String hash;
    private String buyerEmail;
    private String sellerEmail;
    private Double value;
    private String createDate;

    public TransactionVO() {}

    public TransactionVO(Long id, String hash, String buyerEmail, String sellerEmail, Double value, String createDate) {
        this.id = id;
        this.hash = hash;
        this.buyerEmail = buyerEmail;
        this.sellerEmail = sellerEmail;
        this.value = value;
        this.createDate = createDate;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getHash() {
        return hash;
    }

    public void setHash(String hash) {
        this.hash = hash;
    }

    public String getBuyerEmail() {
        return buyerEmail;
    }

    public void setBuyerEmail(String buyerEmail) {
        this.buyerEmail = buyerEmail;
    }

    public String getSellerEmail() {
        return sellerEmail;
    }

    public void setSellerEmail(String sellerEmail) {
        this.sellerEmail = sellerEmail;
    }

    public Double getValue() {
        return value;
    }

    public void setValue(Double value) {
        this.value = value;
    }

    public String getCreateDate() {
        return createDate;
    }

    public void setCreateDate(String createDate) {
        this.createDate = createDate.replace(".0", "").replace(" ", "T");
    }

}