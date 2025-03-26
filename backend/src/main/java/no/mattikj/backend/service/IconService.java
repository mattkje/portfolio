package no.mattikj.backend.service;

import no.mattikj.backend.entity.Icon;
import no.mattikj.backend.repository.IconRepository;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Optional;

import org.apache.batik.transcoder.TranscoderException;
import org.apache.batik.transcoder.TranscoderInput;
import org.apache.batik.transcoder.TranscoderOutput;
import org.apache.batik.transcoder.image.PNGTranscoder;

import java.io.File;
import java.io.FileOutputStream;

@Service
public class IconService {

    @Value("${icon.upload.dir}")
    private String uploadDir;

    private final IconRepository iconRepository;

    public IconService(IconRepository iconRepository) {
        this.iconRepository = iconRepository;
    }

    public String uploadIcon(MultipartFile file) throws IOException {
        if (file.isEmpty()) {
            throw new IllegalArgumentException("File is empty");
        }

        byte[] bytes = file.getBytes();
        Path path = Paths.get(uploadDir + java.io.File.separator + file.getOriginalFilename());
        Files.write(path, bytes);

        Icon iconEntity = new Icon();
        iconEntity.setFileName(file.getOriginalFilename());
        iconRepository.save(iconEntity);

        return file.getOriginalFilename();
    }

    public Resource getIcon(String filename) throws IOException, TranscoderException {
        Path file = Paths.get(uploadDir).resolve(filename);
        Resource resource = new UrlResource(file.toUri());

        if (resource.exists() || resource.isReadable()) {
            if (filename.endsWith(".svg")) {
                String pngFilename = filename.replace(".svg", ".png");
                Path pngFile = Paths.get(uploadDir).resolve(pngFilename);
                if (!Files.exists(pngFile)) {
                    convertSvgToPng(file.toString(), pngFile.toString());
                }
                resource = new UrlResource(pngFile.toUri());
            }
            return resource;
        } else {
            throw new IOException("Could not read file: " + filename);
        }
    }

    public Optional<Icon> getIconMetadata(Long id) {
        return iconRepository.findById(id);
    }


    public void convertSvgToPng(String svgFilePath, String pngFilePath) throws IOException, TranscoderException {
        File svgFile = new File(svgFilePath);
        File pngFile = new File(pngFilePath);

        if (!pngFile.exists()) {
            PNGTranscoder transcoder = new PNGTranscoder();
            TranscoderInput input = new TranscoderInput(svgFile.toURI().toString());
            try (FileOutputStream outputStream = new FileOutputStream(pngFile)) {
                TranscoderOutput output = new TranscoderOutput(outputStream);
                transcoder.transcode(input, output);
            }
        }
    }
}
