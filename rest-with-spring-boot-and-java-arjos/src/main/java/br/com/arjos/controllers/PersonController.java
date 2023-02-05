package br.com.arjos.controllers;

import br.com.arjos.model.Person;
import br.com.arjos.services.PersonServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.concurrent.atomic.AtomicLong;

@RestController
@RequestMapping("/person")
public class PersonController {
    @Autowired
    private PersonServices service;
    private final AtomicLong counter = new AtomicLong();
    @RequestMapping(value= "/{id}", method= RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public Person findById (@PathVariable(value="id") String id) throws Exception {
             return service.findById(id);

    }
}
