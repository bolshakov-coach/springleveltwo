package pro.bolshakov.geekbrains.springleveltwo.lesson03.spel.example4;

public class ValueHolder {
    private String value;

    public ValueHolder(String value) {
        System.out.println("created with value -> " + value);
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    @Override
    public String toString() {
        return "ValueHolder{" +
                "value='" + value + '\'' +
                '}';
    }
}
