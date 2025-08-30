public class Main {
    public static void main(String[] args){
        TaskManager manager = new TaskManager();
        Task task1 = new Task("Сходить в кино", "Примера фильма");
        Task task2 = new Task("Уборка", "На кухне, в зале");
        manager.createTask(task1);
        manager.createTask(task2);
        Epic epic1 = new Epic("Будут гости", "Подготовить дом");
        manager.createEpic(epic1);
        Subtask sub1 = new Subtask("Купить продукты", "Колбоса, сыр, хлеб");
        Subtask sub2 = new Subtask("Накрыть на стол","Нарезаьб: сыр, колбасу, хлеб");
        manager.createSubtask(sub1);
        manager.createSubtask(sub2);
        System.out.println(manager.getAllTasks());
        System.out.println(manager.getAllEpics());
        System.out.println(manager.getAllSubtasks());
        sub1.setStatus(Status.DONE);
        manager.createSubtask(sub1);
        System.out.println(manager.getEpicId(epic1.getId()));
    }
}