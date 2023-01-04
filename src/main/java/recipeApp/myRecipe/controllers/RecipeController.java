package recipeApp.myRecipe.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import recipeApp.myRecipe.services.impl.RecipeServiceImpl;

@RestController
@RequestMapping(value = "/recipe")
@RequiredArgsConstructor
public class RecipeController {

    private final RecipeServiceImpl recipeServiceImpl;

    @GetMapping
    public String start(){
        return "Страница рецепта";
    }

    @GetMapping("/info")
    public RecipeServiceImpl getInfo(){
        return recipeServiceImpl;
    }

    @GetMapping("/create")
    public void create(){}
}
