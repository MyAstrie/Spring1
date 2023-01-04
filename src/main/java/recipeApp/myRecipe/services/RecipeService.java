package recipeApp.myRecipe.services;

import recipeApp.myRecipe.model.Recipe;

import java.util.Optional;

public interface RecipeService {

    void add(Recipe recipe);

    Optional<Recipe> getRecipeForId(Long id);
}
