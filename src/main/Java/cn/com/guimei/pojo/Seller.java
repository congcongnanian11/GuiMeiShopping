package cn.com.guimei.pojo;


import java.util.Date;

public class Seller {

  private Long id;
  private String sellerName;
  private String sellerUser;
  private String sellerPassword;
  private String sellerSex;
  private Date sellerBirthday;
  private String sellerIdCard;
  private String sellerEmail;
  private String sellerTel;
  private String sellerAddress;

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getSellerName() {
    return sellerName;
  }

  public void setSellerName(String sellerName) {
    this.sellerName = sellerName;
  }

  public String getSellerUser() {
    return sellerUser;
  }

  public void setSellerUser(String sellerUser) {
    this.sellerUser = sellerUser;
  }

  public String getSellerPassword() {
    return sellerPassword;
  }

  public void setSellerPassword(String sellerPassword) {
    this.sellerPassword = sellerPassword;
  }

  public String getSellerSex() {
    return sellerSex;
  }

  public void setSellerSex(String sellerSex) {
    this.sellerSex = sellerSex;
  }

  public Date getSellerBirthday() {
    return sellerBirthday;
  }

  public void setSellerBirthday(Date sellerBirthday) {
    this.sellerBirthday = sellerBirthday;
  }

  public String getSellerIdCard() {
    return sellerIdCard;
  }

  public void setSellerIdCard(String sellerIdCard) {
    this.sellerIdCard = sellerIdCard;
  }

  public String getSellerEmail() {
    return sellerEmail;
  }

  public void setSellerEmail(String sellerEmail) {
    this.sellerEmail = sellerEmail;
  }

  public String getSellerTel() {
    return sellerTel;
  }

  public void setSellerTel(String sellerTel) {
    this.sellerTel = sellerTel;
  }

  public String getSellerAddress() {
    return sellerAddress;
  }

  public void setSellerAddress(String sellerAddress) {
    this.sellerAddress = sellerAddress;
  }
}
