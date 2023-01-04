package recipeApp.myRecipe.services;

import recipeApp.myRecipe.model.Ingredient;

import java.util.Optional;

public interface IngredientsService {

    void add(Ingredient ingredient);

    Optional<Ingredient> getRecipeForId(Long id);
}
