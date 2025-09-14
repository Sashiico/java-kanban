public class Main {
    public static void main(String[] args) {
        TaskManager manager = Managers.getDefault();
        Task task1 = new Task("Сходить в кино", "Примера фильма");
        Task task2 = new Task("Уборка", "На кухне, в зале");
        manager.createTask(task1);
        manager.createTask(task2);
        Epic epic1 = new Epic("Будут гости", "Подготовить дом");
        manager.createEpic(epic1);
        Subtask sub1 = new Subtask("Купить продукты", "Колбоса, сыр, хлеб");
        Subtask sub2 = new Subtask("Накрыть на стол", "Нарезать: сыр, колбасу, хлеб");
        manager.createSubtask(sub1);
        manager.createSubtask(sub2);

        //_______________________________
        manager.getTaskId(task1.getId());
        printAllTasks(manager);
        manager.getEpicId(epic1.getId());
        printAllTasks(manager);
        manager.getSubtaskById(sub1.getId());
        printAllTasks(manager);
        manager.getTaskId(task2.getId());
        printAllTasks(manager);


    }
    private static void printAllTasks(TaskManager manager) {
        System.out.println("Задачи:");
        for (Task task : manager.getAllTasks()) {
            System.out.println(task);
        }
        System.out.println("Эпики:");
        for (Task epic : manager.getAllEpics()) {
            System.out.println(epic);

            for (Task task : manager.getSubtasksOfEpic(epic.getId())) {
                System.out.println("--> " + task);
            }
        }
        System.out.println("Подзадачи:");
        for (Task subtask : manager.getAllSubtasks()) {
            System.out.println(subtask);
        }

        System.out.println("История:");
        for (Task task : manager.getHistory()) {
            System.out.println(task);
        }
    }
}