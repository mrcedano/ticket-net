package DTOs;

public class AsientoDto {
    private int id = 0;
    private int sala_id = 0;
    private String asiento = "";

    public AsientoDto(int id, int sala_id, String asiento) {
        this.id = id;
        this.sala_id = sala_id;
        this.asiento = asiento;
    }

    public int getId() {
        return id;
    }

    public int getSalaId() {
        return sala_id;
    }

    public String getAsiento() {
        return asiento;
    }
}