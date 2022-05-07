package Entity;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "Specialization")
@Entity
public class Specialization implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "profession")
    private String profession;


    @Column(name = "profession_level")
    private String professionLevel;

    @Column(name = "language_level")
    private String languageLevel;

    @Column(name = "experience")
    private String experience;

    @Column(name = "salary")
    private String salary;

    @ManyToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "vacancy_id")
    private Vacancy vacancy;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "technology_specialization",
            joinColumns = {@JoinColumn(name = "id_specialization")},
            inverseJoinColumns = {@JoinColumn(name = "id_technology")})
    private List<Technology> technology;

    @Override
    public String toString() {
        return "Specialization " +
                "id = " + id +
                ", profession = " + profession +
                ", professionLevel = " + professionLevel +
                ", languageLevel = " + languageLevel +
                ", experience = " + experience +
                ", salary = " + salary +
                ", vacancy = " + vacancy;
    }
}
