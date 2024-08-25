package com.project.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class TaskDTO {
	
	private Long task_id;
	private String title;
	private String description;
	private String status;
	private String priority;
	private String due_date;
	private String created_at;
	private String updated_at;
	private Long u_id;

}
