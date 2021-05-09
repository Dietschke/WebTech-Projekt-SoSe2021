package com.dietschke.Liste;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


    @Entity
    public class Liste {

        @Id
        @GeneratedValue(strategy = GenerationType.AUTO)
        private Long id;
        private String title;
        private String description;

        public Liste() {}

        public Liste(Long id, String title, String description) {
            super();
            this.id = id;
            this.title = title;
            this.description = description;
        }

        @Override
        public String toString() {
            return String.format(
                    "Liste [id=%d, title='%s', description='%s']",
                    id, title, description);
        }

        public Long getId() {
            return id;
        }

        public String getTitle() {
            return title;
        }

        public String getDescription() {
            return description;
        }

        public void setId(long id) {
            this.id = id;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public void setDescription(String description) {
            this.description = description;
        }
    }

