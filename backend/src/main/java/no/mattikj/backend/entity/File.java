package no.mattikj.backend.entity;

    import jakarta.persistence.Entity;
    import jakarta.persistence.GeneratedValue;
    import jakarta.persistence.GenerationType;
    import org.springframework.data.annotation.Id;

    @Entity
    public class File {
        @jakarta.persistence.Id
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;

        private String fileName;

        public void setId(Long id) {
            this.id = id;
        }

        public Long getId() {
            return id;
        }

        public String getFileName() {
            return fileName;
        }

        public void setFileName(String originalFilename) {
            this.fileName = originalFilename;
        }

        // Getters and setters
    }