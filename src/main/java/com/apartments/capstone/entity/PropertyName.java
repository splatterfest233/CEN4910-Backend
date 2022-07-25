package com.apartments.capstone.entity;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "propertyName")
public class PropertyName implements Serializable {
    @Id
    @SequenceGenerator(name = "seq_generator", sequenceName = "seq_generator", allocationSize = 1)
    @GeneratedValue(generator = "seq_generator", strategy = GenerationType.SEQUENCE )
    @Column(name = "property_id")
    private int propertyId;

    @Column(name ="property_name")
    private String propertyName;

    public PropertyName() {
    }

    public PropertyName(int propertyId, String propertyName) {
        this.propertyId = propertyId;
        this.propertyName = propertyName;
    }

    public int getPropertyId() {
        return propertyId;
    }

    public void setPropertyId(int propertyId) {
        this.propertyId = propertyId;
    }

    public String getPropertyName() {
        return propertyName;
    }

    public void setPropertyName(String propertyName) {
        this.propertyName = propertyName;
    }
}
