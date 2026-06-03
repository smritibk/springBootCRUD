package com.nchl.projectcrudoperation.dto;

import com.nchl.projectcrudoperation.utils.IdEncoder;

public class BookDTO {
    private Integer id;
    private String encodedId;
    private String title;
    private String author;
    private String genre;
    private Double price;
    private Boolean isAvailable;

    public BookDTO() {
    }

    public BookDTO(Integer id, String encodedId, String title, String author, String genre, Double price, Boolean isAvailable) {
        this.id=id;
        this.encodedId=encodedId;
        this.title = title;
        this.genre = genre;
        this.author = author;
        this.price = price;
        this.isAvailable = isAvailable;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getEncodedId() {
        return encodedId;
    }

    public void setEncodedId(String encodedId) {
        this.encodedId = encodedId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Boolean getAvailable() {
        return isAvailable;
    }

    public void setAvailable(Boolean available) {
        isAvailable = available;
    }
}