package com.dropchat.todo_list.service;

import com.dropchat.todo_list.converter.mapper.EntityMapper;
import com.dropchat.todo_list.converter.request.TaskRequestEntity;
import com.dropchat.todo_list.converter.response.TaskResponseEntity;
import com.dropchat.todo_list.entity.TaskEntity;
import com.dropchat.todo_list.repository.TaskRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
public class TaskServiceImpl implements TaskService{

    private final TaskRepository taskRepository;
    private final EntityMapper mapper;
    @Override
    @Transactional
    public TaskResponseEntity createTask(TaskRequestEntity request) {

        if (request.getTitle() == null || request.getTitle().isEmpty()) {
            throw new IllegalArgumentException("Task title cannot be null or empty");
        }
        TaskEntity task = mapper.toTaskEntity(request);
        task.setTaskTitle(request.getTitle());
        task.setTaskDescription(request.getDescription());
        task.setUserId(1);
        task.setCreateAt(LocalDateTime.now().toString());
        taskRepository.save(task);

        return mapper.toTaskResponseEntity(task);
    }

}
