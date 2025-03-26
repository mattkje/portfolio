package no.mattikj.backend.controller;

import no.mattikj.backend.entity.Icon;
import no.mattikj.backend.repository.IconRepository;
import no.mattikj.backend.service.GameService;
import no.mattikj.backend.service.IconService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

@RestController
@RequestMapping("/api/icons")
public class IconController {

    @Autowired
    private IconRepository iconRepository;
    @Value("${icon.upload.dir}")
    private String uploadDir;

    @Autowired
    private IconService iconService;

    @GetMapping
    public List<Icon> getAllIcons() {
        return iconRepository.findAll();
    }

   @GetMapping("/convert/{filename}")
   public ResponseEntity<Resource> loadIcon(@PathVariable String filename) {
       try {
           return ResponseEntity.ok(iconService.getIcon(filename));
       } catch (Exception e) {
           return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
       }
   }

    @GetMapping("/{filename}")
    public ResponseEntity<Resource> getIcon(@PathVariable String filename) {
        try {
            Path file = Paths.get(uploadDir).resolve(filename);
            Resource resource = new UrlResource(file.toUri());

            if (resource.exists() || resource.isReadable()) {
                return ResponseEntity.ok()
                        .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + resource.getFilename() + "\"")
                        .body(resource);
            } else {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
            }
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }
}