package org.j2os;

import org.j2os.entity.Person;
import org.j2os.service.PersonService;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        try {
            PersonService personService = new PersonService();
            Person person1 = new Person().setId(1).setName("Amirsam").setFamily("Bahador").setSalary(1000);
            Person person2 = new Person().setId(2).setName("Ali").setFamily("Ghaderi").setSalary(1000);
            personService.save(person1);
            personService.save(person2);

            person2.setName("Mohammad");
            personService.update(person2);

            List<Person> list = personService.findAll();
            for (Person person : list) {
                System.out.println(person.getId());
                System.out.println(person.getName());
                System.out.println(person.getFamily());
                System.out.println(person.getSalary());
            }
            System.out.println("----------------------after delete----------------------");

            personService.remove(person1);
            list = personService.findAll();
            for (Person person : list) {
                System.out.println(person.getId());
                System.out.println(person.getName());
                System.out.println(person.getFamily());
                System.out.println(person.getSalary());
            }
        } catch (Exception e) {
            System.out.println("اشکالی به وجود آمده است");
            e.printStackTrace();
        }

    }
}
