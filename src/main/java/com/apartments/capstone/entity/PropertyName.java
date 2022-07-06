package com.apartments.capstone.entity;

import javax.persistence.*;

@Entity
@Table(name = "propertyName")
public class PropertyName {
    @Id
    @SequenceGenerator(name = "seq_generator", sequenceName = "seq_generator", allocationSize = 1)
    @GeneratedValue(generator = "seq_generator", strategy = GenerationType.SEQUENCE )
    @Column(name = "property_id")
    private Long propertyId;

    @Column(name ="property_name")
    private String propertyName;

    public PropertyName() {
    }

    public PropertyName(Long propertyId, String propertyName) {
        this.propertyId = propertyId;
        this.propertyName = propertyName;
    }

    public Long getPropertyId() {
        return propertyId;
    }

    public void setPropertyId(Long propertyId) {
        this.propertyId = propertyId;
    }

    public String getPropertyName() {
        return propertyName;
    }

    public void setPropertyName(String propertyName) {
        this.propertyName = propertyName;
    }
}
