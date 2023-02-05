package br.com.arjos.services;

import br.com.arjos.model.Person;
import org.springframework.stereotype.Service;

import java.util.concurrent.atomic.AtomicLong;
import java.util.logging.Logger;
@Service
public class PersonServices {

    private final AtomicLong counter = new AtomicLong();
    private Logger logger = Logger.getLogger(PersonServices.class.getName());

    public Person findById(String id){
        logger.info("Find one Person");
        Person person = new Person();
        person.setId(counter.incrementAndGet());
        person.setFirstName("Primeiro ");
        person.setLastName("da Silva Sauro");
        person.setAddress("São Paulo - São Paulo - Brasil");
        person.setGender("Male");

        return person;
    }
}
