package com.dropchat.todo_list.service;

import com.dropchat.todo_list.converter.mapper.EntityMapper;
import com.dropchat.todo_list.converter.request.TaskRequestEntity;
import com.dropchat.todo_list.converter.response.TaskResponseEntity;
import com.dropchat.todo_list.entity.TaskEntity;
import com.dropchat.todo_list.repository.TaskRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

class TaskServiceImplTest {

    @Mock
    private TaskRepository taskRepository;
    @Mock
    private EntityMapper mapper;
    @InjectMocks
    private TaskServiceImpl taskService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    @DisplayName("createTask should create and return TaskResponseEntity when valid request is given")
    void createTask_HappyPath() {
        TaskRequestEntity request = new TaskRequestEntity();
        request.setTitle("Test Title");
        request.setDescription("Test Description");
        TaskEntity entity = new TaskEntity();
        TaskResponseEntity response = new TaskResponseEntity();

        when(mapper.toTaskEntity(request)).thenReturn(entity);
        when(mapper.toTaskResponseEntity(entity)).thenReturn(response);
        when(taskRepository.save(any(TaskEntity.class))).thenReturn(entity);

        TaskResponseEntity result = taskService.createTask(request);
        assertEquals(response, result);
        verify(taskRepository).save(entity);
    }

    @Test
    @DisplayName("createTask should throw IllegalArgumentException when title is null")
    void createTask_TitleNull_ThrowsException() {
        TaskRequestEntity request = new TaskRequestEntity();
        request.setTitle(null);
        request.setDescription("desc");
        assertThrows(IllegalArgumentException.class, () -> taskService.createTask(request));
    }

    @Test
    @DisplayName("createTask should throw IllegalArgumentException when title is empty")
    void createTask_TitleEmpty_ThrowsException() {
        TaskRequestEntity request = new TaskRequestEntity();
        request.setTitle("");
        request.setDescription("desc");
        assertThrows(IllegalArgumentException.class, () -> taskService.createTask(request));
    }

    @Test
    @DisplayName("getListTask should return mapped list of TaskResponseEntity")
    void getListTask_HappyPath() {
        TaskEntity entity1 = new TaskEntity();
        TaskEntity entity2 = new TaskEntity();
        List<TaskEntity> entities = Arrays.asList(entity1, entity2);
        TaskResponseEntity response1 = new TaskResponseEntity();
        TaskResponseEntity response2 = new TaskResponseEntity();
        when(taskRepository.findAll()).thenReturn(entities);
        when(mapper.toTaskResponseEntity(entity1)).thenReturn(response1);
        when(mapper.toTaskResponseEntity(entity2)).thenReturn(response2);

        List<TaskResponseEntity> result = taskService.getListTask();
        assertEquals(2, result.size());
        assertTrue(result.contains(response1));
        assertTrue(result.contains(response2));
    }

    @Test
    @DisplayName("getListTask should return empty list when no tasks exist")
    void getListTask_EmptyList() {
        when(taskRepository.findAll()).thenReturn(List.of());
        List<TaskResponseEntity> result = taskService.getListTask();
        assertTrue(result.isEmpty());
    }
}

