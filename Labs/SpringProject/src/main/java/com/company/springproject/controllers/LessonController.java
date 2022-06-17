package com.company.springproject.controllers;

import com.company.springproject.dal.Lesson;
import com.company.springproject.repositories.CommonRepository;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/lesson")
@AllArgsConstructor
public class LessonController {
    private final CommonRepository<Lesson> repository;

    @PostMapping
    public ResponseEntity<Integer> add(@RequestBody Lesson entity){
        return ResponseEntity.ok(repository.save(entity).Id);
    }

    @GetMapping
    public ResponseEntity<Lesson> get(@RequestParam Integer entityId){
        return ResponseEntity.ok(repository.findById(entityId).orElseThrow());
    }

    @GetMapping("/getAll")
    public ResponseEntity<List<Lesson>> getAll(){
        return ResponseEntity.ok(repository.findAll());
    }

    @DeleteMapping()
    public ResponseEntity<Integer> delete(@RequestParam Integer entityId){
        repository.deleteById(entityId);
        return ResponseEntity.ok(entityId);
    }

    @PatchMapping()
    public ResponseEntity<Integer> update(@RequestBody Lesson entity){
        var result = repository.save(entity);
        return ResponseEntity.ok(result.Id);
    }
}
