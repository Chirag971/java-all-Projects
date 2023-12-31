
package Bean;

import Ejb.EmpEJbLocal;
import Entity.Employee;
import java.util.Collection;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;


@Named(value = "empBean")
@RequestScoped
public class empBean {

    @EJB EmpEJbLocal ej;
    
    
    private Employee employee = new Employee();
    private String user;
    private String role;
    private Integer empId;
    
    public empBean() {
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public Integer getEmpId() {
        return empId;
    }

    public void setEmpId(Integer empId) {
        this.empId = empId;
    }
    
    
    
    public Collection<Employee> getAllEmp(){
        return ej.getAllEmp();
    }
    
    public String insert(){
        this.setUser(user);
        this.setRole(role);
        ej.insert(this.user, this.role);
        return "index.xhtml";
    }
    
    public String delete(Integer id){
        ej.delete(id);
        return "index.xhtml";
    }
    
    public String getById(Employee selectedEmp){
        this.employee = selectedEmp;
        return "Update";
    }
    
    public String Update(Integer empid,String user,String role){
        this.setEmpId(empid);
        this.setUser(user);
        this.setRole(role);
        ej.update(this.empId, this.user, this.role);
        return "index.xhtml";
    }
    
    
}
