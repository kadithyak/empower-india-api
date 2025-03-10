package com.andhraempower.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "project_bank_details")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
public class ProjectBankDetail extends Audit{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "project_id", nullable = false)
    @NonNull
    private Long projectId;

    @Column(name = "account_number")
    @NonNull
    private String accountNumber;

    @Column(name = "account_name")
    @NonNull
    private String accountName;

    @Column(name = "bank_name")
    private String bankName;

    @Column(name = "bank_address")
    private String bankAddress;

    @Column(name = "bank_phone_number")
    private String bankPhoneNumber;

    @Column(name = "ifsc_code")
    private String ifscCode;

    @Column(name = "swift_code")
    private String swiftCode;


}
