package com.workintech.zoo.controller;

import com.workintech.zoo.entity.Kangaroo;
import com.workintech.zoo.exceptions.ZooException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/kangaroos")
public class KangarooController {
    private Map<Long, Kangaroo> kangaroos = new HashMap<>();

    @GetMapping
    public ResponseEntity<List<Kangaroo>> getAllKangaroos() {
        List<Kangaroo> kangarooList = new ArrayList<>(kangaroos.values());
        return new ResponseEntity<>(kangarooList, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public Kangaroo getKangarooById(@PathVariable Long id) {
        Kangaroo kangaroo = kangaroos.get(id);
        if (kangaroo == null) {
            throw new ZooException("Kangaroo with ID " + id + " not found.", HttpStatus.NOT_FOUND);
        }
        return kangaroo;
    }

    @PostMapping
    public ResponseEntity<Kangaroo> addKangaroo(@RequestBody Kangaroo kangaroo) {
        if (kangaroo.getName() == null || kangaroo.getName().isEmpty()) {
            throw new ZooException("Name is required.", HttpStatus.BAD_REQUEST);
        }
        if (kangaroo.getHeight() <= 0) {
            throw new ZooException("Height must be greater than 0.", HttpStatus.BAD_REQUEST);
        }
        if (kangaroo.getWeight() <= 0) {
            throw new ZooException("Weight must be greater than 0.", HttpStatus.BAD_REQUEST);
        }
        if (kangaroo.getGender() == null || kangaroo.getGender().isEmpty()) {
            throw new ZooException("Gender is required.", HttpStatus.BAD_REQUEST);
        }

        kangaroos.put(kangaroo.getId(), kangaroo);
        return ResponseEntity.ok(kangaroo);    }
    @PutMapping("/{id}")
    public Kangaroo updateKangaroo(@PathVariable Long id, @RequestBody Kangaroo kangaroo) {
        if (!kangaroos.containsKey(id)) {
            throw new ZooException("Kangaroo with ID " + id + " not found.", HttpStatus.NOT_FOUND);
        }
        kangaroos.put(id, kangaroo);
        return kangaroo;
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Map<String, String>> deleteKangaroo(@PathVariable Long id) {
        Map<String, String> response = new HashMap<>();
        response.put("message", "Kangaroo with ID " + id + " has been removed.");
        response.put("id", String.valueOf(id));

        return new ResponseEntity<>(response, HttpStatus.OK);
    }

}
