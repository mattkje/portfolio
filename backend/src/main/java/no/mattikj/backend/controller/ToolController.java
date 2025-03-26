package no.mattikj.backend.controller;

import no.mattikj.backend.entity.Tool;
import no.mattikj.backend.service.ToolService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/tools")
public class ToolController {

    @Autowired
    private ToolService toolService;

    @GetMapping
    public List<Tool> getAllTools() {
        return toolService.getAllTools();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Tool> getToolById(@PathVariable Integer id) {
        Optional<Tool> project = toolService.getToolById(id);
        return project.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public Tool createTool(@RequestBody Tool tool) {
        return toolService.saveTool(tool);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTool(@PathVariable Integer id) {
        toolService.deleteTool(id);
        return ResponseEntity.noContent().build();
    }
}