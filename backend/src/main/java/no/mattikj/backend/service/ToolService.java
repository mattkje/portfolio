package no.mattikj.backend.service;

    import no.mattikj.backend.entity.Tool;
    import no.mattikj.backend.repository.ToolRepository;
    import org.springframework.beans.factory.annotation.Autowired;
    import org.springframework.stereotype.Service;

    import java.util.List;
    import java.util.Optional;

    @Service
    public class ToolService {

        @Autowired
        private ToolRepository toolRepository;

        public List<Tool> getAllTools() {
            return toolRepository.findAll();
        }

        public Optional<Tool> getToolById(Integer id) {
            return toolRepository.findById(id);
        }

        public Tool saveTool(Tool project) {
            return toolRepository.save(project);
        }

        public void deleteTool(Integer id) {
            toolRepository.deleteById(id);
        }
    }