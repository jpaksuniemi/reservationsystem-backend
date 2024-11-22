package com.jpaksuniemi;

import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin
@RestController
@RequestMapping("/api")
public class DiningTableController {

    private final DiningTableRepository repository;

    DiningTableController(DiningTableRepository repository) {
        this.repository = repository;
    }

    @GetMapping("/tables/")
    List<DiningTable> all() {
        return repository.findAll();
    }

    @PostMapping("/tables/")
    DiningTable newTable(@RequestBody DiningTable newTable) {
        return repository.save(newTable);
    }

    @GetMapping("/tables/{id}")
    DiningTable one(@PathVariable long id) {
        return repository.findById(id).orElseThrow();
    }

    @DeleteMapping("/table/{id}")
    void deleteTable(@PathVariable long id) {
        repository.deleteById(id);
    }
}
