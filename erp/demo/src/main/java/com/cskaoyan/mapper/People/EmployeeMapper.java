package com.cskaoyan.mapper.People;

import com.cskaoyan.bean.People.Department;
import com.cskaoyan.bean.People.Employee;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface EmployeeMapper {
    Employee[] getEmployees();

    Employee selectEmployeeById(@Param("deviceKeeperId") String deviceKeeperId);

    List<Employee> findAllEmployees(@Param("rows") int rows, @Param("offset") int offset);

    int findEmployeeTotal();

    Department getDepartmentData(@Param("id") String id);

    int employeeUpdateAll(Employee employee);

    int insertEmployee(Employee employee);

    void employeeDeleteBatch(String id);

    List<Employee> searchEmployeeByEmployeeId(String employeeId);

    List<Employee> searchEmployeeByEmployeeName(String employeeName);

    List<Employee> searchEmployeeByDepartmentName(String departmentName);
}
