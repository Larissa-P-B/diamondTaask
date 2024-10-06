package br.com.fiap.diamondTaask.task.dto;

import br.com.fiap.diamondTaask.task.Task;

import java.time.LocalDateTime;
import java.util.UUID;

public record TaskRequest(
        String titulo,
        String descricao,
        LocalDateTime data
) {

    public Task toModel() {
        return Task.builder()
                .id(UUID.randomUUID())
                .titulo(titulo)
                .descricao(descricao)
                .dataEntrega(data)
                .createdAt(LocalDateTime.now())
                .build();
    }
}

