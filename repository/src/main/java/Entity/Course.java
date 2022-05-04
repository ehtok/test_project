package Entity;

import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@Builder
@NoArgsConstructor
@EqualsAndHashCode
@AllArgsConstructor
@Table(name = "Course")
@Entity
public class Course {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "course_description")
    private String description;

    @Column(name = "start_date")
    private String dateStart;

    @Column(name = "date_finish")
    private String dateFinish;

    @OneToOne(cascade = CascadeType.DETACH)
    @JoinColumn(name = "location_id")
    private Location location;

    @ManyToMany(mappedBy = "courseSet")
    private List<Company> companyList = new ArrayList();

    @Override
    public String toString() {
        return "Course " +
                "id = " + id +
                ", description = " + description +
                ", dateStart = " + dateStart +
                ", dateFinish = " + dateFinish;
    }
}
