package recipeApp.myRecipe.model;

import lombok.*;
import org.hibernate.Hibernate;
import org.springframework.validation.annotation.Validated;

import javax.persistence.*;
import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Positive;
import java.io.Serializable;
import java.util.List;
import java.util.Objects;

@Data
@Entity
@Validated
@NoArgsConstructor
public class Recipe implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    @Valid
    private Long id;

    @Column(unique = true, nullable = false)
    @NotBlank(message = "Названме рецепта не может быть пустым")
    @Valid
    private String name;

    @Positive(message = "Время готовки должно быть положительно")
    @NotBlank(message = "Время готовки не может быть пустым")
    @Valid
    private Integer timeToCook;

    @NotBlank
    @ElementCollection
    @Valid
    private List<Ingredient> ingredients;

    @NotBlank
    @ElementCollection
    @Valid
    private List<String> steps;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        Recipe recipe = (Recipe) o;
        return id != null && Objects.equals(id, recipe.id);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}
