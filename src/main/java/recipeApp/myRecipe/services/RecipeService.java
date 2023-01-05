package recipeApp.myRecipe.services;

import recipeApp.myRecipe.model.Recipe;

import java.util.Map;
import java.util.Optional;

public interface RecipeService {

    Recipe add(Recipe recipe);

    Optional<Recipe> getRecipeById(Long id);

    Map<Long, Recipe> getRecipes();
}
