package com.fixdecode.departmentservice.department;

import com.fixdecode.departmentservice.util.DepartmentNotFoundException;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
@Slf4j
public class DepartmentService {
    private final DepartmentRepository departmentRepository;

    public List<Department> getAllDepartment(){
        log.info("Fetching all departments");
        return departmentRepository.findAll()
                .stream().collect(Collectors.toList());
    }

    public Department getDepartment(String id){
        log.info("searching for a departments");
        return departmentRepository.findById(id)
                .orElseThrow(()->new DepartmentNotFoundException("Department not found"));
    }

    public Department addDepartment(Department department){
        log.info("Saving a departments");
        return departmentRepository.save(department);
    }
}
