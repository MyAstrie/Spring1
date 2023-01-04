/*package recipeApp.myRecipe.repositoryJPA;

import org.springframework.data.jpa.repository.JpaRepository;
import recipeApp.myRecipe.model.Ingredient;

import javax.transaction.Transactional;
import java.util.Optional;

public interface IngredientsRepositoryJpa extends JpaRepository<Ingredient, Long> {

    boolean existsById(Long id);
    Optional<Ingredient> findById(Long id);

    @Transactional
    void deleteById(Long id);
}
*/