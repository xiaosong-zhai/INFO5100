package com.zxsipromise.model;

public class BookType {
    private int id;
    private String bookTypeName;
    private String bookTypeDesc;

    public BookType(){
        super();
    }

    public BookType(int id, String bookTypeName, String bookTypeDesc) {
        this.id = id;
        this.bookTypeName = bookTypeName;
        this.bookTypeDesc = bookTypeDesc;
    }

    public BookType(String bookTypeName, String bookTypeDesc) {
        this.bookTypeName = bookTypeName;
        this.bookTypeDesc = bookTypeDesc;
    }

    public BookType(String bookTypeName) {
        this.bookTypeName = bookTypeName;
    }

    public BookType(int id) {
        this.id = id;
    }

    public BookType(String bookTypeName, String bookTypeDesc,int id) {
        this.bookTypeName = bookTypeName;
        this.bookTypeDesc = bookTypeDesc;
        this.id = id;
    }

    public BookType(int id, String bookTypeName) {
        this.id = id;
        this.bookTypeName = bookTypeName;
    }

    public BookType(String bookTypeName, int id) {
        this.bookTypeName = bookTypeName;
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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
        return bookTypeName;
    }
}
