import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class SubtaskTest {
    @Test
    void subtaskCannotBeItsOwnEpic() {
        Subtask subtask = new Subtask("TestSub", "Check self epic");
        subtask.setId(10);
        subtask.setEpicId(10);


        assertNotEquals(subtask.getId(), subtask.getEpicId(),
                "Подзадача не может быть своим же эпиком");
    }
}