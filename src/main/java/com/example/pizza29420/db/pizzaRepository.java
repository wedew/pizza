package com.example.pizza29420.db;

import com.example.pizza29420.beans.Pizza;
import com.example.pizza29420.beans.PizzaSize;
import com.example.pizza29420.beans.Status;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface pizzaRepository extends JpaRepository<Pizza, Integer> {

    List<Pizza> getAllBySize(PizzaSize size);
    List<Pizza> getAllByStatus(Status status);

}



