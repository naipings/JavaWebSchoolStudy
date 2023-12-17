package cn.edu.swu.book.model;

import java.math.BigDecimal;

public class Book {

    private Integer id;
    private String name;
    private String author;
    private BigDecimal price;
    private String content;
    private String imageUrl;
    private Integer num;

    public  Book() {

    }

    public Book(Integer id, String name, String author, BigDecimal price, Integer num, String content, String imageUrl) {
        this.id = id;
        this.name = name;
        this.author = author;
        this.price = price;
        this.num = num;
        this.content = content;
        this.imageUrl = imageUrl;
    }

    public Book(Integer id, String name, String author, BigDecimal price, String content, String imageUrl) {
        this.id = id;
        this.name = name;
        this.author = author;
        this.price = price;
        this.content = content;
        this.imageUrl = imageUrl;
    }

    public Book(String name, String author, BigDecimal price, String content, String imageUrl) {
        this.name = name;
        this.author = author;
        this.price = price;
        this.content = content;
        this.imageUrl = imageUrl;
    }

    public Book(Integer id, String name, String author, BigDecimal price, String content) {
        this.id = id;
        this.name = name;
        this.author = author;
        this.price = price;
        this.content = content;
    }

    public Book(String name, String author, BigDecimal price, String content) {
        this.name = name;
        this.author = author;
        this.price = price;
        this.content = content;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public Integer getNum() {
        return num;
    }

    public void setNum(Integer num) {
        this.num = num;
    }

}
