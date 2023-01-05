package recipeApp.myRecipe.services.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import recipeApp.myRecipe.model.Ingredient;
import recipeApp.myRecipe.repository.IngredientsRepository;
import recipeApp.myRecipe.services.IngredientsService;

import java.util.Map;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class IngredientsServiceImpl implements IngredientsService {

    @Autowired
    private IngredientsRepository<Long, Ingredient> ingredientsRepository;

    @Override
    public Ingredient add(Ingredient ingredient){
        if(!ingredientsRepository.existsById(ingredient.getId())){
            ingredientsRepository.add(ingredient);
            return ingredientsRepository.get(ingredient.getId());
        } else {
            throw new RuntimeException("Данный инградиент уже существует");
        }
    }

    @Override
    public Optional<Ingredient> getIngredientById(Long id){
        Optional<Ingredient> ingredient = ingredientsRepository.findById(id);
        if(ingredient.isEmpty()){
            throw new RuntimeException("Ингредиента не существует");
        }
        return ingredient;
    }

    @Override
    public Map<Long, Ingredient> getIngredients(){
        return ingredientsRepository.getIngredients();
    }
}
