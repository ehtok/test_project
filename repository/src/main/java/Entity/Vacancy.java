package Entity;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "Vacancy")
@Entity
public class Vacancy implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "vacancy_description")
    private String description;

    @OneToOne(cascade = CascadeType.DETACH)
    @JoinColumn(name = "location_id")
    private Location locations;

    @ManyToMany(mappedBy = "vacancySet")
    private List<Company> companyList = new ArrayList();

    @OneToMany(mappedBy = "vacancy")
    private List<Specialization> qualifications = new ArrayList();

    @Override
    public String toString() {
        return "Vacancy " +
                "id = " + id +
                ", description = " + description;
    }
}
