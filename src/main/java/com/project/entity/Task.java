package com.project.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Task {
	
	@Id
	private Long task_id;
	private String title;
	private String description;
	private String status;
	private String priority;
	private String due_date;
	private String created_at;
	private String updated_at;
	
	@ManyToOne
	@JoinColumn(name = "user_id")
	private User user;

}
