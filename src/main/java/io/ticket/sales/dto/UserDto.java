package io.ticket.sales.dto;

import io.ticket.sales.config.AccessRole;

public class UserDto extends BaseDto {
    private AccessRole accessRole;

    public UserDto(Integer id, String name, AccessRole accessRole) {
        this.id = id;
        this.name = name;
        this.accessRole = accessRole;
    }
    
    public String getAccess() {
        switch(accessRole) {
            case Admin: 
                return "R,D";
            case User:
                return "R,W";
            default:
                return "";
        }
    }

    public void setAccess(AccessRole accessRole) {
         this.accessRole = accessRole;
    }
}


  