package za.ac.cput.Factory;

import org.junit.jupiter.api.Test;
import za.ac.cput.Domain.Payments;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

class PaymentsFactoryTest {

    @Test
    void testCreatePayments_Success() {
        Payments payment = PaymentsFactory.createPayments(
                "P001",
                "Online Payment",
                LocalDate.of(2025, 6, 15),
                "Credit Card",
                2500.75,
                "Hotel booking payment"
        );

        assertNotNull(payment, "Payment should not be null");
        assertEquals("P001", payment.getPaymentID());
        assertEquals("Online Payment", payment.getPaymentType());
        assertEquals(LocalDate.of(2025, 6, 15), payment.getPaymentDate());
        assertEquals("Credit Card", payment.getPaymentMethod());
        assertEquals(2500.75, payment.getPaymentAmount());
        assertEquals("Hotel booking payment", payment.getPaymentDescription());
    }

    @Test
    void testCreatePayments_Fail_EmptyValues() {
        Payments payment = PaymentsFactory.createPayments(
                "", "", LocalDate.now(), "", 0, "");

        assertNull(payment, "Payment should be null when required fields are empty");
    }

}
