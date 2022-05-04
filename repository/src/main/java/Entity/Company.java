package Entity;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;


@Getter
@Setter
@Builder
@NoArgsConstructor
@EqualsAndHashCode
@AllArgsConstructor
@Table(name = "COMPANY")
@Entity
public class Company implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "name")
    private String name;

    @Column(name = "company_size")
    private String companySize;

    @Column(name = "type_company")
    private String typeCompany;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "company_vacancy",
            joinColumns = {@JoinColumn(name = "id_company")},
            inverseJoinColumns = {@JoinColumn(name = "id_vacancy")}
    )
    private Set<Vacancy> vacancySet = new HashSet<>();


    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "company_course",
            joinColumns = {@JoinColumn(name = "id_company")},
            inverseJoinColumns = {@JoinColumn(name = "id_vacancy")})
    private Set<Course> courseSet = new HashSet<>();

    @Override
    public String toString() {
        return "Company " +
                "id = " + id +
                ", name = " + name +
                ", company size = " + companySize +
                ", company type = " + typeCompany;
    }

}
