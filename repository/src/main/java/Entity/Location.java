package Entity;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "Location")
@Entity
public class Location implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "county")
    private String country;

    @Column(name = "city")
    private String city;

    @OneToOne(mappedBy = "location")
    private Course course;

    @OneToOne(mappedBy = "locations")
    private Vacancy vacancy;

    @Override
    public String toString() {
        return "Location " +
                "id = " + id +
                ", country = " + country +
                ", city = " + city;
    }
}
