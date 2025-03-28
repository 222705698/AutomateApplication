package za.ac.cput.Repository;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import za.ac.cput.Domain.Payments;
import za.ac.cput.Factory.PaymentsFactory;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;

@TestMethodOrder(MethodOrderer.MethodName.class)
class PaymentsRepositoryTest {

    private static IPaymentsRepository repository = PaymentRepository.getRepository();
    private static Payments payments = PaymentsFactory.createPayments("hdhw","Fine", LocalDate.now(),"Paypal",1900,"Paying for fine on vehicle");

    @Test
    void a_create() {
        Payments createdPayments = repository.create(payments);
        assertNotNull(createdPayments);
        System.out.println(createdPayments.toString());
    }

    @Test
    void b_read() {
        Payments read = repository.read(payments.getPaymentID());
        assertNotNull(read);
        System.out.println(read.toString());
    }

    @Test
    void c_update() {
        Payments updatedPayments = new Payments.PaymentBuilder().copyPayment(payments).build();
        Payments updated = repository.update(updatedPayments);
        assertNotNull(updated);
        System.out.println(updated.toString());
    }

    @Test
    @Disabled
    void d_delete() {
        assertTrue(repository.delete(payments.getPaymentID()));
        System.out.println("Successfully deleted");
    }

    @Test
    void e_getAllBookings() {
        System.out.println(repository.getAllPayments());
    }
}