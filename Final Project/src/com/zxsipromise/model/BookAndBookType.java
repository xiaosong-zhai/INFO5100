package com.zxsipromise.model;

public class BookAndBookType {
    private int id;
    private String bookName;
    private String author;
    private String sex;
    private float price;
    private String bookDesc;
    private Integer bookTpyeId;
    private int isflag;
    private int id2;
    private String bookTypeName;
    private String bookTypeDesc;

    public BookAndBookType(){
        super();
    }

    public BookAndBookType(int id, String bookName, String author, String sex, float price, String bookDesc, Integer bookTpyeId, int isflag, int id2, String bookTypeName, String bookTypeDesc) {
        this.id = id;
        this.bookName = bookName;
        this.author = author;
        this.sex = sex;
        this.price = price;
        this.bookDesc = bookDesc;
        this.bookTpyeId = bookTpyeId;
        this.isflag = isflag;
        this.id2 = id2;
        this.bookTypeName = bookTypeName;
        this.bookTypeDesc = bookTypeDesc;
    }

    public BookAndBookType(int id, String bookName, String bookTypeName, String author, float price, String bookDesc) {
        this.id = id;
        this.bookName = bookName;
        this.bookTypeName = bookTypeName;
        this.author = author;
        this.price = price;
        this.bookDesc = bookDesc;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public String getBookDesc() {
        return bookDesc;
    }

    public void setBookDesc(String bookDesc) {
        this.bookDesc = bookDesc;
    }

    public Integer getBookTpyeId() {
        return bookTpyeId;
    }

    public void setBookTpyeId(Integer bookTpyeId) {
        this.bookTpyeId = bookTpyeId;
    }

    public int getIsflag() {
        return isflag;
    }

    public void setIsflag(int isflag) {
        this.isflag = isflag;
    }

    public int getId2() {
        return id2;
    }

    public void setId2(int id2) {
        this.id2 = id2;
    }

    public String getBookTypeName() {
        return bookTypeName;
    }

    public void setBookTypeName(String bookTypeName) {
        this.bookTypeName = bookTypeName;
    }

    public String getBookTypeDesc() {
        return bookTypeDesc;
    }

    public void setBookTypeDesc(String bookTypeDesc) {
        this.bookTypeDesc = bookTypeDesc;
    }

    @Override
    public String toString() {
        return "BookAndBookType{" +
                "id=" + id +
                ", bookName='" + bookName + '\'' +
                ", author='" + author + '\'' +
                ", sex='" + sex + '\'' +
                ", price=" + price +
                ", bookDesc='" + bookDesc + '\'' +
                ", bookTpyeId=" + bookTpyeId +
                ", isflag=" + isflag +
                ", id2=" + id2 +
                ", bookTypeName='" + bookTypeName + '\'' +
                ", bookTypeDesc='" + bookTypeDesc + '\'' +
                '}';
    }
}
