package no.mattikj.backend.controller;

import no.mattikj.backend.entity.Icon;
import no.mattikj.backend.service.IconService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/icons")
public class IconController {

    @Autowired
    private IconService iconService;

    @GetMapping
    public List<Icon> getAllIcons() {
        return iconService.getAllIcons();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Icon> getIconById(@PathVariable Integer id) {
        Optional<Icon> icon = iconService.getIconById(id);
        return icon.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public Icon createIcon(@RequestBody Icon icon) {
        return iconService.saveIcon(icon);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteIcon(@PathVariable Integer id) {
        iconService.deleteIcon(id);
        return ResponseEntity.noContent().build();
    }
}