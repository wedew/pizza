package com.example.pizza29420.web;

import com.example.pizza29420.Exception.PizzaDoesNotExistsException;
import com.example.pizza29420.Exception.alreadyLateException;
import com.example.pizza29420.Facade.PizzaFacade;
import com.example.pizza29420.beans.Pizza;
import com.example.pizza29420.beans.PizzaSize;
import com.example.pizza29420.beans.Status;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("pizzas")
public class PizzaController {

    private PizzaFacade pizzaFacade;
    public PizzaController(PizzaFacade pizzaFacade) {
        this.pizzaFacade = pizzaFacade;
    }

    @PostMapping
    public ResponseEntity<String> addPizza(@RequestBody Pizza pizza){
        pizzaFacade.addPizza(pizza);
        return ResponseEntity.ok("were successfully received your pizza order!");
    }

    @PostMapping("/update")
    public ResponseEntity<String> updatePizza(@RequestBody Pizza pizza) {
        try{
            pizzaFacade.updatePizza(pizza);
            return ResponseEntity.ok("were successfully received your pizza update!");
        } catch ( PizzaDoesNotExistsException | alreadyLateException e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
    }

    @DeleteMapping
    public ResponseEntity<String> deletePizzaByNumber(@RequestParam int pizzaId)  {
        try {
            pizzaFacade.deletePizzaByNumber(pizzaId);
            return ResponseEntity.ok("pizza number " + pizzaId + " successfully deleted!");
        } catch(PizzaDoesNotExistsException e){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }
    }

    @GetMapping("/one")
    public  ResponseEntity<?> getOnePizza(@RequestParam int pizzaId) {
        try {
            Pizza p1 = pizzaFacade.getOnePizza(pizzaId);
            return ResponseEntity.ok(p1);
        }catch(PizzaDoesNotExistsException e){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }
    }

    @GetMapping("/all")
    public List<Pizza> getAllPizza(){
        return pizzaFacade.getAllPizza();
    }

    @GetMapping("/size")
    public List<Pizza> getPizzaBySize(@RequestParam PizzaSize size){
        return pizzaFacade.getPizzaBySize(size);
    }

    @GetMapping("/status")
    public List<Pizza> getPizzaByStatus(@RequestParam Status status){
        return pizzaFacade.getPizzaByStatus(status);
    }
}
