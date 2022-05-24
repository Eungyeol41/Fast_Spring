package com.ini.controller;

import com.ini.model.TodoResponse;
import com.ini.service.TodoService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

// CORS 오류를 방지하기 위해서
@CrossOrigin
@AllArgsConstructor
@RestController
@RequestMapping("/")
public class TodoController {

	private final TodoService todoService;

	@PostMapping
	public ResponseEntity<TodoResponse> create() {
		System.out.println("CREATE");
		return null;
	}

	@GetMapping("{id}")
	public ResponseEntity<TodoResponse> readOne() {
		System.out.println("READ ONE");
		return null;
	}

	@GetMapping
	public ResponseEntity<TodoResponse> readAll() {
		System.out.println("READ ALL");
		return null;
	}

	@PatchMapping
	public ResponseEntity<TodoResponse> update() {
		System.out.println("UPDATE");
		return null;
	}

	@DeleteMapping("{id}")
	public ResponseEntity<?> deleteOne() {
		System.out.println("DELETE ONE");
		return null;
	}

	@DeleteMapping("{id}")
	public ResponseEntity<?> deleteAll() {
		System.out.println("DELETE ALL");
		return null;
	}

}
