package com.andhraempower.repository;

import com.andhraempower.entity.Contact;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ContactUsRepository extends JpaRepository<Contact, Long> {
}
