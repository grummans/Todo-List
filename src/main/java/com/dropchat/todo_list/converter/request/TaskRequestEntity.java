package com.dropchat.todo_list.converter.request;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class TaskRequestEntity {
    private String title;
    private String description;
}
