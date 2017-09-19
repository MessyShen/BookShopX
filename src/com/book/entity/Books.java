package com.book.entity;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
public class Books {
    private int id;
    private String title;
    private String author;
    private Timestamp publishDate;
    private String isbn;
    private double unitPrice;
    private String contentDescription;
    private String toc;
    private int publisherId;
//    private String publisherName;
    private int clicks;
    private int categoryId;



    private Categories categories;
    private Publishers publishers;

    @ManyToOne
    @JoinColumn(name="publisherId")
    public Publishers getPublishers() {
        return publishers;
    }

    public void setPublishers(Publishers publishers) {
        this.publishers = publishers;
    }

    @ManyToOne
    @JoinColumn(name="categoryId")
    public Categories getCategories() {
        return categories;
    }

    public void setCategories(Categories categories) {
        this.categories = categories;
    }

    @Id
    @Column(name = "Id", nullable = false)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "Title", nullable = false, length = 200)
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Basic
    @Column(name = "Author", nullable = false, length = 200)
    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    @Basic
    @Column(name = "PublishDate", nullable = false)
    public Timestamp getPublishDate() {
        return publishDate;
    }

    public void setPublishDate(Timestamp publishDate) {
        this.publishDate = publishDate;
    }

    @Basic
    @Column(name = "ISBN", nullable = false, length = 50)
    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    @Basic
    @Column(name = "UnitPrice", nullable = false)
    public double getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(double unitPrice) {
        this.unitPrice = unitPrice;
    }

    @Basic
    @Column(name = "ContentDescription", nullable = true, length = 2147483647)
    public String getContentDescription() {
        return contentDescription;
    }

    public void setContentDescription(String contentDescription) {
        this.contentDescription = contentDescription;
    }

    @Basic
    @Column(name = "TOC", nullable = true, length = 2147483647)
    public String getToc() {
        return toc;
    }

    public void setToc(String toc) {
        this.toc = toc;
    }

    @Basic
    @Column(name = "Clicks", nullable = false)
    public int getClicks() {
        return clicks;
    }

    public void setClicks(int clicks) {
        this.clicks = clicks;
    }

    @Basic
    @Column(name = "PublisherId", nullable = false)
    public int getPublisherId() {
        return publisherId;
    }

    public void setPublisherId(int publisherId) {
        this.publisherId = publisherId;
    }

    @Basic
    @Column(name = "CategoryId", nullable = false)
    public int getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(int categoryId) {
        this.categoryId = categoryId;
    }



    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Books books = (Books) o;

        if (id != books.id) return false;
        if (Double.compare(books.unitPrice, unitPrice) != 0) return false;
        if (clicks != books.clicks) return false;
        if (title != null ? !title.equals(books.title) : books.title != null) return false;
        if (author != null ? !author.equals(books.author) : books.author != null) return false;
        if (publishDate != null ? !publishDate.equals(books.publishDate) : books.publishDate != null) return false;
        if (isbn != null ? !isbn.equals(books.isbn) : books.isbn != null) return false;
        if (contentDescription != null ? !contentDescription.equals(books.contentDescription) : books.contentDescription != null)
            return false;
        if (toc != null ? !toc.equals(books.toc) : books.toc != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        result = id;
        result = 31 * result + (title != null ? title.hashCode() : 0);
        result = 31 * result + (author != null ? author.hashCode() : 0);
        result = 31 * result + (publishDate != null ? publishDate.hashCode() : 0);
        result = 31 * result + (isbn != null ? isbn.hashCode() : 0);
        temp = Double.doubleToLongBits(unitPrice);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        result = 31 * result + (contentDescription != null ? contentDescription.hashCode() : 0);
        result = 31 * result + (toc != null ? toc.hashCode() : 0);
        result = 31 * result + clicks;
        return result;
    }
}
