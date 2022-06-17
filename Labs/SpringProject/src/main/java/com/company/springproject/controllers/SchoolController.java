package com.company.springproject.controllers;

import com.company.springproject.dal.School;
import com.company.springproject.repositories.CommonRepository;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/payment")
@AllArgsConstructor
public class SchoolController {
    private final CommonRepository<School> repository;

    @PostMapping
    public ResponseEntity<Integer> add(@RequestBody School entity){
        return ResponseEntity.ok(repository.save(entity).Id);
    }

    @GetMapping
    public ResponseEntity<School> get(@RequestParam Integer entityId){
        return ResponseEntity.ok(repository.findById(entityId).orElseThrow());
    }

    @GetMapping("/getAll")
    public ResponseEntity<List<School>> getAll(){
        return ResponseEntity.ok(repository.findAll());
    }

    @DeleteMapping()
    public ResponseEntity<Integer> delete(@RequestParam Integer entityId){
        repository.deleteById(entityId);
        return ResponseEntity.ok(entityId);
    }

    @PatchMapping()
    public ResponseEntity<Integer> update(@RequestBody School entity){
        var result = repository.save(entity);
        return ResponseEntity.ok(result.Id);
    }
}
