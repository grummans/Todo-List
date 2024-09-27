package com.dropchat.todo_list.converter.mapper;

import com.dropchat.todo_list.converter.request.TaskRequestEntity;
import com.dropchat.todo_list.converter.response.TaskResponseEntity;
import com.dropchat.todo_list.entity.TaskEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface EntityMapper {

    TaskEntity toTaskEntity(TaskRequestEntity request);
    TaskResponseEntity toTaskResponseEntity(TaskEntity task);
}
