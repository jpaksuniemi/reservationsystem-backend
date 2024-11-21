package com.jpaksuniemi;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ReserverController {

    private final ReserverRepository repository;

    ReserverController(ReserverRepository repository) {
        this.repository = repository;
    }

    @GetMapping("/reserver")
    List<Reserver> all() {
        return repository.findAll();
    }

    @PostMapping("/reserver")
    Reserver newReserver(@RequestBody Reserver newReserver) {
        return repository.save(newReserver);
    }

    @GetMapping("/reserver/{id}")
    Reserver one(@PathVariable Long id) {
        return repository.findById(id).orElseThrow();
    }

    @PutMapping("/reserver/{id}")
    Reserver replaceReserver(@RequestBody Reserver newReserver, @PathVariable Long id) {
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

    @DeleteMapping("/reserver/{id}")
    void deleteReserver(@PathVariable Long id) {
        repository.deleteById(id);
    }

}
