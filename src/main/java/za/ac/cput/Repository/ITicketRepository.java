package za.ac.cput.Repository;

import za.ac.cput.Domain.Tickect;
import za.ac.cput.Domain.Tickect;

import java.util.List;

public interface ITicketRepository extends IRepository<Tickect,String> {
    List<Tickect> getAll();
}
