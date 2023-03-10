package br.com.arjos.controllers;

import br.com.arjos.model.PersonVO;
import br.com.arjos.services.PersonServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/person")
public class PersonController {
    @Autowired
    private PersonServices service;
    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public List<br.com.arjos.data.vo.v1.PersonVO> findAll () {
        return service.findAll();
    }
    @GetMapping(value= "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public PersonVO findById (@PathVariable(value="id") Long id) {
             return service.findById(id);

    }
    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public PersonVO create (@RequestBody PersonVO personVO) {
        return service.create(personVO);

    }
    @PutMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public PersonVO update (@RequestBody PersonVO personVO) {
        return service.update(personVO);

    }
    @DeleteMapping(value= "/{id}")
    public ResponseEntity<?> delete (@PathVariable(value="id") Long id) {
        service.delete(id);
        return ResponseEntity.noContent().build();

    }
}
