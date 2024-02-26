package com.bap.bankaccount.entity;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import lombok.*;

@Getter
@Setter
@RequiredArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "customer")
public class Customer {
    @Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	@NotBlank(message =  "First name cannot be blank")
	@NonNull
	@Column(nullable = false)
	private String firstname;

    @NotBlank(message =  "Last Name cannot be blank")
	@NonNull
	@Column(nullable = false)
	private String lastname;
    
    @NotBlank(message = "Phone number cannot be blank")
    @NonNull
    @Column(nullable = false, unique = true)
    private String phoneNumber;

    @NotBlank(message = "Email cannot be blank")
    @NonNull
    @Column(nullable = false, unique = true)
    private String email;

    @JsonIgnore
    @OneToMany(mappedBy = "customer", cascade = CascadeType.ALL)
    private List<Account> accounts;
    

}
