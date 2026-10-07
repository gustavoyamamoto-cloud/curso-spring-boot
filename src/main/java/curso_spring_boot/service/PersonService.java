package curso_spring_boot.service;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;
import java.util.logging.Logger;

import org.springframework.stereotype.Service;

import curso_spring_boot.model.Person;

@Service 
public class PersonService {
    
    private final AtomicLong counter = new AtomicLong();

    private  Logger logger = Logger.getLogger(PersonService.class.getName());


    //Buscar por id
    public Person findById(String id){
        logger.info("Finding one person");

        Person person = new Person();
        person.setId(counter.incrementAndGet());
        person.setFistName("Gustavo");
        person.setLastName("Yamamoto");
        person.setAddress("Nova fatima - Parana - Brasil");
        person.setGender("masculino");
        return person;
    }

    //Listar
    public List<Person> findAll(){
        logger.info("Finding all persons");

        List<Person> persons = new ArrayList<>();
        for(int i = 0; i < 8; i++){
            Person person = mockPerson(i);
            persons.add(person);
        }
        return persons;
    }


    //Cadastrar
    public Person create(Person person){
        logger.info("creating one person");
        
        return person;
    }

    //Atualizar
     public Person uptade(Person person){
        logger.info("updating one person");
        
        return person;
    }

    //Deletar
    public void delete(String id){
        logger.info("Deleting one person");
    }






    private Person mockPerson(int i) {
        Person person = new Person();
        person.setId(counter.incrementAndGet());
        person.setFistName("FirtName: "+ i);
        person.setLastName("LastName: "+ i);
        person.setAddress("Some address in Brasil");
        person.setGender("Male");
        return person;
    }
}
