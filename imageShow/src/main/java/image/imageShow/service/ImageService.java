package image.imageShow.service;

import image.imageShow.model.Image;
import image.imageShow.repository.ImageShowRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ImageService {

    @Autowired
    ImageShowRepository imageShowRepository;

    public void saveImage(Image image) {
        imageShowRepository.save(image);
    }


    public List<Image> getAllActiveImages() {
        return imageShowRepository.findAll();
    }

    public Optional<Image> getImageById(Long id) {
        return imageShowRepository.findById(id);
    }
}
