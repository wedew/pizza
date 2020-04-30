package com.example.pizza29420.Facade;

import com.example.pizza29420.Exception.PizzaDoesNotExistsException;
import com.example.pizza29420.Exception.alreadyLateException;
import com.example.pizza29420.beans.Pizza;
import com.example.pizza29420.beans.PizzaSize;
import com.example.pizza29420.beans.Status;
import com.example.pizza29420.db.pizzaRepository;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Scope("prototype")
public class PizzaFacade {
    private pizzaRepository pizzaRepo;
    public PizzaFacade(pizzaRepository pizzaRepo) {
        this.pizzaRepo = pizzaRepo;
    }

    public void addPizza(Pizza pizza){
        Pizza p1 = new Pizza(pizza.getSize(), pizza.getTopping(), pizza.getStatus());
        pizzaRepo.save(p1);
    }
    public void updatePizza(Pizza pizza) throws PizzaDoesNotExistsException, alreadyLateException {
        Pizza p1 = pizzaRepo.findById(pizza.getNumber()).orElseThrow(PizzaDoesNotExistsException:: new);
        pizza.setSize(p1.getSize());
        pizza.setPrice(p1.getPrice());
        if(p1.getStatus() != pizza.getStatus()){
            pizzaRepo.save(pizza);
        }else if(pizza.getStatus() == Status.New){
            if(pizza.getSize().ordinal() == 0) {
                pizza.setPrice(20 + (pizza.getTopping().size() * 2));
                pizzaRepo.save(pizza);
            }
            else if(pizza.getSize().ordinal() == 1 ) {
                pizza.setPrice(25 + (pizza.getTopping().size() * 2));
                pizzaRepo.save(pizza);
            }
            else if(pizza.getSize().ordinal() == 2 ) {
                pizza.setPrice(30 + (pizza.getTopping().size() * 2));
                pizzaRepo.save(pizza);
            }
        }else{
            throw new alreadyLateException();
        }
    }
    public void deletePizzaByNumber(int pizzaNumber) throws PizzaDoesNotExistsException{
        pizzaRepo.findById(pizzaNumber).orElseThrow(PizzaDoesNotExistsException::new);
        pizzaRepo.deleteById(pizzaNumber);
    }
    public Pizza getOnePizza(int pizzaId) throws PizzaDoesNotExistsException {
        return pizzaRepo.findById(pizzaId).orElseThrow(PizzaDoesNotExistsException:: new);
    }
    public List<Pizza> getAllPizza(){
        return pizzaRepo.findAll();
    }

    public List<Pizza> getPizzaBySize(PizzaSize size){
        return pizzaRepo.getAllBySize(size);
    }

    public List<Pizza> getPizzaByStatus(Status status){
        return pizzaRepo.getAllByStatus(status);
    }

}
