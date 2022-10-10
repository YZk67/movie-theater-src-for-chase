package com.jpmc.theater;

import org.junit.jupiter.api.Test;

import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MovieTests {
    @Test
    void specialMovieWith20PercentDiscount() {
        Movie spiderMan = new Movie("Spider-Man: No Way Home", Duration.ofMinutes(90),12.5, 1);
        Showing showing = new Showing(spiderMan, 5, LocalDateTime.of(LocalDate.of(2022, 10, 9),LocalTime.of(18,15,45)));

        assertEquals(10, spiderMan.calculateTicketPrice(showing));

        //System.out.println(Duration.ofMinutes(90));
    }

    @Test
    void sequence1or2MovieWith2or3DollarDiscount() {
        Movie spiderMan = new Movie("Spider-Man: No Way Home", Duration.ofMinutes(90),12.5, 0);
        Showing showing = new Showing(spiderMan, 1, LocalDateTime.of(LocalDate.of(2022, 10, 9),LocalTime.of(18,15,45)));

        assertEquals(9.5, spiderMan.calculateTicketPrice(showing));
    }

    @Test
    void movieOf7thWith1DollarDiscount() {
        Movie spiderMan = new Movie("Spider-Man: No Way Home", Duration.ofMinutes(90),12.5, 0);
        Showing showing = new Showing(spiderMan, 3, LocalDateTime.of(LocalDate.of(2022, 10, 7),LocalTime.of(18,15,45)));

        assertEquals(11.5, spiderMan.calculateTicketPrice(showing));
    }

    @Test
    void movieBetween11And4With25PercentDiscount() {
        Movie spiderMan = new Movie("Spider-Man: No Way Home", Duration.ofMinutes(90),12.5, 0);
        Showing showing = new Showing(spiderMan, 3, LocalDateTime.of(LocalDate.of(2022, 10, 8),LocalTime.of(11,15,45)));

        assertEquals(9.375, spiderMan.calculateTicketPrice(showing));
    }

    @Test
    void movieWithNoDiscount() {
        Movie spiderMan = new Movie("Spider-Man: No Way Home", Duration.ofMinutes(90),12.5, 0);
        Showing showing = new Showing(spiderMan, 3, LocalDateTime.of(LocalDate.of(2022, 10, 8),LocalTime.of(10,15,45)));

        assertEquals(12.5, spiderMan.calculateTicketPrice(showing));
    }

    @Test
    void movieWithMultipleDiscount() {
        Movie spiderMan = new Movie("Spider-Man: No Way Home", Duration.ofMinutes(90),12.5, 1);
        Showing showing = new Showing(spiderMan, 2, LocalDateTime.of(LocalDate.of(2022, 10, 7),LocalTime.of(11,15,45)));

        assertEquals(9.375, spiderMan.calculateTicketPrice(showing));
    }
}
