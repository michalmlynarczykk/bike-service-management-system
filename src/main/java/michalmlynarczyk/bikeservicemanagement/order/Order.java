package michalmlynarczyk.bikeservicemanagement.order;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import michalmlynarczyk.bikeservicemanagement.bike.Bike;
import michalmlynarczyk.bikeservicemanagement.client.Client;
import michalmlynarczyk.bikeservicemanagement.part.Part;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Transient;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.sql.Date;
import java.util.List;

@Entity(name = "repair_order")
@Data
@EqualsAndHashCode(exclude = {"client", "bike"})
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Order implements Serializable {
    @SequenceGenerator(
            name = "repair_order_sequence",
            sequenceName = "repair_order_sequence",
            allocationSize = 1
    )
    @Id
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "repair_order_sequence"
    )
    private Long id;

    @NotNull
    private Date orderDate;

    @Column(length = 500)
    @NotBlank
    private String description;

    @NotNull
    private Double servicePrice;

    @Enumerated(value = EnumType.STRING)
    @NotNull
    private OrderStatus status;

    @Transient
    private Double totalRepairPrice;

    @OneToMany(
            cascade = CascadeType.ALL,
            fetch = FetchType.EAGER,
            orphanRemoval = true
    )
    @JoinColumn(
            name = "repair_order_id",
            referencedColumnName = "id"
    )
    private List<Part> parts;

    @ManyToOne(
            optional = false
    )
    @JoinColumn(
            name = "bike_id",
            referencedColumnName = "id",
            nullable = false)
    private Bike bike;

    @ManyToOne(
            optional = false
    )
    @JoinColumn(
            name = "client_id",
            referencedColumnName = "id",
            nullable = false)
    private Client client;

}
