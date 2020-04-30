package com.example.pizza29420.beans;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "pizza")
public class Pizza {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int number;
    @Column
    private PizzaSize size;
    @ElementCollection
    private List<String> topping;
    @Column
    private int price;
    @Column
    private Status status;

    public Pizza() {}

    public Pizza(PizzaSize size, List<String> topping, Status status) {
        this.size = size;
        this.topping = topping;
        if(size.ordinal() == 0)
            this.price = 20 + (topping.size() * 2);
        else if(size.ordinal() == 1 )
            this.price = 25 + (topping.size() * 2);
        else if(size.ordinal() == 2 )
            this.price = 30 + (topping.size() * 2);
        this.status = status;
    }

    public int getNumber() {
        return number;
    }

    public PizzaSize getSize() {
        return size;
    }

    public void setSize(PizzaSize size) {
        this.size = size;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public List<String> getTopping() {
        return topping;
    }

    public void setTopping(List<String> topping) {
        this.topping = topping;
    }

    public int getPrice() {
        return price;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

}
