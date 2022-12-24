import java.util.HashMap;

public class NoteBook {
    private float inch;
    private double ram;
    private boolean game;
    private String process;
    private String graphics_card;
    private int total_volume_solid_state_drives;
    private String oc;
    private String color;
    private String name;

    public NoteBook(String name, HashMap<Integer, NoteBook> notebooks) {
        this.name = name;
        this.ram = 0;
        this.game = false;
        this.process = null;
        this.graphics_card = null;
        this.total_volume_solid_state_drives = 0;
        this.oc = null;
        this.color = null;
        notebooks.put(notebooks.size(), this);
    }
    public void setRam(int amount, String type) {
        switch (type.toLowerCase()) {
            case "gb":
                this.ram += amount * 1024;
                break;
            case "mb":
                this.ram += amount;
                break;
            case "tb":
                this.ram += amount * 1024 * 1024;
                break;
        }
    }

    public double getInch() {
        return inch;
    }

    public double getRam() {
        return ram;
    }

    public String getColor() {
        return color;
    }

    public String getName() {
        return name;
    }

    public String getGraphics_card() {
        return graphics_card;
    }

    public int getTotal_volume_solid_state_drives() {
        return total_volume_solid_state_drives;
    }

    public String getOc() {
        return oc;
    }

    public String getProcess() {
        return process;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public void setGame(boolean game) {
        this.game = game;
    }

    public void setGraphics_card(String graphics_card) {
        this.graphics_card = graphics_card;
    }

    public void setInch(float inch) {
        this.inch = inch;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setOc(String oc) {
        this.oc = oc;
    }

    public void setProcess(String process) {
        this.process = process;
    }

    public void setTotal_volume_solid_state_drives(int total_volume_solid_state_drives) {
        this.total_volume_solid_state_drives = total_volume_solid_state_drives;
    }

    public boolean isGame() {
        return game;
    }
}
