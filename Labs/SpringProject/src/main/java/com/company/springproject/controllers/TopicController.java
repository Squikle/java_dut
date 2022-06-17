package com.company.springproject.controllers;

import com.company.springproject.dal.TheoryLesson;
import com.company.springproject.dal.Topic;
import com.company.springproject.repositories.CommonRepository;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/payment")
@AllArgsConstructor
public class TopicController {
    private final CommonRepository<Topic> repository;

    @PostMapping
    public ResponseEntity<Integer> add(@RequestBody Topic entity){
        return ResponseEntity.ok(repository.save(entity).Id);
    }

    @GetMapping
    public ResponseEntity<Topic> get(@RequestParam Integer entityId){
        return ResponseEntity.ok(repository.findById(entityId).orElseThrow());
    }

    @GetMapping("/getAll")
    public ResponseEntity<List<Topic>> getAll(){
        return ResponseEntity.ok(repository.findAll());
    }

    @DeleteMapping()
    public ResponseEntity<Integer> delete(@RequestParam Integer entityId){
        repository.deleteById(entityId);
        return ResponseEntity.ok(entityId);
    }

    @PatchMapping()
    public ResponseEntity<Integer> update(@RequestBody Topic entity){
        var result = repository.save(entity);
        return ResponseEntity.ok(result.Id);
    }
}
