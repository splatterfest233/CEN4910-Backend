package com.apartments.capstone.entity;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "fees")
public class Fees implements Serializable {
    @Id
    @SequenceGenerator(name = "seq_generator", sequenceName = "seq_generator", allocationSize = 1)
    @GeneratedValue(generator = "seq_generator", strategy = GenerationType.SEQUENCE )
    @Column(name = "unit_id")
    private Long unitId;

    @Id
    @Column(name = "fee_id")
    private Long feeId;

    @Column(name = "header")
    private String header;

    @Column(name = "value")
    private String value;

    public Fees() {
    }

    public Fees(Long unitId, Long feeId, String header, String value) {
        this.unitId = unitId;
        this.feeId = feeId;
        this.header = header;
        this.value = value;
    }

    public Long getUnitId() {
        return unitId;
    }

    public void setUnitId(Long unitId) {
        this.unitId = unitId;
    }

    public Long getFeeId() {
        return feeId;
    }

    public void setFeeId(Long feeId) {
        this.feeId = feeId;
    }

    public String getHeader() {
        return header;
    }

    public void setHeader(String header) {
        this.header = header;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}
