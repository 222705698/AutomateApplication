package za.ac.cput.Factory;

import za.ac.cput.Domain.Booking;
import za.ac.cput.Domain.Payments;
import za.ac.cput.Util.Helper;

import java.time.LocalDate;

public class PaymentsFactory {
    public static Payments createPayments(String paymentId ,String paymentType, LocalDate paymentDate, String paymentMethod,double amount, String paymentDescription) {
        if ( Helper.isNullOrEmpty(paymentId) || Helper.isNullOrEmpty(paymentType) || Helper.isNullOrEmpty(String.valueOf(paymentDate)) || Helper.isNullOrEmpty(paymentMethod) || Helper.isNullOrEmpty(String.valueOf(amount)) || Helper.isNullOrEmpty(paymentDescription)) {
            return null;
        }

        return new Payments.PaymentBuilder()
                .setPaymentID(paymentId)
                .setPaymentType(paymentType)
                .setPaymentDate(paymentDate)
                .setPaymentMethod(paymentMethod)
                .setPaymentAmount(amount)
                .setPaymentDescription(paymentDescription)
                .build();
    }
}
