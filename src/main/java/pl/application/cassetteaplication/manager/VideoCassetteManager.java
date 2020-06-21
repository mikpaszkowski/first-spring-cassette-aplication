package pl.application.cassetteaplication.manager;

//to jes moja warstwa pośrednia

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Service;
import pl.application.cassetteaplication.dao.VideoCassetteRepo;
import pl.application.cassetteaplication.dao.entity.VideoCassette;

import java.time.LocalDate;
import java.util.Optional;

@Service
public class VideoCassetteManager {

    private VideoCassetteRepo videoCasetteeRepo;

    @Autowired
    public VideoCassetteManager(VideoCassetteRepo videoCasetteeRepo) {
        this.videoCasetteeRepo = videoCasetteeRepo;
    }

    public Optional<VideoCassette> findById(Long id) {

        return videoCasetteeRepo.findById(id);
    }

    public Iterable<VideoCassette> findAll() {

        return videoCasetteeRepo.findAll();
    }

    public VideoCassette save(VideoCassette videoCassette) {

        return videoCasetteeRepo.save(videoCassette);
    }

    public void delete(Long id) {

        videoCasetteeRepo.deleteById(id);
    }


    @EventListener(ApplicationReadyEvent.class)
    public void fillDB() {

        save(new VideoCassette(1L, "Titanic", LocalDate.of(1995, 2, 26)));
        save(new VideoCassette(2L, "Shrek2", LocalDate.of(2006, 2, 21)));


    }

}
