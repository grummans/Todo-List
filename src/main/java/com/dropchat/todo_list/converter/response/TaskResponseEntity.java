package com.dropchat.todo_list.converter.response;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class TaskResponseEntity {
    private String title;
    private String description;
}
