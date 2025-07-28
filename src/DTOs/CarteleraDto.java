package DTOs;

import java.time.LocalDate;
import java.util.List;

public class CarteleraDto {
    
    private int id;
    private LocalDate activeSince;
    private LocalDate activeUntil;
    private int isActivated;
    public List<PeliculaDto> movies;

    public CarteleraDto(int id, LocalDate activeSince, LocalDate activeUntil, int isActivated) {
        this.id = id;
        this.activeSince = activeSince;
        this.activeUntil = activeUntil;
        this.isActivated = isActivated;
    }

    public int getId() {
        return id;
    }

    public LocalDate getActiveSince() {
        return activeSince;
    }

    public LocalDate getActiveUntil() {
        return activeUntil;
    }
    
    public int getIsActivated() {
        return isActivated;
    }
}