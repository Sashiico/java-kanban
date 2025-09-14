import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
class ManagersTest {

    @Test
    void managersReturnInitializedInstances() {
        TaskManager taskManager = Managers.getDefault();
        HistoryManager historyManager = Managers.getDefaultHistory();

        assertNotNull(taskManager, "Managers.getDefault() должен возвращать рабочий объект");
        assertNotNull(historyManager, "Managers.getDefaultHistory() должен возвращать рабочий объект");
    }
}

