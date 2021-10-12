package ru.job4j.ood.dip;

public class ExampleDIPOne {

    class Photographer {
        public Camera camera;

        public Photo newPhoto(String nameImage) {
            return camera.makePhoto(nameImage);
        }
    }

    class Camera {
        public Photo makePhoto(String name) {
            return new Photo(name);
        }
    }

    class Photo {
        private String format;
        private String name;

        public Photo(String name) {
            this.format = "DCIM";
            this.name = name;
        }
    }
}
