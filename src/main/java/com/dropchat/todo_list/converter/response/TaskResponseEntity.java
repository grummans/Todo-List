package com.dropchat.todo_list.converter.response;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class TaskResponseEntity {
    private int taskId;
    private String taskTitle;
    private String taskDescription;
}
