package ru.job4j.ood.lsp.store;

import static org.junit.Assert.assertThat;
import static org.hamcrest.Matchers.is;
import org.junit.Test;
import java.time.LocalDate;

public class PercentExpireDateTest  {
    @Test
    public void percent() {
        PercentExpireDate pr = new PercentExpireDate();
        Food food = new Food("Сыр", LocalDate.of(2021, 8, 27),
                LocalDate.of(2021, 8, 25), 150, 30);
        LocalDate now = LocalDate.of(2021, 8, 26);
        double exp = pr.percentExpDate(food, now);
        assertThat(exp, is(50.0));
    }
}