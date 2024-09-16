package de.ricardo.javarecapspring;

import lombok.With;

@With
public record Kanban(String id, String description, String status) {
}
