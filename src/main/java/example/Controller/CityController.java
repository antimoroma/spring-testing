package example.Controller;

import example.city.City;
import example.city.CityRepository;
import example.person.PersonRepository;
import org.aspectj.lang.annotation.Before;
import org.hibernate.validator.constraints.ParameterScriptAssert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CityController {

    @Autowired
    private CityRepository cityRepository;

    @GetMapping("/hello1")
    public String hello() {
        return "Hello World!";
    }

    @GetMapping("/another/{cityName}")
    public String anotherHello(@PathVariable String cityName){


        City city = cityRepository.findOne(cityName);

        return "Hello world from city with population " + city.getPopulation();
    }

}
