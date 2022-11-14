package michalmlynarczyk.bikeservicemanagement.part;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Entity(name = "part")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Part {
    @SequenceGenerator(
            name = "part_sequence",
            sequenceName = "part_sequence",
            allocationSize = 1
    )
    @Id
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "part_sequence"
    )
    private Long id;

    @Column(length = 100)
    @NotBlank
    private String partName;

    @NotNull
    private Double price;

    @NotNull
    private Integer quantity;
}
