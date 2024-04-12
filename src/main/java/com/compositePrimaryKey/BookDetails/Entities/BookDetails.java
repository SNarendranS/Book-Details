package com.compositePrimaryKey.BookDetails.Entities;

import jakarta.persistence.*;

@Entity
@IdClass(value = BookPrimaryKey.class)
@NamedQuery(name = "findByTitle",query = "select b from BookDetails b where b.title=?1")
public class BookDetails {
	@Id
	private String title;
	@Id
	private String language;
	private double price;
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	@Override
	public String toString() {
		return "BookDetails [title=" + title + ", language=" + language + ", price=" + price + "]\n";
	}
	public String getLanguage() {
		return language;
	}
	public void setLanguage(String language) {
		this.language = language;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public BookDetails() {
		super();
		// TODO Auto-generated constructor stub
	}
	public BookDetails(String title, String language, double price) {
		super();
		this.title = title;
		this.language = language;
		this.price = price;
	}
}
