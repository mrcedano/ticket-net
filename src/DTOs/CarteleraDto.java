package DTOs;

import java.util.Date;
import java.util.List;

public class CarteleraDto {
    
    private int id;
    private Date activeSince;
    private Date activeUntil;
    public List<PeliculaDto> movies;

    public CarteleraDto(int id, Date activeSince, Date activeUntil) {
        this.id = id;
        this.activeSince = activeSince;
        this.activeUntil = activeUntil;
    }

    public int getId() {
        return id;
    }

    public Date getActiveSince() {
        return activeSince;
    }

    public Date getActiveUntil() {
        return activeUntil;
    }
}