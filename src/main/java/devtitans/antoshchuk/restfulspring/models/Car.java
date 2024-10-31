package devtitans.antoshchuk.restfulspring.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "car")
public class Car {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "brand")
    private String brand;
    @Column(name = "model")
    private String model;
    @Column(name = "hp")
    private int hp;
    @Column(name = "engine_type")
    private String engineType;
    @Column(name = "price")
    private int price;

    public Car(String brand, String model, int hp, String engineType, int price) {
        this.brand = brand;
        this.model = model;
        this.hp = hp;
        this.engineType = engineType;
        this.price = price;
    }
}
