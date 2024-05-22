package com.example.StudentMarks.EmployeeController;

import com.example.StudentMarks.domain.Employee;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.util.*;

@Controller
public class EmployeeController {

    private List<Employee> employees = new ArrayList<>();

    @GetMapping("/employees")
    public String getEmployees(Model model) {

        TreeMap<String, Integer> ListPosition = new TreeMap<>();
        TreeMap<String, Integer> ListAge = new TreeMap<>();
        List<String> countbyAge = new ArrayList<>();
        int ran1 = 0;
        int ran2 = 0;
        int ran3 = 0;
        int ran4 = 0;

        for (Employee emp : employees) {
            String position = emp.getPosition();

            ListPosition.put(position, ListPosition.getOrDefault(position, 0) + 1);

            ListAge.put(position, ListAge.getOrDefault(position, 0) + emp.getAge());
            if (emp.getAge() < 20) {
                ran1++;
            } else if (emp.getAge() >= 20 && emp.getAge() <= 40) {
                ran2++;
            } else if (emp.getAge() > 40 && emp.getAge() <= 60) {
                ran3++;
            } else {
                ran4++;
            }
        }

        countbyAge.add("Age: " + "<20" + "; Count of employees: " + ran1);
        countbyAge.add("Age: " + "20-40" + "; Count of employees: " + ran2);
        countbyAge.add("Age: " + "40-60" + "; Count of employees: " + ran3);
        countbyAge.add("Age: " + "60+" + "; Count of employees: " + ran4);

        List<Map.Entry<String, Integer>> sortedList = new ArrayList<>(ListPosition.entrySet());
        Collections.sort(sortedList, (e1, e2) -> e2.getValue().compareTo(e1.getValue()));

        List<String> resultList = new ArrayList<>();

        for (Map.Entry<String, Integer> tmp : sortedList) {
            String position = tmp.getKey();
            int count = tmp.getValue();
            int age = ListAge.get(position);
            int averageAge = age / count;
            resultList.add("Position: " + position + "; Count: " + count + "; Average Age: " + averageAge);
        }

        model.addAttribute("employees", employees);
        model.addAttribute("results", resultList);
        model.addAttribute("countbyage", countbyAge);
        return "employees";
    }

    @PostMapping("/employees/add")
    public String addEmployee(@RequestParam String a, @RequestParam int b, @RequestParam String c) {
        employees.add(new Employee(a, b, c));
        data();
        return "redirect:/employees";
    }

    @PostMapping("/employees/remove/{index}")
    public String removeEmployee(@PathVariable int index) {
        try {
            employees.remove(index);
        }
        catch (NullPointerException e){
        }
        data();
        return "redirect:/employees";
    }

    public void data(){
        try {
//            BufferedWriter bw = new BufferedWriter(new FileWriter("C:\\Users\\honky\\Desktop\\test.txt"));
            BufferedWriter bw = new BufferedWriter(new FileWriter("data.txt"));
            for (Employee employee : employees) {
                bw.write(employee.getName() + ";" + employee.getAge() + ";" + employee.getPosition());
                bw.newLine(); // Add newline after each employee entry
            }
            bw.close();
        } catch (Exception ex) {
            System.out.println("");
        }
    }

}
