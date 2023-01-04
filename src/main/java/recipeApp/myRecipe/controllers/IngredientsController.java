package recipeApp.myRecipe.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import recipeApp.myRecipe.services.impl.IngredientsServiceImpl;

@RestController
@RequestMapping("/ingredients")
@RequiredArgsConstructor
public class IngredientsController {

    private final IngredientsServiceImpl ingredientsServiceImpl;

    @GetMapping
    public String start(){
        return "Страница ингредиента";
    }

    @GetMapping("/info")
    public IngredientsServiceImpl getInfo(){
        return ingredientsServiceImpl;
    }

    @GetMapping("/create")
    public void create(){}
}
