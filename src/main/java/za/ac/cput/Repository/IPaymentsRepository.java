package za.ac.cput.Repository;

import za.ac.cput.Domain.Payments;

import java.util.List;

public interface IPaymentsRepository extends IRepository<Payments,String> {
    List<Payments> getAllPayments();
}
