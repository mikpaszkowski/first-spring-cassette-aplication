package pl.application.cassetteaplication.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pl.application.cassetteaplication.dao.entity.VideoCassette;
import pl.application.cassetteaplication.manager.VideoCassetteManager;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/cassettes")

public class VideoCassetteAPI {

    private VideoCassetteManager videoCassettes;

    @Autowired
    public VideoCassetteAPI(VideoCassetteManager videoCassettes) {
        this.videoCassettes = videoCassettes;
    }


    @GetMapping("/all")
    public Iterable<VideoCassette> getAll(){

        return videoCassettes.findAll();

    }

    @GetMapping
    public Optional<VideoCassette> getById(@RequestParam long index){
        return videoCassettes.findById(index);
    }

    //elementy bedą dodawane do bazy danych
    @PostMapping
    public VideoCassette addVideo(@RequestBody VideoCassette videoCassette){
        return videoCassettes.save(videoCassette);
    }

    //elementy będą nadpisywane
    @PutMapping
    public VideoCassette updateVideo(@RequestBody VideoCassette videoCassette){
        return videoCassettes.save(videoCassette);
    }

    @DeleteMapping
    public void deleteVideo(@RequestParam long index){
        videoCassettes.delete(index);
    }

}
