
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
class InMemoryTaskManagerTest {
    private TaskManager manager;
    @BeforeEach
    void setUp() {
        manager = Managers.getDefault();
    }
    @Test
    void addAndFindDifferentTasksById() {
        Task task = new Task("Task", "Desc");
        Epic epic = new Epic("Epic", "Desc");
        Subtask subtask = new Subtask("Sub", "Desc");

        manager.createTask(task);
        manager.createEpic(epic);
        subtask.setEpicId(epic.getId());
        manager.createSubtask(subtask);

        assertEquals(task, manager.getTaskId(task.getId()), "Не найден Task по id");
        assertEquals(epic, manager.getEpicId(epic.getId()), "Не найден Epic по id");
        assertEquals(subtask, manager.getSubtaskById(subtask.getId()), "Не найден Subtask по id");
    }
    @Test
    void manuallySetIdDoesNotConflictWithGeneratedId() {
        Task task1 = new Task("T1", "D1");
        task1.setId(100);
        manager.createTask(task1);

        Task task2 = new Task("T2", "D2");
        manager.createTask(task2);

        assertNotEquals(task1.getId(), task2.getId(),
                "Идентификаторы задачи не должны конфликтовать");
    }
    @Test
    void taskRemainsUnchangedAfterAddingToManager() {
        Task task = new Task("Original", "Description");
        manager.createTask(task);

        Task saved = manager.getTaskId(task.getId());


        assertEquals(task.getDescription(), saved.getDescription());
        assertEquals(task.getStatus(), saved.getStatus());
    }

}