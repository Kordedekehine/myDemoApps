package image.imageShow.repository;

import image.imageShow.model.Image;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ImageShowRepository extends JpaRepository< Image,Long> {


}
