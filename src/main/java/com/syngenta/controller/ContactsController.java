package com.syngenta.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.syngenta.entity.Contact;
import com.syngenta.service.ContactRepository;

import antlr.collections.List;

public class ContactsController {

	@Autowired
	ContactRepository repository;

	@PostMapping("/add")
	public String add(@ModelAttribute Contact contact, Model m) {
		System.out.println(" contact to save = " + contact.getName());
		if (contact.getId() == 0) {
			repository.save(contact);
		} else {
			update(contact);
		}

		m.addAttribute("contact", new Contact());
		java.util.List<Contact> contacts = repository.findAll();
//Collections.sort(contacts);
		System.out.println(" contacts = " + contacts.size());
		m.addAttribute("contacts", contacts);
		return "contacts";
	}

	@GetMapping("/add")
	public String findAllContacts(Model model) {
		System.out.println(" findAllContacts in db ");
		model.addAttribute("contact", new Contact());
		java.util.List<Contact> contacts = repository.findAll();
		System.out.println(" contacts = " + contacts.size());
		model.addAttribute("contacts", contacts);
		return "contacts";
	}

public void update(Contact c) {
System.out.println(" Update called with ID = "+ c.getId());
repository.save©;
}

@RequestMapping("/delete")
public String delete(@RequestParam("id") int id, Model model) {
System.out.println(" Delete called with ID = "+ id);
Contact c = repository.findOne(id);
repository.delete©;

model.addAttribute("contact", new Contact());
List<Contact> contacts = repository.findAll();
System.out.println(" contacts = "+ contacts.size());
model.addAttribute("contacts", contacts);
return "contacts";
}

}