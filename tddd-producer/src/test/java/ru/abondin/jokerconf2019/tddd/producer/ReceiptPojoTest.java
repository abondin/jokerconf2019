package ru.abondin.jokerconf2019.tddd.producer;

import org.hamcrest.BaseMatcher;
import org.hamcrest.Description;
import org.junit.Assert;
import org.junit.Test;
import ru.abondin.jokerconf2019.tddd.producer.util.InnValidationUtils;

import java.math.BigDecimal;

public class ReceiptPojoTest {

    @Test
    public void create() {
        Receipt receipt = new Receipt("20020wofbf", "5260307811", new BigDecimal(100.00));
        Assert.assertEquals(receipt.getUuid(), "20020wofbf");
        Assert.assertThat(receipt.getTaxpayerInn(), new BaseMatcher<>() {

            @Override
            public void describeTo(Description description) {
                description.appendText("INN in valid format");
            }

            @Override
            public boolean matches(Object o) {
                return o instanceof String && InnValidationUtils.isInnValid((String) o);
            }
        });
        Assert.assertEquals(receipt.getAmount(), new BigDecimal(100.00));
    }
}
