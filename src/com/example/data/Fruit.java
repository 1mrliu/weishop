package com.example.data;

public class Fruit {
	private int id;
	private int type_id ;
	private  int fruit_id ;
    private String name;
    private double price;
    private int number;
    public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getType_id() {
		return type_id;
	}
	public void setType_id(int type_id) {
		this.type_id = type_id;
	}
	public int getFruit_id() {
		return fruit_id;
	}
	public void setFruit_id(int fruit_id) {
		this.fruit_id = fruit_id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public int getNumber() {
		return number;
	}
	public void setNumber(int number) {
		this.number = number;
	}
}
