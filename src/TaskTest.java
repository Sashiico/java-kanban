import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TaskTest {

    @Test
    void tasksWithSameIdShouldBeEqual() {
        Task task1 = new Task("Task 1", "Desc 1");
        Task task2 = new Task("Task 2", "Desc 2");

        task1.setId(1);
        task2.setId(1);

        assertEquals(task1, task2, "Задачи с одинаковым id должны быть равны");
    }

    @Test
    void differentTaskTypesWithSameIdShouldBeEqual() {
        Epic epic = new Epic("Epic Task", "Epic description");
        Subtask subtask = new Subtask("Subtask", "Subtask description");

        epic.setId(100);
        subtask.setId(100);
        assertEquals(epic, subtask, "Наследники Task с одинаковым id должны быть равны");
    }
}