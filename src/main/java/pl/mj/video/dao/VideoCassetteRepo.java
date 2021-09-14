package pl.mj.video.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import pl.mj.video.dao.entity.VideoCassette;

@Repository
public interface VideoCassetteRepo extends CrudRepository<VideoCassette, Long> {

}
