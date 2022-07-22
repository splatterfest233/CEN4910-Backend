package com.apartments.capstone.entity;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "coordinates")
public class Coordinates implements Serializable {

    @Id
    @SequenceGenerator(name = "seq_generator", sequenceName = "seq_generator", allocationSize = 1)
    @GeneratedValue(generator = "seq_generator", strategy = GenerationType.SEQUENCE )
    @Column(name = "coord_id")
    private Long coordId;

    @Id
    @Column(name = "property_id")
    private Long propertyId;

    @Column(name = "latitude")
    private int latitude;

    @Column(name = "longitude")
    private int longitude;

    public Coordinates() {
    }

    public Coordinates(Long coordId, Long propertyId, int latitude, int longitude) {
        this.coordId = coordId;
        this.propertyId = propertyId;
        this.latitude = latitude;
        this.longitude = longitude;
    }

    public Long getCoordId() {
        return coordId;
    }

    public void setCoordId(Long coordId) {
        this.coordId = coordId;
    }

    public Long getPropertyId() {
        return propertyId;
    }

    public void setPropertyId(Long propertyId) {
        this.propertyId = propertyId;
    }

    public int getLatitude() {
        return latitude;
    }

    public void setLatitude(int latitude) {
        this.latitude = latitude;
    }

    public int getLongitude() {
        return longitude;
    }

    public void setLongitude(int longitude) {
        this.longitude = longitude;
    }
}
