package no.mattikj.backend.service;

import no.mattikj.backend.entity.Icon;
import no.mattikj.backend.repository.IconRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class IconService {

    @Autowired
    private IconRepository iconRepository;

    public List<Icon> getAllIcons() {
        return iconRepository.findAll();
    }

    public Optional<Icon> getIconById(Integer id) {
        return iconRepository.findById(id);
    }

    public Icon saveIcon(Icon icon) {
        return iconRepository.save(icon);
    }

    public void deleteIcon(Integer id) {
        iconRepository.deleteById(id);
    }
}