package ru.example.clientapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.example.clientapi.entity.Contact;
import ru.example.clientapi.entity.ContactType;

import java.util.List;

@Repository
public interface ContactRepository extends JpaRepository<Contact, Integer> {
    List<Contact> findByClientId(int id);
    List<Contact> findByClientIdAndType(int id, ContactType type);
}
