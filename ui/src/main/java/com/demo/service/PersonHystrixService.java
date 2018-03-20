package com.demo.service;

import com.demo.domain.Person;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * Description:
 *
 * @author Lyz
 * @time 2018-3-20 11:42
 */
@Service
public class PersonHystrixService {

    @Autowired
    PersonService personService;

    @HystrixCommand(fallbackMethod = "fallbackSave")
    public List<Person> save(String name){
        return personService.save(name);
    }

    public List<Person> fallbackSave(String name){
        List<Person> list = new ArrayList<>();
        Person p = new Person("Person Service 故障");
        list.add(p);
        return list;
    }
}
