package com.cars.mike.Controller;

import com.cars.mike.model.Model;
import com.cars.mike.repository.ModelJpaRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/")
public class ModelController {

    @Autowired
    private ModelJpaRepository modelJpaRepository;  // todo change for service layer

    @RequestMapping(value = "models", method = RequestMethod.GET)
    public List<Model> list() {
        return modelJpaRepository.findAll();
    }

    @RequestMapping(value = "model/{id}", method = RequestMethod.GET)
    public Model get(@PathVariable Long id) {
        return modelJpaRepository.findOne(id);
    }

    @RequestMapping(value = "model/{id}", method = RequestMethod.PUT)
    public Model update(@PathVariable Long id, @RequestBody Model model) {
        Model existingModel = modelJpaRepository.findOne(id);
        BeanUtils.copyProperties(model, existingModel);
        return modelJpaRepository.saveAndFlush(existingModel);
    }

    @RequestMapping(value = "model", method = RequestMethod.POST)
    public Model create(@RequestBody Model model) {
        return modelJpaRepository.saveAndFlush(model);
    }

    @RequestMapping(value = "model/{id}", method = RequestMethod.DELETE)
    public Model delete(@PathVariable Long id) {
        Model existingModel = modelJpaRepository.findOne(id);
        modelJpaRepository.delete(existingModel);
        return existingModel;
    }
}
