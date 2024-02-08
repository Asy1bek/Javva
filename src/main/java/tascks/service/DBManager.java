package tascks.service;

import tascks.entity.TaskEntity;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class DBManager {

    private static List<TaskEntity> taskList = new ArrayList<>();
    private static Long id = 6L;

    static {
        taskList.add(new TaskEntity(1L, "Создать Веб приложение на Java EE", "Нужно создать приложение на Java EE", LocalDate.of(2021, 10, 23)));
        taskList.add(new TaskEntity(2L, "Убраться дома и закупить продукты", "Убраться дома и закупить продукты", LocalDate.of(2021, 10, 25)));
        taskList.add(new TaskEntity(3L, "Выполнить все домашние задания", "Выполнить все домашние задания", LocalDate.of(2021, 10, 28)));
        taskList.add(new TaskEntity(4L, "Записаться на качку", "Записаться на качку", LocalDate.of(2021, 12, 12)));
        taskList.add(new TaskEntity(5L, "Учить Итальянский", "Учить Итальянский", LocalDate.of(2021, 5, 1)));
    }

    public static void create(TaskEntity entity) {
        entity.setId(id++);

        taskList.add(entity);
    }

    public static void update(Long id, TaskEntity entity) {
        for (TaskEntity task : taskList) {
            if (id.equals(task.getId())) {
                task.setName(entity.getName());
                task.setDescription(entity.getDescription());
                task.setDone(entity.isDone());
                break;
            }
        }
    }

    public static List<TaskEntity> findAll() {
        return taskList;
    }

    public static TaskEntity findById(Long id) {
        for (TaskEntity task : taskList) {
            if (id.equals(task.getId())) {
                return task;
            }
        }

        throw new RuntimeException("Task not found with id: " + id);
    }

    // TODO: реализовать удаление таска по айди
    public static void delete(Long id) {
        // ваш код
    }

}