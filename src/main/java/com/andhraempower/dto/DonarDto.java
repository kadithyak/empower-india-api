package com.andhraempower.dto;
import com.andhraempower.entity.Donar;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class DonarDto {

    private Long id;
    private String firstName;
    private String lastName;
    private String phoneNumber;
    private String email;
    private Double amount;
    private String category;
    private String address;
    private String memoryOf;
    private Long villageId;
    private String modeOfPayment;

    public Donar fromDto(){
        Donar donar = new Donar();
        donar.setId(this.id);
        donar.setFirstName(this.firstName);
        donar.setLastName(this.lastName);
        donar.setPhoneNumber(this.phoneNumber);
        donar.setEmail(this.email);
        donar.setAddress(this.address);
        donar.setMemoryOf(this.memoryOf);
        return donar;
    }
}


