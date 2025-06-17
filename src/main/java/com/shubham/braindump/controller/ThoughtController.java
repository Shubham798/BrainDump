package com.shubham.braindump.controller;

import com.shubham.braindump.entity.Tag;
import com.shubham.braindump.entity.Thought;
import com.shubham.braindump.repository.ThoughtRepository;
import com.shubham.braindump.service.AiTaggingService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/api/thoughts")
public class ThoughtController {

    private final ThoughtRepository thoughtRepository;

    private final AiTaggingService aiTaggingService;

    public ThoughtController(ThoughtRepository thoughtRepository, AiTaggingService aiTaggingService) {
        this.thoughtRepository = thoughtRepository;
        this.aiTaggingService = aiTaggingService;
    }

    @GetMapping
    public List<Thought> getThoughts() {
        List<Thought> thoughts = thoughtRepository.findAll();
//        return "Hello, this is a list of thoughts!:\n" + thoughts.stream().map(Thought::toString).collect(Collectors.joining("\n"));
        return thoughts;
    }

    @PostMapping
    public String addThought(@RequestBody Thought thought) {
        Tag tag = aiTaggingService.getTagForThought(thought.getContent());
        thought.setTag(tag);
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
