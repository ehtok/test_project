package Entity;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;


@Getter
@Setter
@Builder
@NoArgsConstructor
@EqualsAndHashCode
@AllArgsConstructor
@Table(name = "technology")
@Entity
public class Technology implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "name_technology")
    private String technology;

    @ManyToMany(mappedBy = "technology")
    private List<Specialization> specialization;

    @Override
    public String toString() {
        return "Technology " +
                "id = " + id +
                ", technology = " + technology;
    }
}
