package za.ac.cput.Repository;

import za.ac.cput.Domain.Booking;
import za.ac.cput.Domain.Payments;

import java.util.ArrayList;
import java.util.List;

public class PaymentRepository implements IPaymentsRepository{

    private static IPaymentsRepository repository = null;
    private List<Payments> paymentsList;

    private PaymentRepository(){
        paymentsList = new ArrayList<Payments>();
    }

    public static IPaymentsRepository getRepository(){
        if(repository == null){
            repository = new PaymentRepository();
        }
        return repository;
    }


    @Override
    public Payments create(Payments payments) {
        boolean success = paymentsList.add(payments);
        if(success){
            return payments;
        }
        return null;
    }

    @Override
    public Payments read(String id) {
        for(Payments payments : paymentsList){
            if(payments.getPaymentID().equals(id)){
                return payments;
            }
        }
        return null;
    }

    @Override
    public Payments update(Payments payments) {
        String id = payments.getPaymentID();
        Payments updatedpayments = read(id);
        if(updatedpayments == null)
            return null;

        boolean success = delete(id);
        if(success){
            if(paymentsList.add(payments))
                return payments;
        }
        return null;
    }

    @Override
    public boolean delete(String id) {
        Payments payments = read(id);
        if(payments == null)
            return false;

        return (paymentsList.remove(payments));
    }

    @Override
    public List<Payments> getAllPayments() {
        return paymentsList;
    }
}
