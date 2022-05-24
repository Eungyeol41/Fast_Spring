package com.ini.service;

import com.ini.model.TodoEntity;
import com.ini.model.TodoRequest;
import com.ini.repository.TodoRepository;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
@AllArgsConstructor
public class TodoService {

    private final TodoRepository todoRepository;

    public TodoEntity add(TodoRequest req) {
        TodoEntity todoEntity = new TodoEntity();
        todoEntity.setTitle(req.getTitle());
        todoEntity.setOrder(req.getOrder());
        todoEntity.setCompleted(req.getCompleted());

        return this.todoRepository.save(todoEntity);
    }

    public TodoEntity searchById(Long id) {
        return this.todoRepository.findById(id)
                // Error가 날 경우
                .orElseThrow(()->new ResponseStatusException(HttpStatus.NOT_FOUND));
    }

    public List<TodoEntity> searchAll() {
        return this.todoRepository.findAll();
    }

    public TodoEntity updateById(Long id, TodoRequest req) {
        TodoEntity todoEntity = this.searchById(id);
        if (req.getTitle() != null) {
            todoEntity.setTitle(req.getTitle());
        }
        if (req.getOrder() != null) {
            todoEntity.setOrder(req.getOrder());
        }
        if (req.getCompleted() != null) {
            todoEntity.setCompleted(req.getCompleted());
        }

        return this.todoRepository.save(todoEntity);
    }

    public void deleteById(Long id) {
        this.todoRepository.deleteById(id);
    }

    public void deleteAll() {
        this.todoRepository.deleteAll();
    }
}
