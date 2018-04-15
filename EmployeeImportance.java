package com.leetcode;

import com.leetcode.elements.Employee;

import java.util.HashMap;
import java.util.List;

/**
 * Create by WhiteBugs .
 */
public class EmployeeImportance {

    //690. Employee Importance
    //https://leetcode.com/problems/employee-importance/description/

    public int getImportance(List<Employee> employees, int id) {
        if (employees == null && employees.size() == 0)
            return 0;
        HashMap<Integer, Employee> list = new HashMap<>();
        for (Employee item : employees) {
            list.put(item.id, item);
        }
        return getImportance(list, id);
    }

    private int getImportance(HashMap<Integer, Employee> employees, int id) {
        Employee employee = employees.get(id);
        int importance = employee.importance;
        if (employee.subordinates != null && employee.subordinates.size() != 0) {
            for (int ids : employee.subordinates) {
                importance += getImportance(employees, ids);
            }
        }
        return importance;
    }
}
