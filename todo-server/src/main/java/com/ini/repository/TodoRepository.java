package com.ini.repository;

import com.ini.model.TodoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

// JpaRepository 상속
// JpaRepository의 generic으로 <Table과 연결될 객체, 해당 객체의 id에 해당하는 field type> 사용
@Repository
public interface TodoRepository extends JpaRepository<TodoEntity, Long> {
}
