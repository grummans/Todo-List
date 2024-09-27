package com.dropchat.todo_list.controller;

import com.dropchat.todo_list.converter.request.TaskRequestEntity;
import com.dropchat.todo_list.converter.response.TaskResponseEntity;
import com.dropchat.todo_list.service.ITaskServiceImpl;
import com.dropchat.todo_list.service.TaskService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1")
@RequiredArgsConstructor
public class TaskController {

    private final TaskService taskService;
    @PostMapping("/task/create")
    public TaskResponseEntity createTask(@RequestBody TaskRequestEntity request){
        TaskResponseEntity response = taskService.createTask(request);
        return response;
    }
}
