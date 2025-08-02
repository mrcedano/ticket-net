package DTOs;

public class AsientoDto {
    private int id = 0;
    private int sala_id = 0;
    private int asientoNumero = 0;

    public AsientoDto(int id, int sala_id, int asientoNumero) {
        this.id = id;
        this.sala_id = sala_id;
        this.asientoNumero = asientoNumero;
    }

    public int getId() {
        return id;
    }

    public int getSalaId() {
        return sala_id;
    }

    public int getAsientoNumero() {
        return asientoNumero;
    }
}