package io.ticket.sales.dto;

public class TicketDto extends BaseDto {
    private UserDto TicketSeller; 
    public Integer Price;
    public String Description;

    public TicketDto(Integer id, String name, UserDto seller, Integer price) {
        this.id = id;
        this.name = name;
        TicketSeller = seller;
    }

    public void setSeller(UserDto seller) {
        TicketSeller = seller;
     }

     public UserDto getSeller() {
        return TicketSeller;
     }
    
    public String getName() {
       return name;
    }
}


  