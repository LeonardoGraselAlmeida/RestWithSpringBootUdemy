package br.com.leonardoalmeida.restwithspringbootudemy.data.vo;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

public class BookVO implements Serializable {
    private static final long serialVersionUID = 1L;

    private Long id;
    private String author;
    private Date launchDate;
    private double price;
    private String title;

    public BookVO() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public Date getLaunchDate() {
        return launchDate;
    }

    public void setLaunchDate(Date launchDate) {
        this.launchDate = launchDate;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof BookVO)) return false;
        BookVO bookVO = (BookVO) o;
        return Double.compare(bookVO.getPrice(), getPrice()) == 0 && Objects.equals(getId(), bookVO.getId()) && Objects.equals(getAuthor(), bookVO.getAuthor()) && Objects.equals(getLaunchDate(), bookVO.getLaunchDate()) && Objects.equals(getTitle(), bookVO.getTitle());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getAuthor(), getLaunchDate(), getPrice(), getTitle());
    }
}
