package recipeApp.myRecipe.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import recipeApp.myRecipe.model.Ingredient;
import recipeApp.myRecipe.services.impl.IngredientsServiceImpl;

import javax.validation.Valid;
import java.util.Map;
import java.util.Optional;

@RestController
@ResponseBody
@Validated
@RequestMapping("/ingredients")
@RequiredArgsConstructor
public class IngredientsController {

    private final IngredientsServiceImpl ingredientsServiceImpl;

    @GetMapping
    public String start(){
        return "Страница ингредиента";
    }

    @PostMapping
    public Ingredient addProduct(@Valid @RequestBody Ingredient ingredient){
        return ingredientsServiceImpl.add(ingredient);
    }

    @GetMapping("{id}")
    public Optional<Ingredient> findRecipeById(@PathVariable long id) {
        return ingredientsServiceImpl.getIngredientById(id);
    }

    @GetMapping("/info")
    public Map<Long, Ingredient> getRecipes(){
        return ingredientsServiceImpl.getIngredients();
    }
}
