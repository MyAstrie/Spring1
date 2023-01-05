package recipeApp.myRecipe.repository;

import org.springframework.stereotype.Repository;
import recipeApp.myRecipe.model.Ingredient;
import recipeApp.myRecipe.model.Recipe;

import java.util.*;

@Repository
public class RecipeRepository<K,V> extends HashMap<K,V> {

    public boolean existsById(K id) {
        return super.containsKey(id);
    }

    public Optional<V> findById(K id) {
        V value = super.get(id);
        return Optional.ofNullable(value);
    }

    public HashMap<K,V> getRecipes(){
        HashMap<Long, Ingredient> shallowCopy = new HashMap<>();
        Set<Entry<K, V>> entries = super.entrySet();
        for (Entry<K, V> mapEntry : entries) {
            shallowCopy.put((Long) mapEntry.getKey(), (Ingredient) mapEntry.getValue());
        }
        return (HashMap<K, V>) shallowCopy;
    }

    public Recipe add(Recipe r){
        Recipe recipe = new Recipe();
        recipe.setId(r.getId());
        recipe.setName(r.getName());
        recipe.setTimeToCook(r.getTimeToCook());
        recipe.setSteps(r.getSteps());
        super.put((K) recipe.getId(), (V) recipe);
        return recipe;
    }
}
