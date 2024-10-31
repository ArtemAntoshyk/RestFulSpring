package devtitans.antoshchuk.restfulspring.repositories;

import devtitans.antoshchuk.restfulspring.models.Car;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@EnableJpaRepositories
public interface CarRepository extends JpaRepository<Car, Integer> {

}
