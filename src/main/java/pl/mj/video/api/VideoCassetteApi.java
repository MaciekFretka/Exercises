package pl.mj.video.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pl.mj.video.dao.entity.VideoCassette;
import pl.mj.video.manager.VideoCassetteManager;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/cassettes")
@CrossOrigin
public class VideoCassetteApi {

    private VideoCassetteManager videoCassettes;

    @Autowired
    public VideoCassetteApi(VideoCassetteManager videoCassetteManager){
       this.videoCassettes=videoCassetteManager;
    }

    @GetMapping("/all")
    public Iterable<VideoCassette> getAll() {
    return videoCassettes.findAll();
    }

    @GetMapping
    public Optional<VideoCassette> getById(@RequestParam Long index){

        return videoCassettes.findById(index);
    }

    @PostMapping
            public VideoCassette addVideo(@RequestBody VideoCassette videoCassette){
            return videoCassettes.save(videoCassette);
    }

    @PutMapping
    public VideoCassette updateVideo(@RequestBody VideoCassette videoCassette){
        return videoCassettes.save(videoCassette);
    }

    @DeleteMapping
    public void deleteVideo(@RequestParam Long index){
        videoCassettes.delete(index);
    }


}
