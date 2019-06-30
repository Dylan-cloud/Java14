package com.cskaoyan.service.People;

import com.cskaoyan.bean.Page;
import com.cskaoyan.bean.People.Department;
import com.cskaoyan.bean.People.Employee;
import com.cskaoyan.bean.QueryStatus;
import com.cskaoyan.exception.EmployeeException;

public interface EmployeeService {

    Employee[] getEmployees();

    Employee selectEmployeeById(String deviceKeeperId);

    Page findAllEmployees(int page, int rows);

    Department getDepartmentData(String id);

    QueryStatus employeeUpdateAll(Employee employee);

    QueryStatus insertEmployee(Employee employee);

    QueryStatus employeeDeleteBatch(String[] ids) throws EmployeeException;

    Page searchEmployeeByEmployeeId(int page, int rows, String searchValue);

    Page searchEmployeeByEmployeeName(int page, int rows, String searchValue);

    Page searchEmployeeByDepartmentName(int page, int rows, String searchValue);
}
