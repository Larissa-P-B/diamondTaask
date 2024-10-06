package br.com.fiap.diamondTaask.task.dto;

import br.com.fiap.diamondTaask.task.Task;

import java.time.LocalDateTime;
import java.util.UUID;

public record TaskUpdateRequest(
        UUID id,
        String titulo,
        String descricao,
        LocalDateTime data
) {
    public static TaskUpdateRequest from(Task task) {
        return new TaskUpdateRequest(
                task.getId(),
                task.getTitulo(),
                task.getDescricao(),
                task.getDataEntrega()
        );
    }


}
