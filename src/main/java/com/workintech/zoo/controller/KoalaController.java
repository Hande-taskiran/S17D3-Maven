package com.workintech.zoo.controller;

import com.workintech.zoo.entity.Koala;
import com.workintech.zoo.exceptions.ZooException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/koalas")
public class KoalaController {
    private Map<Long, Koala> koalas = new HashMap<>();

    @GetMapping
    public ResponseEntity<List<Koala>> findAllKoalas() {
        List<Koala> koalaList = new ArrayList<>(koalas.values());
        return new ResponseEntity<>(koalaList, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public Koala getKoalaById(@PathVariable Long id) {
        Koala koala = koalas.get(id);
        if (koala == null) {
            throw new ZooException("Koala with ID " + id + " not found.", HttpStatus.NOT_FOUND);
        }
        return koala;
    }
    @PostMapping
    public Koala addKoala(@RequestBody Koala koala) {
        koalas.put(koala.getId(), koala);
        return koala;
    }

    @PutMapping("/{id}")
    public Koala updateKoala(@PathVariable Long id, @RequestBody Koala koala) {
        if (!koalas.containsKey(id)) {
            throw new ZooException("Koala with ID " + id + " not found.", HttpStatus.NOT_FOUND);
        }
        koalas.put(id, koala);
        return koala;
    }

    @DeleteMapping("/{id}")
    public String deleteKoala(@PathVariable Long id) {
        if (!koalas.containsKey(id)) {
            throw new ZooException("Koala with ID " + id + " not found.", HttpStatus.NOT_FOUND);
        }
        koalas.remove(id);
        return "Koala with ID " + id + " has been removed.";
    }
}
