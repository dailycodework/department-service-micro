package com.fixdecode.departmentservice.department;

import com.fixdecode.departmentservice.util.ResponseMessage;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

import static org.springframework.http.HttpStatus.CREATED;
import static org.springframework.http.HttpStatus.OK;

@RestController
@AllArgsConstructor
@RequestMapping("/api/departments")
public class DepartmentController {
    private final DepartmentService departmentService;

    @GetMapping
    public ResponseEntity<ResponseMessage> getAllDepartments() {
        return ResponseEntity.ok(
                ResponseMessage.builder()
                        .data(Map.of("Departments", departmentService.getAllDepartment()))
                        .message("Fetching departments")
                        .status(OK)
                        .statusCode(OK.value())
                        .build());

    }
    @GetMapping("/{id}")
    public ResponseEntity<ResponseMessage> getDepartment(@PathVariable("id") String id) {
        return ResponseEntity.ok(
                ResponseMessage.builder()
                        .data(Map.of("Department", departmentService.getDepartment(id)))
                        .message("Fetching department")
                        .status(OK)
                        .statusCode(OK.value())
                        .build());
    }

    @PostMapping
    public ResponseEntity<ResponseMessage> addDepartment(@RequestBody Department department) {
        return ResponseEntity.ok(
                ResponseMessage.builder()
                        .data(Map.of("Departments", departmentService.addDepartment(department)))
                        .message("Saving department")
                        .status(CREATED)
                        .statusCode(CREATED.value())
                        .build());
    }

}
