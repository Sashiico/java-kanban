import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class EpicTest {

    @Test
    void epicCannotContainItself() {
        Epic epic = new Epic("Epic", "Self-check");
        epic.setId(1);
        epic.addSubtask(1);
        assertFalse(epic.getSubtaskIds().contains(epic.getId()), "Эпик не должен содержать себя в списке подзадач");
    }
}

