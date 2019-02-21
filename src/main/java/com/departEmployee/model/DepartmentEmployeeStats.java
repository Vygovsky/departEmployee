package com.departEmployee.model;

public class DepartmentEmployeeStats {
    private Department department;
    private int employeeAmount;

    public DepartmentEmployeeStats(Department department) {
        this.department = department;
        this.employeeAmount = department.getEmployees() == null ? 0 : department.getEmployees().size();
    }

    public Department getDepartment() {
        return department;
    }

    public int getEmployeeAmount() {
        return employeeAmount;
    }
}
