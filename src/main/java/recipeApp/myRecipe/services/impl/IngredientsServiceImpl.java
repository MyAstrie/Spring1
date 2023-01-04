package recipeApp.myRecipe.services.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import recipeApp.myRecipe.model.Ingredient;
import recipeApp.myRecipe.repository.IngredientsRepository;
import recipeApp.myRecipe.services.IngredientsService;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class IngredientsServiceImpl implements IngredientsService {

    private IngredientsRepository<Long, Ingredient> ingredientsRepository;

    @Override
    public void add(Ingredient ingredient){
        if(!ingredientsRepository.existsById(ingredient.getId())){
            ingredientsRepository.put(ingredient.getId(), ingredient);
        } else {
            throw new RuntimeException("Данный инградиент уже существует");
        }
    }

    @Override
    public Optional<Ingredient> getRecipeForId(Long id){
        Optional<Ingredient> ingredient = ingredientsRepository.findById(id);
        if(ingredient.isEmpty()){
            throw new RuntimeException("Рецепт не существует");
        }
        return ingredient;
    }
}
