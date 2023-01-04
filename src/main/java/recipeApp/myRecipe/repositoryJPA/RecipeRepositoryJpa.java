/*package recipeApp.myRecipe.repositoryJPA;

import org.springframework.data.jpa.repository.JpaRepository;
import recipeApp.myRecipe.model.Recipe;

import javax.transaction.Transactional;
import java.util.Optional;

public interface RecipeRepositoryJpa extends JpaRepository<Recipe, Long> {

    boolean existsById(Long id);
    Optional<Recipe> findById(Long id);

    @Transactional
    void deleteById(Long id);
}
*/