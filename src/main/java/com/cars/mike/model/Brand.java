package com.cars.mike.model;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
public class Brand extends BaseModel {

    @NotNull
    private String name;
    @NotNull
    private BigDecimal yearlyTurnover;
    private Date creationDate;
    private Boolean active;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "BRAND_ID")
    private List<Model> models = new ArrayList<>();

    @ManyToOne
    private Location storehouse;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BigDecimal getYearlyTurnover() {
        return yearlyTurnover;
    }

    public void setYearlyTurnover(BigDecimal yearlyTurnover) {
        this.yearlyTurnover = yearlyTurnover;
    }

    public Date getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }

    public Boolean getActive() {
        return active;
    }

    public void setActive(Boolean active) {
        this.active = active;
    }

    public List<Model> getModels() {
        return models;
    }

    public void setModels(List<Model> models) {
        this.models = models;
    }

    public Location getStorehouse() {
        return storehouse;
    }

    public void setStorehouse(Location storehouse) {
        this.storehouse = storehouse;
    }


}
