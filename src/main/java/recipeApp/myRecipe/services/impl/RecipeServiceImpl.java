package recipeApp.myRecipe.services.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import recipeApp.myRecipe.model.Recipe;
import recipeApp.myRecipe.repository.RecipeRepository;
import recipeApp.myRecipe.services.RecipeService;

import java.util.Map;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class RecipeServiceImpl implements RecipeService {

    @Autowired
    private RecipeRepository<Long, Recipe> recipeRepository;

    @Override
    public Recipe add(Recipe recipe){
        if(!recipeRepository.existsById(recipe.getId())) {
            return recipeRepository.add(recipe);
        } else {
            throw new RuntimeException("Данный рецепт уже существует");
        }
    }

    @Override
    public Optional<Recipe> getRecipeById(Long id){
        Optional<Recipe> recipe = recipeRepository.findById(id);
        if(recipe.isEmpty()){
            throw new RuntimeException("Рецепт не существует");
        }
        return recipe;
    }

    @Override
    public Map<Long, Recipe> getRecipes(){
        return recipeRepository.getRecipes();
    }
}
