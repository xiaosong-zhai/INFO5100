package com.zxsipromise.model;

public class Book {
    private int id;
    private String bookName;
    private String author;
    private String sex;
    private float price;
    private String bookDesc;
    private Integer bookTpyeId;
    private int isflag;

    public Book(int id, String bookName, String author, String sex, float price, String bookDesc, Integer bookTpyeId, int isflag) {
        super();
        this.id = id;
        this.bookName = bookName;
        this.author = author;
        this.sex = sex;
        this.price = price;
        this.bookDesc = bookDesc;
        this.bookTpyeId = bookTpyeId;
        this.isflag = isflag;
    }

    public Book(int id, String bookName, String author, String sex, float price, String bookDesc, Integer bookTpyeId) {
        super();
        this.id = id;
        this.bookName = bookName;
        this.author = author;
        this.sex = sex;
        this.price = price;
        this.bookDesc = bookDesc;
        this.bookTpyeId = bookTpyeId;
    }

    public Book(){

    }

    public Book(String bookName, String author, String sex, float price, String bookDesc) {
        super();
        this.bookName = bookName;
        this.author = author;
        this.sex = sex;
        this.price = price;
        this.bookDesc = bookDesc;
    }

    public Book(int id, String bookName, String author, String sex, float price, String bookDesc, int bookTpyeId) {
        super();
        this.id = id;
        this.bookName = bookName;
        this.author = author;
        this.sex = sex;
        this.price = price;
        this.bookDesc = bookDesc;
        this.bookTpyeId = bookTpyeId;
    }

    public Book(String bookName){
        this.bookName = bookName;
    }

    public Book(int id, String bookName, String author, float price, String bookDesc, String sex, int bookTpyeId) {
        this.id = id;
        this.bookName = bookName;
        this.author = author;
        this.price = price;
        this.bookDesc = bookDesc;
        this.sex = sex;
        this.bookTpyeId = bookTpyeId;
    }

    public Book(int id, String bookName, String author, float price, String bookDesc) {
        this.id = id;
        this.bookName = bookName;
        this.author = author;
        this.price = price;
        this.bookDesc = bookDesc;
    }

    public Book(int id){
        this.id = id;
    }

    public Book(int id, String bookName, String author) {
        this.id = id;
        this.bookName = bookName;
        this.author = author;
    }

    public Book(int id, String bookName, float price, String author, String sex, int bookTpyeId) {
        this.id = id;
        this.bookName = bookName;
        this.price = price;
        this.author = author;
        this.sex = sex;
        this.bookTpyeId = bookTpyeId;
    }

    public Book(int id, String bookName, float price, String author, String sex, String bookDesc, int bookTpyeId) {
        this.id = id;
        this.bookName = bookName;
        this.price = price;
        this.author = author;
        this.sex = sex;
        this.bookDesc = bookDesc;
        this.bookTpyeId = bookTpyeId;
    }

    public Book(String bookName,String author,float price,String bookDesc,int id){
        this.bookName = bookName;
        this.author = author;
        this.price = price;
        this.bookDesc = bookDesc;
        this.id = id;
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

    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", bookName='" + bookName + '\'' +
                ", author='" + author + '\'' +
                ", sex='" + sex + '\'' +
                ", price=" + price +
                ", bookDesc='" + bookDesc + '\'' +
                ", bookTpyeId=" + bookTpyeId +
                '}';
    }
}
