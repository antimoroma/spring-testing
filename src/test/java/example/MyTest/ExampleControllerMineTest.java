package example.MyTest;

import example.Controller.ExampleController;
import example.person.Person;
import example.person.PersonRepository;
import example.weather.WeatherClient;
import org.hamcrest.core.IsNull;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;

import java.util.Optional;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
import static org.mockito.BDDMockito.given;
import static org.mockito.Matchers.anyString;
import static org.mockito.MockitoAnnotations.initMocks;

public class ExampleControllerMineTest {

    ExampleController subject;

    @Mock
    PersonRepository personRepository;

    @Mock
    WeatherClient weatherClient;

    @Before
    public void setUp() throws Exception {
        initMocks(this);
        subject = new ExampleController(personRepository, weatherClient);
    }


    @Test
    public void canaryTest(){
        assertThat(true, is(true));
    }

    @Test
    public void checkMockedInstance(){
        assertThat(personRepository , is(IsNull.notNullValue()));
    }


    @Test
    public void shouldReturnHelloWorld(){
        String hello = subject.hello();
        assertThat(hello , is("Hello World!"));
    }

    @Test
    public void shouldReturnHelloLastName(){
        String personToBeFound = "Rossi";
        Person peter = new Person("Peterz", personToBeFound);
        given(personRepository.findByLastName(personToBeFound)).willReturn(Optional.of(peter));


        String res = subject.hello(personToBeFound);
        assertThat(res , is("Hello Peterz Rossi!"));
    }

    @Test
    public void shouldTellIfPersonIsUnknown(){
        String personToBeFound = "Rossi";
        Person peter = new Person("Peterz", personToBeFound);
        given(personRepository.findByLastName(anyString())).willReturn(Optional.empty());


        String res = subject.hello(personToBeFound);
        assertThat(res , is("Who is this 'Rossi' you're talking about?"));
    }


}
