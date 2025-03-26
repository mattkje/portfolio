package no.mattikj.backend.service;

        import no.mattikj.backend.entity.File;
        import no.mattikj.backend.repository.FileRepository;
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

        @Service
        public class FileService {

            @Value("${file.upload.dir}")
            private String uploadDir;

            private final FileRepository fileRepository;

            public FileService(FileRepository fileRepository) {
                this.fileRepository = fileRepository;
            }

            public String uploadFile(MultipartFile file) throws IOException {
                if (file.isEmpty()) {
                    throw new IllegalArgumentException("File is empty");
                }

                byte[] bytes = file.getBytes();
                Path path = Paths.get(uploadDir + java.io.File.separator + file.getOriginalFilename());
                Files.write(path, bytes);

                File fileEntity = new File();
                fileEntity.setFileName(file.getOriginalFilename());
                fileEntity.setFilePath(path.toString());
                fileRepository.save(fileEntity);

                return file.getOriginalFilename();
            }

            public Resource getFile(String filename) throws IOException {
                Path file = Paths.get(uploadDir).resolve(filename);
                Resource resource = new UrlResource(file.toUri());

                if (resource.exists() || resource.isReadable()) {
                    return resource;
                } else {
                    throw new IOException("Could not read file: " + filename);
                }
            }

            public Optional<File> getFileMetadata(Long id) {
                return fileRepository.findById(id);
            }
        }