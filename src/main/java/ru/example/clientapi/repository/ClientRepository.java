package ru.example.clientapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.example.clientapi.entity.Client;

@Repository
public interface ClientRepository extends JpaRepository<Client, Integer> {
}
