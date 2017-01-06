package com.cars.mike.model;

import com.cars.mike.utils.ModelTypeEnum;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class ModelType extends BaseModel {

    @Enumerated(EnumType.STRING)
    private ModelTypeEnum name;

    @OneToMany(cascade = CascadeType.ALL)
    private List<Model> modelList = new ArrayList<>();

    public ModelTypeEnum getName() {
        return name;
    }

    public void setName(ModelTypeEnum name) {
        this.name = name;
    }

    public List<Model> getModelList() {
        return modelList;
    }

    public void setModelList(List<Model> modelList) {
        this.modelList = modelList;
    }
}
