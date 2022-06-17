package com.company.springproject.controllers;

import com.company.springproject.dal.Car;
import com.company.springproject.repositories.CommonRepository;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/car")
@AllArgsConstructor
public class CarController {
    private final CommonRepository<Car> repository;

    @PostMapping
    public ResponseEntity<Integer> add(@RequestBody Car entity){
        return ResponseEntity.ok(repository.save(entity).Id);
    }

    @GetMapping
    public ResponseEntity<Car> get(@RequestParam Integer entityId){
        return ResponseEntity.ok(repository.findById(entityId).orElseThrow());
    }

    @GetMapping("/getAll")
    public ResponseEntity<List<Car>> getAll(){
        return ResponseEntity.ok(repository.findAll());
    }

    @DeleteMapping()
    public ResponseEntity<Integer> delete(@RequestParam Integer entityId){
        repository.deleteById(entityId);
        return ResponseEntity.ok(entityId);
    }

    @PatchMapping()
    public ResponseEntity<Integer> update(@RequestBody Car entity){
        var result = repository.save(entity);
        return ResponseEntity.ok(result.Id);
    }
}
