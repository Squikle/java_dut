package com.company.springproject.controllers;

import com.company.springproject.dal.Instructor;
import com.company.springproject.repositories.CommonRepository;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/instructor")
@AllArgsConstructor
public class InstructorController {
    private final CommonRepository<Instructor> repository;

    @PostMapping
    public ResponseEntity<Integer> add(@RequestBody Instructor entity){
        return ResponseEntity.ok(repository.save(entity).Id);
    }

    @GetMapping
    public ResponseEntity<Instructor> get(@RequestParam Integer entityId){
        return ResponseEntity.ok(repository.findById(entityId).orElseThrow());
    }

    @GetMapping("/getAll")
    public ResponseEntity<List<Instructor>> getAll(){
        return ResponseEntity.ok(repository.findAll());
    }

    @DeleteMapping()
    public ResponseEntity<Integer> delete(@RequestParam Integer entityId){
        repository.deleteById(entityId);
        return ResponseEntity.ok(entityId);
    }

    @PatchMapping()
    public ResponseEntity<Integer> update(@RequestBody Instructor entity){
        var result = repository.save(entity);
        return ResponseEntity.ok(result.Id);
    }
}
