/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.juanfedevmaster.jsonfileexample;

import com.google.gson.Gson;
import com.juanfedevmaster.jsonfileexample.Model.Person;
import com.juanfedevmaster.jsonfileexample.interfaces.IPersonService;
import com.juanfedevmaster.jsonfileexample.services.PersonService;

import java.util.ArrayList;
import org.json.simple.JSONObject;

/**
 *
 * @author juanfe
 */
public class JsonFileExample {

    public static void main(String[] args) {
        
        /*var person = new Person("Juan Felipe", "Quintana", 40);
        JSONObject obj = new JSONObject();
        
        
        obj.put("name", person.getName());
        obj.put("lastName", person.getLastName());
        obj.put("age", person.getAge());
        
        System.out.println(obj);
        
        
        var people = new ArrayList<Person>();
        
        people.add(new Person("Juan Felipe","Quintana",40));
        people.add(new Person("Laura","Quintana",36));
        people.add(new Person("Camilo","Gómez",46));
        
        Gson gson = new Gson();
        var jsonFormat = gson.toJson(people);
        
        System.out.println(jsonFormat);*/

        var people = new ArrayList<Person>();
        
        people.add(new Person(1,"Juan Felipe","Quintana",40));
        people.add(new Person(2,"Laura","Quintana",36));
        people.add(new Person(4, "Camilo","Gómez",46));
        
        IPersonService personService = new PersonService();

        try {
            boolean save = personService.saveListPeople(people);
        } catch (Exception e) {
            // TODO: handle exception
        }
        
    }
}
