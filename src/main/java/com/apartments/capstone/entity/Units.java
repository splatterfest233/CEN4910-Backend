package com.apartments.capstone.entity;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "units")
public class Units implements Serializable {
    @Id
    @SequenceGenerator(name = "seq_generator", sequenceName = "seq_generator", allocationSize = 1)
    @GeneratedValue(generator = "seq_generator", strategy = GenerationType.SEQUENCE )
    @Column(name = "unit_id")
    private Long unitId;

    @Id
    @Column(name = "property_id")
    private Long propertyId;

    @Column(name = "price")
    private int price;

    @Column(name = "sqft")
    private int sqft;

    @Column(name = "type")
    private String type;

    @Column(name = "availability")
    private String availability;

    @Column(name = "model_name")
    private String modelName;

    @Column(name = "lease_options")
    private String leaseOptions;

    public Units() {
    }

    public Units(Long unitId, Long propertyId, int price, int sqft, String type, String availability, String modelName, String leaseOptions) {
        this.unitId = unitId;
        this.propertyId = propertyId;
        this.price = price;
        this.sqft = sqft;
        this.type = type;
        this.availability = availability;
        this.modelName = modelName;
        this.leaseOptions = leaseOptions;
    }

    public Long getUnitId() {
        return unitId;
    }

    public void setUnitId(Long unitId) {
        this.unitId = unitId;
    }

    public Long getPropertyId() {
        return propertyId;
    }

    public void setPropertyId(Long propertyId) {
        this.propertyId = propertyId;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getSqft() {
        return sqft;
    }

    public void setSqft(int sqft) {
        this.sqft = sqft;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getAvailability() {
        return availability;
    }

    public void setAvailability(String availability) {
        this.availability = availability;
    }

    public String getModelName() {
        return modelName;
    }

    public void setModelName(String modelName) {
        this.modelName = modelName;
    }

    public String getLeaseOptions() {
        return leaseOptions;
    }

    public void setLeaseOptions(String leaseOptions) {
        this.leaseOptions = leaseOptions;
    }
}
