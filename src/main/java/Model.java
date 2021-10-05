public class Model {

    private String name;
    private Double temp;
    private Double humidity;
    private Double speed;
    private String icon;
    private String description;

    /**
     * метод getName возвращает имя
     * @return name
     */
    public String getName() {
        return name;
    }
    /**
     * метод setName устанавливает имя
     * @param name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * метод getTemp возвращает температуру
     * @return temp
     */
    public Double getTemp() {
        return temp;
    }
    /**
     * метод setTemp устанавливает температуру
     * @param temp
     */
    public void setTemp(Double temp) {
        this.temp = temp;
    }

    /**
     * метод getHumidity возвращает влажность
     * @return humidity
     */
    public Double getHumidity() {
        return humidity;
    }
    /**
     * метод setHumidity устанавливает влажность
     * @param humidity
     */
    public void setHumidity(Double humidity) {
        this.humidity = humidity;
    }


    /**
     * метод getSpeed возвращает скорость воздуха
     * @return speed
     */
    public Double getSpeed() {
        return speed;
    }
    /**
     * метод setSpeed устанавливает скорость воздуха
     * @param speed
     */
    public void setSpeed(Double speed) {
        this.speed = speed;
    }

    /**
     * метод getIcon возвращает иконку
     * @return icon
     */
    public String getIcon() { return icon; }
    /**
     * метод setIcon устанавливает иконку
     * @param icon
     */
    public void setIcon(String icon) { this.icon = icon; }


    /**
     * метод getDescription возвращает описание
     * @return description
     */
    public String getDescription() {
        return description;
    }
    /**
     * метод setDescription устанавливает описание
     * @param description
     */
    public void setDescription(String description) {
        this.description = description;
    }
}
