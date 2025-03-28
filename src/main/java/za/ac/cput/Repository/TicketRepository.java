package za.ac.cput.Repository;

import za.ac.cput.Domain.Tickect;

import java.util.ArrayList;
import java.util.List;

public class TicketRepository implements ITicketRepository{
    public static ITicketRepository repository = null;
    private List<Tickect>TicketList;

    private TicketRepository(){
        TicketList = new ArrayList<Tickect>();
    }
    public static ITicketRepository getRepository(){
        if (repository == null){
            repository = new TicketRepository();
        }
        return repository;
    }


    @Override
    public Tickect create(Tickect ticket) {
        boolean sucess = TicketList.add(ticket);
        if (sucess){
            return ticket;
        }
        System.out.println("");
        return null;
    }

    @Override
    public Tickect read(String ticketID) {
        for(Tickect ticket : TicketList){
            if(ticket.getTicketID().equals(ticketID)){
                return ticket;
            }
        }
        System.out.println("");
        return null;
    }

    @Override
    public Tickect update(Tickect ticket) {
        for (int i = 0; i < TicketList.size(); i++){
            TicketList.set(i, ticket);
        }
        System.out.println("");
        return null;
    }

    @Override
    public boolean delete(String ticketID) {
        for (Tickect ticket : TicketList){
            if(ticket.getTicketID().equals(ticketID)){
                TicketList.remove(ticket);
            }
        }
        System.out.println("");
        return false;
    }
    @Override
    public List<Tickect> getAll() {
        return new ArrayList<>(TicketList
        );
    }

}
