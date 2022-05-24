package com.ini.controller;

import com.ini.model.TodoEntity;
import com.ini.model.TodoRequest;
import com.ini.model.TodoResponse;
import com.ini.service.TodoService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.util.ObjectUtils;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

// CORS 오류를 방지하기 위해서
@CrossOrigin
@AllArgsConstructor
@RestController
@RequestMapping("/")
public class TodoController {

	private final TodoService service;

	@PostMapping
	public ResponseEntity<TodoResponse> create(@RequestBody TodoRequest req) {
		System.out.println("CREATE");

		if (ObjectUtils.isEmpty(req.getTitle()))
				return ResponseEntity.badRequest().build();
		if(ObjectUtils.isEmpty(req.getOrder()))
				req.setOrder(0L);
		if(ObjectUtils.isEmpty(req.getCompleted()))
				req.setCompleted(false);

		TodoEntity result = this.service.add(req);
		return ResponseEntity.ok(new TodoResponse(result));
	}

	@GetMapping("{id}")
	public ResponseEntity<TodoResponse> readOne(@PathVariable Long id) {
		System.out.println("READ ONE");
		TodoEntity result = this.service.searchById(id);
		return ResponseEntity.ok(new TodoResponse(result));
	}

	@GetMapping
	public ResponseEntity<List<TodoResponse>> readAll() {
		System.out.println("READ ALL");
		List<TodoEntity> list = this.service.searchAll();
		List<TodoResponse> response = list.stream().map(TodoResponse::new)
				.collect(Collectors.toList());
		return ResponseEntity.ok(response);
	}

	@PatchMapping("{id}")
	public ResponseEntity<TodoResponse> update(@PathVariable Long id, @RequestBody TodoRequest req) {
		System.out.println("UPDATE");
		TodoEntity result = this.service.updateById(id, req);
		return ResponseEntity.ok(new TodoResponse(result));
	}

	@DeleteMapping("{id}")
	public ResponseEntity<?> deleteOne(@PathVariable Long id) {
		System.out.println("DELETE ONE");
		this.service.deleteById(id);
		return ResponseEntity.ok().build();
	}

	@DeleteMapping
	public ResponseEntity<?> deleteAll() {
		System.out.println("DELETE ALL");
		this.service.deleteAll();
		return ResponseEntity.ok().build();
	}

}
