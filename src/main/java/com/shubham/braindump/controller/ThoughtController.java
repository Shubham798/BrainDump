package com.shubham.braindump.controller;

import com.shubham.braindump.entity.Thought;
import com.shubham.braindump.repository.ThoughtRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

import static com.shubham.braindump.entity.Tag.*;

@RestController
@RequestMapping("/api/thoughts")
public class ThoughtController {

    ThoughtRepository thoughtRepository;

    public ThoughtController(ThoughtRepository thoughtRepository) {
        this.thoughtRepository = thoughtRepository;
    }

    @GetMapping
    public String getThoughts() {
        List<Thought> thoughts = thoughtRepository.findAll();
        return "Hello, this is a list of thoughts!:\n" + thoughts.stream().map(Thought::toString).collect(Collectors.joining("\n"));
    }

    @PostMapping
    public String addThought(@RequestBody Thought thought) {
        thoughtRepository.save(thought);
        return "Thought added: " + thought;
    }

    @GetMapping("/{id}")
    public String getThoughtById(@PathVariable Long id) {
        Thought thought = thoughtRepository.findById(id).orElse(null);
        if (thought != null) {
            return "Thought found: " + thought;
        } else {
            return "Thought not found with ID: " + id;
        }
    }

    @DeleteMapping("/{id}")
    public String deleteThoughtById(@PathVariable Long id) {
        thoughtRepository.deleteById(id);
        return "Thought deleted with ID: " + id;
    }
}
