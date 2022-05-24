package com.ini.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
// Request로 받을 수 있는 칼럼들..?
public class TodoRequest {

    private String title;
    private Long order;
    private Boolean completed;

}
