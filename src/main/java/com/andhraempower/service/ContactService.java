package com.andhraempower.service;

import com.andhraempower.dto.ContactRequestDto;
import com.andhraempower.entity.Contact;
import com.andhraempower.repository.ContactRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ContactService {

    @Autowired
    private ContactRepository contactRepository;

    public void saveContact(ContactRequestDto contactRequestDto) {
        Contact contact = new Contact();
        contact.setName(contactRequestDto.getName());
        contact.setEmail(contactRequestDto.getEmail());
        contact.setSubject(contactRequestDto.getSubject());
        contact.setMessage(contactRequestDto.getMessage());
        contactRepository.save(contact);
    }
}
