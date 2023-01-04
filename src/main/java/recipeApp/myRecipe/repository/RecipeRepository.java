package recipeApp.myRecipe.repository;

import java.util.HashMap;
import java.util.Optional;

public class RecipeRepository<K,V> extends HashMap<K,V> {

    public boolean existsById(K id) {
        return super.containsKey(id);
    }

    public Optional<V> findById(K id) {
        V value = super.get(id);
        return Optional.ofNullable(value);
    }
}
