package project.testData;

import java.util.Objects;

public class User {
    public User(String firstName,
                String lastName,
                String email,
                String age,
                String salary,
                String department) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.age = age;
        this.salary = salary;
        this.department = department;
    }

    private String firstName;
    private String lastName;
    private String email;
    private String age;
    private String salary;
    private String department;


    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getEmail() {
        return email;
    }

    public String getAge() {
        return age;
    }

    public String getSalary() {
        return salary;
    }

    public String getDepartment() {
        return department;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return Objects.equals(firstName, user.getFirstName()) && Objects.equals(lastName, user.getLastName()) && Objects.equals(email, user.getEmail()) && Objects.equals(age, user.getAge()) && Objects.equals(salary, user.getSalary()) && Objects.equals(department, user.getDepartment());
    }

}
