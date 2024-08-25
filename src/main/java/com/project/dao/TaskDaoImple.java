package com.project.dao;

import java.util.List;

import javax.management.Query;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.project.entity.Task;

@Repository
public class TaskDaoImple implements TaskDao {
	
	@Autowired 
	private SessionFactory factory;

	@Override
	public String createTask(Task task) {
		Session session =null;
		try {
			session = factory.openSession();
			session.save(task);
			session.beginTransaction().commit();
			return "Task created";
		} catch (Exception e) {
			e.printStackTrace();
		}
		finally {
			
		}
		return null;
	}

	@Override
	public List<Task> getAllTasks() {
		Session session =null;
		try {
			session = factory.openSession();
			Criteria criteria = session.createCriteria(Task.class);
			List list = criteria.list();
			return list;
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		finally {
			
		}
		return null;
	}

	@Override
	public Task getTaskById(long id) {
		Session session =null;
		try {
			session = factory.openSession();
			Task task = session.get(Task.class, id);
			return task;
		} catch (Exception e) {
			e.printStackTrace();
		}
		finally {
			
		}
		return null;
		
	}
	@Override
	public String updateTask(long id,Task task) {
		Session session =null;
		try {
			session = factory.openSession();
			session.update(task);
			session.beginTransaction().commit();
			return "Task updated";
		} catch (Exception e) {
			e.printStackTrace();
		}
		finally {
			
		}
		return null;
	}

	@Override
	public String deleteTaskById(long id) {
		Session session =null;
		try {
			session = factory.openSession();
			Task task = session.get(Task.class, id);
			session.delete(task);
			session.beginTransaction().commit();
			return "Task deleted";
		} catch (Exception e) {
			e.printStackTrace();
		}
		finally {
			
		}
		return null;
	}

	@Override
	public Task getTaskByName(String title) {
		Session session = null;
        Task task = null;

        try {
            session = factory.openSession(); // Open a new session
            session.beginTransaction(); // Begin transaction

            String hql = "FROM Task WHERE title = :title";
            org.hibernate.query.Query<Task> query = session.createQuery(hql, Task.class);
            query.setParameter("title", title);
            List<Task> tasks = query.list();

            // Assuming title is unique, return the first result (or null if no match is found)
            if (!tasks.isEmpty()) {
                task = tasks.get(0);
            }

            session.getTransaction().commit(); // Commit the transaction
        } catch (Exception e) {
            if (session != null) {
                session.getTransaction().rollback(); // Rollback in case of error
            }
            e.printStackTrace();
        } finally {
            if (session != null) {
                session.close(); // Always close the session
            }
        }

        return task;
	}

	@Override
	public List<Task> filterTask(String status, String priority, String dueDate) {
		Session session = factory.openSession();
        List<Task> tasks = null;
        
        try {
            String hql = "FROM Task t WHERE t.status = :status AND t.priority = :priority AND t.due_date = :due_date";
            org.hibernate.query.Query<Task> query = session.createQuery(hql, Task.class);
            query.setParameter("status", status);
            query.setParameter("priority", priority);
            query.setParameter("due_date", dueDate);
            tasks = query.list();
        } finally {
            session.close();
        }

        return tasks;
	}

}
