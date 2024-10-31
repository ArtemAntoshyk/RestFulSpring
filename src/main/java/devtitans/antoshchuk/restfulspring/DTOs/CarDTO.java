package devtitans.antoshchuk.restfulspring.DTOs;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class CarDTO {
    private String brand;
    private String model;
    private int hp;
    private String engineType;
    private int price;
}
