import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;


class HistoryManagerTest {
    private HistoryManager historyManager;

    @BeforeEach
    void setUp() {
        historyManager = Managers.getDefaultHistory(); // или new InMemoryHistoryManager()
    }
@Test
    void historyKeepsPreviousVersionsAndLimitsSize() {
        // Добавляем 12 задач
        for (int i = 1; i <= 12; i++) {
            Task task = new Task("Задача " + i, "Описание " + i);
            historyManager.add(task);
        }

        List<Task> history = historyManager.getHistory();

        // Проверяем, что размер истории не больше 10
        assertEquals(10, history.size(), "История не должна превышать 10 элементов");

        // Проверяем, что в истории остались последние 10 задач (3-12)
        for (int i = 0; i < 10; i++) {
            Task task = history.get(i);
            int expectedNumber = i + 3; // задачи 3-12
            assertEquals("Задача " + expectedNumber, task.getTitle(), "Название задачи неверно");
            assertEquals("Описание " + expectedNumber, task.getDescription(), "Описание задачи неверно");
        }

        // Проверка неизменности данных
        Task firstTask = history.get(0);
        firstTask.setStatus(Status.DONE); // Меняем статус после добавления в историю
        assertNotEquals(Status.DONE, history.get(1).getStatus(), "Статус других задач не должен измениться");
    }
    
}
