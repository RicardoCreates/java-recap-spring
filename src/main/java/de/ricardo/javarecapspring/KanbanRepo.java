package de.ricardo.javarecapspring;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface KanbanRepo extends MongoRepository<Kanban, String> {
}
