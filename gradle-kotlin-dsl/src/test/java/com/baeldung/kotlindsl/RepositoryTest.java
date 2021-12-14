package com.baeldung.kotlindsl;

import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.time.Instant;

import static com.baeldung.kotlindsl.Reporter.StockPrice.stockPrice;
import static com.baeldung.kotlindsl.Reporter.StockSymbol.stockSymbol;
import static org.junit.jupiter.api.Assertions.assertEquals;

class RepositoryTest {

    Repository repo = new Repository();

    @Test
    void should_return_stored_values() {
        // given
        var stock = stockSymbol("TSL");

        // when
        var result = repo.getStockPrice(stock);

        // then
        assertEquals(result.get(0), stockPrice(new BigDecimal("1.32"), Instant.parse("2021-01-01T15:00:00Z")));
        assertEquals(result.get(1), stockPrice(new BigDecimal("1.57"), Instant.parse("2021-05-05T15:00:00Z")));
        assertEquals(result.get(2), stockPrice(new BigDecimal("1.89"), Instant.parse("2021-02-03T15:00:00Z")));
    }
}