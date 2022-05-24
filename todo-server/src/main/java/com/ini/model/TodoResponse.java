package com.ini.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
// 응답을 받는 model.. class..?
public class TodoResponse {

    private Long id;
    private String title;
    private Long order;
    private Boolean completed;
    private String url;

    // TodoEntity를 parameter로 받는 생성자 추가
    public TodoResponse(TodoEntity todoEntity) {
        this.id = todoEntity.getId();
        this.title = todoEntity.getTitle();
        this.id = todoEntity.getOrder();
        this.completed = todoEntity.getCompleted();

        // url은 따로 TodoEntity에 있는 칼럼이 아니기 때문에 하드코딩으로 임의로 만들어 줌.
        this.url = "http://localhost:8080/" + this.id;
    }

}
