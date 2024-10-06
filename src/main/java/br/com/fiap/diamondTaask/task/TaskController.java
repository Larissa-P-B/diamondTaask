package br.com.fiap.diamondTaask.task;

import br.com.fiap.diamondTaask.task.dto.TaskRequest;
import jakarta.validation.Valid;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.UUID;

@Controller
public class TaskController {

    private final TaskService taskService;

    public TaskController(TaskService taskService) {
        this.taskService = taskService;
    }

    @GetMapping
    public String index(Model model, @RequestParam(defaultValue = "0") int page, @RequestParam(defaultValue = "10") int size) {
        Pageable pageable = PageRequest.of(page, size);
        Page<Task> tasks = taskService.findAll(pageable);
        model.addAttribute("tasks", tasks);
        model.addAttribute("currentPage", page);
        return "index";
    }


    @GetMapping("/new")
    public String showCreateTaskForm(Model model) {
        model.addAttribute("taskRequest", new TaskRequest(null, null, null));
        return "create";
    }

    @PostMapping("/task")
    public String create(@Valid TaskRequest taskRequest, BindingResult result, RedirectAttributes redirectAttributes) {
        if(result.hasErrors()) return "create";
        var task = taskRequest.toModel();
        taskService.create(task);
        redirectAttributes.addFlashAttribute("successMessage", "Tarefa cadastrada com sucesso!");
        return "redirect:/";
    }


    @DeleteMapping("/task/{id}")
    public String delete(@PathVariable UUID id, RedirectAttributes redirectAttributes) {
        taskService.delete(id);
        redirectAttributes.addFlashAttribute("successMessage", "Tarefa apagada com sucesso!");
        return "redirect:/";
    }
}
