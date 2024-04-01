package net.samitkumar.allinone.models;

import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.PersistenceCreator;
import org.springframework.data.annotation.ReadOnlyProperty;
import org.springframework.data.annotation.Transient;
import org.springframework.data.relational.core.mapping.MappedCollection;
import org.springframework.data.relational.core.mapping.Table;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;
import java.util.Set;

@Table("employees")
public record Employee(
        @Id Integer employeeId,
        String firstName,
        String lastName,
        String email,
        String phoneNumber,
        @DateTimeFormat(pattern="yyyy-MM-dd") LocalDate hireDate,
        Integer jobId,
        Double salary,
        Integer managerId,
        Integer departmentId,
        @MappedCollection(idColumn = "employee_id") EmployeeHistory employeeHistory,
        @MappedCollection(idColumn = "employee_id") Set<EmployeeDocument> employeeDocuments,
        @Transient Object file
        ) {
    @PersistenceCreator
    public Employee(Integer employeeId, String firstName, String lastName, String email, String phoneNumber, LocalDate hireDate, Integer jobId, Double salary, Integer managerId, Integer departmentId, EmployeeHistory employeeHistory, Set<EmployeeDocument> employeeDocuments) {
        this(employeeId, firstName, lastName, email, phoneNumber, hireDate, jobId, salary, managerId, departmentId, employeeHistory, employeeDocuments, null);
    }
}
