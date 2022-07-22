package com.apartments.capstone.entity;
import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "propertyInformation")
public class PropertyInformation implements Serializable {

    @Id
    @SequenceGenerator(name = "seq_generator", sequenceName = "seq_generator", allocationSize = 1)
    @GeneratedValue(generator = "seq_generator", strategy = GenerationType.SEQUENCE )
    @Column(name = "unit_id")
    private Long unitId;

    @Id
    @Column(name = "info_id")
    private Long infoId;

    @Column(name = "data")
    private Long data;
}
