package Entity;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;

@Getter
@Setter
@Builder
@NoArgsConstructor
@EqualsAndHashCode
@AllArgsConstructor
@Table(name = "Specialization")
@Entity
public class Specialization implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "profession")
    private String profession;

    @Column(name = "experience")
    private String experience;

    @Column(name = "salary")
    private String salary;

    @ManyToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "vacancy_id")
    private Vacancy vacancy;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "level_id")
    private Level level;

    @OneToMany(mappedBy = "specialization")
    private Set<Technology> technology;

    @Override
    public String toString() {
        return "Specialization " +
                "id = " + id +
                ", profession = " + profession +
                ", experience = " + experience +
                ", salary = " + salary;
    }
}
