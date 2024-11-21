package com.jpaksuniemi;

import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin
@RestController
@RequestMapping("/api")
public class ReserverController {

    private final ReserverRepository repository;

    ReserverController(ReserverRepository repository) {
        this.repository = repository;
    }

    @GetMapping("/reservers/")
    List<Reserver> all() {
        return repository.findAll();
    }

    @PostMapping("/reservers/")
    Reserver newReserver(@RequestBody Reserver newReserver) {
        return repository.save(newReserver);
    }

    @GetMapping("/reservers/{id}")
    Reserver one(@PathVariable long id) {
        return repository.findById(id).orElseThrow();
    }

    @PutMapping("/reservers/{id}")
    Reserver replaceReserver(@RequestBody Reserver newReserver, @PathVariable long id) {
        return repository.findById(id)
            .map(reserver -> {
                reserver.setName(newReserver.getName());
                reserver.setEmail(newReserver.getEmail());
                return repository.save(reserver);
            })
            .orElseGet(() -> {
                return repository.save(newReserver);
            });
    }

    @DeleteMapping("/reservers/{id}")
    void deleteReserver(@PathVariable long id) {
        repository.deleteById(id);
    }

}
