package org.j2os.service;

import org.j2os.entity.Person;
import org.j2os.repository.PersonRepository;

import java.util.List;

public class PersonService {

    public void save(Person person)throws Exception {
        PersonRepository personRepository = new PersonRepository();
        person.setSalary(person.getSalary()-((person.getSalary()*10)/100));
        personRepository.insert(person);
        personRepository.close();
    }
    public void update(Person person)throws Exception {
        PersonRepository personRepository = new PersonRepository();
        personRepository.update(person);
        personRepository.close();
    }
    public void remove(Person person)throws Exception{
        PersonRepository personRepository = new PersonRepository();
        personRepository.delete(person);
        personRepository.close();
    }
    public List<Person> findAll()throws Exception{
        PersonRepository personRepository = new PersonRepository();
        List<Person> list = personRepository.selectAll();
        personRepository.close();
        return list;
    }
}
