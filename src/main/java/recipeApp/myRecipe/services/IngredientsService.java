package recipeApp.myRecipe.services;

import recipeApp.myRecipe.model.Ingredient;

import java.util.Map;
import java.util.Optional;

public interface IngredientsService {

    Ingredient add(Ingredient ingredient);

    Optional<Ingredient> getIngredientById(Long id);

    Map<Long, Ingredient> getIngredients();
}
