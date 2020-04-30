package com.example.pizza29420;

import com.example.pizza29420.Exception.PizzaDoesNotExistsException;
import com.example.pizza29420.Exception.alreadyLateException;
import com.example.pizza29420.Facade.PizzaFacade;
import com.example.pizza29420.beans.Pizza;
import com.example.pizza29420.beans.PizzaSize;
import com.example.pizza29420.beans.Status;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import java.lang.reflect.Array;
import java.util.ArrayList;

@SpringBootApplication
public class Pizza29420Application {

    public static void main(String[] args) {
        ConfigurableApplicationContext ctx =  SpringApplication.run(Pizza29420Application.class, args);

        PizzaFacade pizza = ctx.getBean(PizzaFacade.class);

//        ArrayList<String> topping = new ArrayList<>();
//        topping.add("olive");
//        topping.add("mushroom");
//        topping.add("corn");
//        pizza.addPizza(new Pizza(PizzaSize.large,topping, Status.New));



//        try {
//            Pizza p1 = pizza.getOnePizza(1);
//            System.out.println(p1.getTopping());
//        } catch (PizzaDoesNotExistsException e) {
//            System.out.println(e.getMessage());
//        }

//        try {
//        ArrayList<String> topping = new ArrayList<>();
//        topping.add("olive");
//        topping.add("mushroom");
//            Pizza p1 = pizza.getOnePizza(1);
//            p1.setStatus(Status.inTheOven);
//            p1.setTopping(topping);
//            pizza.updatePizza(p1);
//
//
//        } catch (PizzaDoesNotExistsException | alreadyLateException e) {
//            System.out.println(e.getMessage());
//        }

//        pizza.deletePizzaByNumber(2);

//        for (Pizza pizza1:pizza.getAllPizza()
//             ) {
//            System.out.println(pizza1);
//        }

//        for (Pizza pizza2:pizza.getPizzaBySize(PizzaSize.medium)
//             ) {
//            System.out.println(pizza2);
//        }

//        for (Pizza pizza3:pizza.getPizzaByStatus(Status.New)
//        ) {
//            System.out.println(pizza3);
//        }


    }

}
