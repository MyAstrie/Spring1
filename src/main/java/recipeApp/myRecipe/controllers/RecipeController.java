package recipeApp.myRecipe.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import recipeApp.myRecipe.model.Recipe;
import recipeApp.myRecipe.services.impl.RecipeServiceImpl;

import javax.validation.Valid;
import java.util.Map;
import java.util.Optional;

@RestController
@ResponseBody
@Validated
@RequestMapping(value = "/recipe")
@RequiredArgsConstructor
public class RecipeController {

    private final RecipeServiceImpl recipeServiceImpl;

    @GetMapping
    public String start(){
        return "Страница рецепта";
    }

    @GetMapping("/info")
    public Map<Long,Recipe> getRecipes(){
        return recipeServiceImpl.getRecipes();
    }

    @PostMapping
    public Recipe addProduct(@Valid @RequestBody Recipe recipe) {
        return recipeServiceImpl.add(recipe);
    }

    @GetMapping("{id}")
    public Optional<Recipe> findRecipeById(@PathVariable long id) {
        return recipeServiceImpl.getRecipeById(id);
    }
}
