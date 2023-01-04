package recipeApp.myRecipe.model;

import lombok.*;
import org.hibernate.Hibernate;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import java.util.Objects;

@Entity
@Getter
@Setter
@ToString
@NoArgsConstructor
public class Ingredient {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @NotNull(message = "Названме инградиента не может быть пустым")
    private String name;

    @Positive(message = "Количество инградиентов должно быть положительным")
    private Integer quantity;

    @NotNull(message = "Еденица измерения не может быть пустая")
    private String measurementUnit;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        Ingredient ingredient = (Ingredient) o;
        return id != null && Objects.equals(id, ingredient.id);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}
