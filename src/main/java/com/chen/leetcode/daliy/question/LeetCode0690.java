package com.chen.leetcode.daliy.question;

import com.chen.leetcode.dto.Employee;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * <a href="https://leetcode.cn/problems/employee-importance/description/?envType=daily-question&envId=2024-08-26">
 *     690. 员工的重要性
 * </a>
 *
 * @author chenbjf
 * @since 2024-08-26 16:11
 */
public class LeetCode0690 {

    public int getImportance(List<Employee> employees, int id) {
        Map<Integer, Employee> map = new HashMap<>();
        employees.forEach(a -> map.put(a.id, a));
        List<Employee> list = new ArrayList<>();
        list.add(map.get(id));
        return calculate(list, map, 0);
    }

    private int calculate(List<Employee> employees, Map<Integer, Employee> map,  int count) {
        if (employees == null || employees.size() <= 0) {
            return count;
        }
        List<Employee> childEmployee = new ArrayList<>();
        for (Employee emp : employees) {
            count+= emp.importance;
            emp.subordinates.forEach(a -> childEmployee.add(map.get(a)));
        }
        return calculate(childEmployee, map, count);
    }

}
