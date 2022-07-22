package com.apartments.capstone.entity;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "utilities")
public class Utilities implements Serializable {
    @Id
    @SequenceGenerator(name = "seq_generator", sequenceName = "seq_generator", allocationSize = 1)
    @GeneratedValue(generator = "seq_generator", strategy = GenerationType.SEQUENCE )
    @Column(name = "unit_id")
    private Long unitId;

    @Id
    @Column(name = "fee_id")
    private Long utilId;

    @Column(name = "name")
    private String name;

    @Column(name = "value")
    private String value;

    public Utilities() {
    }

    public Utilities(Long unitId, Long utilId, String name, String value) {
        this.unitId = unitId;
        this.utilId = utilId;
        this.name = name;
        this.value = value;
    }

    public Long getUnitId() {
        return unitId;
    }

    public void setUnitId(Long unitId) {
        this.unitId = unitId;
    }

    public Long getUtilId() {
        return utilId;
    }

    public void setUtilId(Long utilId) {
        this.utilId = utilId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}
