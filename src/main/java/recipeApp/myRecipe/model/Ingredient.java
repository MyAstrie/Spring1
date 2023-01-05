package recipeApp.myRecipe.model;

import lombok.*;
import org.hibernate.Hibernate;
import org.springframework.validation.annotation.Validated;

import javax.persistence.*;
import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Positive;
import java.io.Serializable;
import java.util.Objects;


@Data
@Entity
@Validated
@NoArgsConstructor
public class Ingredient implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    @Valid
    private Long id;

    @NotBlank(message = "Названме инградиента не может быть пустым")
    @Valid
    private String name;

    @NotBlank
    @Positive(message = "Количество инградиентов должно быть положительным")
    @Valid
    private Integer quantity;

    @NotBlank(message = "Еденица измерения не может быть пустая")
    @Valid
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
