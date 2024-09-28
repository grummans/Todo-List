package com.dropchat.todo_list.service;

import com.dropchat.todo_list.converter.request.TaskRequestEntity;
import com.dropchat.todo_list.converter.response.TaskResponseEntity;

import java.util.List;

public interface TaskService {
    TaskResponseEntity createTask(TaskRequestEntity request);

    List<TaskResponseEntity> getListTask
}
