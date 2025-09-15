import java.util.List;

public interface TaskManager {
    //Task-----------------------------------
    void createTask(Task task);

    void updateTask(Task task);

    Task getTaskId(int id);

    List<Task> getAllTasks();

    void deleteAllTasks();

    void deleteTaskById(int id);

    List<Task> getHistory();

    //Epic-----------------------------------
    void createEpic(Epic epic);

    void updateEpic(Epic epic);

    Epic getEpicId(int id);

    List<Epic> getAllEpics();

    void deleteAllEpics();

    void deleteEpicBuId(int id);

    //Subtask-----------------------------------
    void createSubtask(Subtask subtask);

    void updayeSubtask(Subtask subtask);

    Subtask getSubtaskById(int id);

    List<Subtask> getAllSubtasks();

    List<Subtask> getSubtasksOfEpic(int epicId);

    void deleteAllSubtasks();

    void deleteSubtaskById(int id);


}
