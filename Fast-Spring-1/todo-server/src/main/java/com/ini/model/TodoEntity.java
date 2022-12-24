package com.ini.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class TodoEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private  String title;

    // order 키워드가 h2database에서 예약어로 사용 중이라서 칼럼명을 따로 지정해줌.
    @Column(name = "todoOrder", nullable = false)
    private  Long order;

    @Column(nullable = false)
    private Boolean completed;
}
