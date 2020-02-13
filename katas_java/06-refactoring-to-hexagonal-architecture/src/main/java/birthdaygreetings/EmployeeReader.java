package birthdaygreetings;

import java.util.List;

public interface EmployeeReader {
    List<Employee> obtainEmployees() throws EmployeeReaderException;
}
