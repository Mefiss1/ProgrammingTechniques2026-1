package com.juanfedevmaster.jsonfileexample.repositories;

import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.util.List;
import java.nio.file.Files;
import java.nio.file.OpenOption;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

import com.juanfedevmaster.jsonfileexample.Model.Person;
import com.juanfedevmaster.jsonfileexample.interfaces.IPersonRepository;

public class PersonRepository implements IPersonRepository{

    @Override
    public boolean saveListPeople(List<Person> peopleList) {
        try{

            if (!Files.exists(Paths.get("People.txt"))) {
                Files.createFile(Paths.get("People.txt"));
            }

            for(Person p : peopleList){
                String value = p.getId()+","+p.getName()+","+p.getLastName()+","+p.getAge()+"\n";
                Files.write(Paths.get("People.txt"), value.getBytes(),StandardOpenOption.APPEND);
            }

        } catch(Exception exe){
            return false;
        }
        return true;
    }
      

    @Override
    public boolean savePerson(Person p) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'savePerson'");
    }

    @Override
    public boolean find(Person p) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'find'");
    }

    @Override
    public List<Person> getPeople() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getPeople'");
    }

}
