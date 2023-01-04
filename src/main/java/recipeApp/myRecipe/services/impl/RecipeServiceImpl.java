package recipeApp.myRecipe.services.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import recipeApp.myRecipe.model.Recipe;
import recipeApp.myRecipe.repository.RecipeRepository;
import recipeApp.myRecipe.services.RecipeService;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class RecipeServiceImpl implements RecipeService {

    private RecipeRepository<Long, Recipe> recipeRepository;

    @Override
    public void add(Recipe recipe){
        if(!recipeRepository.existsById(recipe.getId())) {
            recipeRepository.put(recipe.getId(),recipe);
        } else {
            throw new RuntimeException("Данный рецепт уже существует");
        }
    }

    @Override
    public Optional<Recipe> getRecipeForId(Long id){
        Optional<Recipe> recipe = recipeRepository.findById(id);
        if(recipe.isEmpty()){
            throw new RuntimeException("Рецепт не существует");
        }
        return recipe;
    }
}
