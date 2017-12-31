package example.Controller;

import example.city.City;
import example.city.CityRepository;
import org.hamcrest.core.IsNull;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
import static org.mockito.BDDMockito.given;
import static org.mockito.MockitoAnnotations.initMocks;

public class CityControllerTest {

    // Instantiates testing object instance and tries to inject fields annotated with @Mock or @Spy
    // into private fields of testing object
    @InjectMocks
    CityController cityController;

    @Mock
    CityRepository cityRepository;

    @Before
    public void setUp() throws Exception {
        initMocks(this);
    }

    @Test
    public void canaryTest(){
        assertThat(true, is(true));
    }

    @Test
    public void checkMockedInstance(){
        assertThat(cityRepository , is(IsNull.notNullValue()));
    }



    @Test
    public void hello() {
        String hello = cityController.hello();
        assertThat(cityController.hello(), is("Hello World!"));

    }

    @Test
    public void anotherHello() {
        City city = new City("Paris", 5000);
        given(cityRepository.findOne("Paris")).willReturn(city);

        String result = cityController.anotherHello("Paris");

    }
}