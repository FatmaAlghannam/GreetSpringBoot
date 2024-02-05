package com.letcode.SecureBankSystem.controller;

import com.letcode.SecureBankSystem.bo.CreateFarewellRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

//import javax.naming.Name;

@RestController

public class CodedController {
    private List<Contact>contacts =new ArrayList<>();

    @GetMapping("/sayHI")

    public String sayHi() {
        return "Welcome to coded";
    }

    //for new -> open we should do it all crtlC-ctrlV
    @GetMapping("/greet")

    public String greet(@RequestParam String name) {
        return "Hi " + name + "!";
    }

    @PostMapping("/farewell")
    public String farewell(@RequestBody CreateFarewellRequest createFarewellRequest) {
        return "GoodBye , " + createFarewellRequest.getName();

    }

    @PostMapping("/addContact")
    public ResponseEntity<String> addContact(@RequestBody Contact contact) {
        if (contactExits(contact.getName())){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Contact is already exists");

        }
        contacts.add(contact);
        return ResponseEntity.status(HttpStatus.CREATED).body("Contact added successfully ");


    }
    private boolean contactExits(String name){
        return contacts.stream().anyMatch(c->c.getName().equals(name));
    }

    @GetMapping("/getContactDetails")
    public ResponseEntity<Object> getContactDetails(@RequestParam String name) {


        Optional<Contact> foundContact = contacts.stream()
                .filter(c -> c.getName().equals(name))
                .findFirst();

        if (foundContact.isPresent()) {
            return ResponseEntity.ok(foundContact.get());
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Contact not found.");
        }
    }


}






//wild card:
// public ResponseEntity<?> getContactDetails(@RequestParam String name) {
//for(int
//
//
//
//        if (foundContact.isPresent()) {
//            return ResponseEntity.ok(foundContact.get());
//        } else {
//            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Contact not found.");
//        }




//other way for the @PostMapping("/addContact"):
// for (int i = 0; i < allContact.size(); i++) {
//        if (allContact.get(i).getEmail() == Contact.getEmail().equals(Contact, getEmail())) {
//            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
//        }
//    }
//        allContact.add(Contact);
//        return new ResponseEntity<>(HttpStatus.CREATED);
//}


//error in the @GetMapping("/getContactDetails"):
// if (createCR!=null && cretCR.getname()!=null && cretCR.getname().equals(name))}