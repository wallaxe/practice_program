package birthdaygreetings;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

public class FileEmployeeReader implements EmployeeReader {
    private String fileName;

    public FileEmployeeReader(String fileName) {

        this.fileName = fileName;
    }

    @Override
    public List<Employee> obtainEmployees() throws EmployeeReaderException {
        List<Employee> employees = new ArrayList<>();

        try{
            BufferedReader in = new BufferedReader(new FileReader(this.fileName));
            String str = "";
            str = in.readLine(); // skip header

            while ((str = in.readLine()) != null) {

                String[] employeeData = str.split(", ");

                Employee employee = new Employee(employeeData[1], employeeData[0],
                        employeeData[2], employeeData[3]);

                employees.add(employee);

            }
            return employees;
        } catch (Exception error) {
            throw new EmployeeReaderException();
        }


    }
}
