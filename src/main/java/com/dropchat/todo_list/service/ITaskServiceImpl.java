package com.dropchat.todo_list.service;

import com.dropchat.todo_list.converter.mapper.EntityMapper;
import com.dropchat.todo_list.converter.request.TaskRequestEntity;
import com.dropchat.todo_list.converter.response.TaskResponseEntity;
import com.dropchat.todo_list.entity.TaskEntity;
import com.dropchat.todo_list.repository.TaskRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class ITaskServiceImpl implements TaskService{

    private final TaskRepository taskRepository;
    private final EntityMapper mapper;
    @Override
    @Transactional
    public TaskResponseEntity createTask(TaskRequestEntity request) {

        TaskEntity task = mapper.toTaskEntity(request);
        task.setTitle(request.getTitle());
        task.setDescription(request.getDescription());
        taskRepository.save(task);

        return mapper.toTaskResponseEntity(task);
    }

}
