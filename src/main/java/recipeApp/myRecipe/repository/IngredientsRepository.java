package recipeApp.myRecipe.repository;

import org.springframework.stereotype.Repository;
import recipeApp.myRecipe.model.Ingredient;
import recipeApp.myRecipe.model.Recipe;

import java.util.HashMap;
import java.util.Optional;
import java.util.Set;

@Repository
public class IngredientsRepository<K,V> extends HashMap<K,V> {

    public boolean existsById(K id){
            return super.containsKey(id);
    }

    public Optional<V> findById(K id) {
        V value = super.get(id);
        return Optional.ofNullable(value);
    }

    public HashMap<K,V> getIngredients(){
        HashMap<Long, Ingredient> shallowCopy = new HashMap<>();
        Set<Entry<K, V>> entries = super.entrySet();
        for (Entry<K, V> mapEntry : entries) {
            shallowCopy.put((Long) mapEntry.getKey(), (Ingredient) mapEntry.getValue());
        }
        return (HashMap<K, V>) shallowCopy;
    }

    public Ingredient add(Ingredient i){
        Ingredient ingredient = new Ingredient();
        ingredient.setId(i.getId());
        ingredient.setName(i.getName());
        ingredient.setQuantity(i.getQuantity());
        ingredient.setMeasurementUnit(i.getMeasurementUnit());
        super.put((K) i.getId(), (V) ingredient);
        return ingredient;
    }
}
