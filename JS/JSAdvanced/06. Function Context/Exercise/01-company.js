"use strict";

class Company {
    constructor() {
        this.departments = [];
    }

    addEmployee(username, salary, position, department) {
        if (!username || !salary || !position || !department) {
            throw new Error('Invalid input!');
        }

        if (salary < 0) {
            throw new Error('Invalid input!');
        }

        let currDepartment = this.departments.find(dep => dep.name === department);

        if (currDepartment === undefined) {
            currDepartment = {
                name: department,
                employees: [],
                averageSalary: function () {
                    return this.employees.reduce((acc, emp) => acc += emp.salary, 0) / this.employees.length;
                }
            }
            this.departments.push(currDepartment);
        }

        let employee = {
            name: username,
            salary: salary,
            position: position
        }

        currDepartment.employees.push(employee);
        return `New employee is hired. Name: ${username}. Position: ${position}`;
    }

    bestDepartment() {
        //find the department with the highest average salary
        let department = this.departments.reduce((max, currDep) => currDep.averageSalary() > max.averageSalary() ? max = currDep : max, this.departments[0]);

        //sort employees [] by salary desc and by name asc
        let departmentEmployees = department.employees;

        departmentEmployees.sort((emp1, emp2) => {
            let sort = emp2.salary - emp1.salary;

            if (sort === 0) {
                sort = emp1.name.localeCompare(emp2.name);
            }

            return sort;
        });

        let result = (`Best Department is: ${department.name}\n`);
        result += (`Average salary: ${department.averageSalary().toFixed(2)}\n`);
        result += departmentEmployees.reduce((acc, emp) => acc += `${emp.name} ${emp.salary} ${emp.position}\n`, "");

        return result.trim();
    }
}

let c = new Company();
c.addEmployee("Stanimir", 2000, "engineer", "Construction");
c.addEmployee("Pesho", 1500, "electrical engineer", "Construction");
c.addEmployee("Slavi", 500, "dyer", "Construction");
c.addEmployee("Stan", 2000, "architect", "Construction");
c.addEmployee("Stanimir", 1200, "digital marketing manager", "Marketing");
c.addEmployee("Pesho", 1000, "graphical designer", "Marketing");
c.addEmployee("Gosho", 1350, "HR", "Human resources");
console.log(c.bestDepartment());