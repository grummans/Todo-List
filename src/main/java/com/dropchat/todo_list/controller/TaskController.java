package com.dropchat.todo_list.controller;

import com.dropchat.todo_list.converter.request.TaskRequestEntity;
import com.dropchat.todo_list.converter.response.TaskResponseEntity;
import com.dropchat.todo_list.service.TaskService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
@RequiredArgsConstructor
public class TaskController {

    private final TaskService taskService;

    /**
     * Endpoint to create a new task.
     *
     * @param request the task request entity containing task details
     * @return the created task response entity
     */
    @PostMapping("/task/create")
    public TaskResponseEntity createTask(@RequestBody TaskRequestEntity request){
        TaskResponseEntity response = taskService.createTask(request);
        return response;
    }

    @GetMapping("/task/list")
    public List<TaskResponseEntity> getListTask() {
        return taskService.getListTask();
    }
}
