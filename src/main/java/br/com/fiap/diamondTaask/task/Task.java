package br.com.fiap.diamondTaask.task;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Data
@Table(name = "tarefas")
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Task {
    @Id
    UUID id = UUID.randomUUID();
    String titulo;
    String descricao;
    LocalDateTime dataEntrega;
    LocalDateTime createdAt;
    LocalDateTime updatedAt;

    @Enumerated(EnumType.STRING)
    Prioridade prioridade;

    Integer prazo;


}
