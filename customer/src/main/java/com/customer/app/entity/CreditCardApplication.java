package com.customer.app.entity;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name="tbl_credit_card_application")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class CreditCardApplication {

	
	    @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private Long id;
	    
	    @OneToOne(cascade = CascadeType.ALL)
	    @JoinColumn(name = "id", referencedColumnName = "id")
	    private Customer customer;
	    
	    @NotNull(message = "phone number required")
	    private String phoneNumber;
	    
	    private String status; // Pending, Approved, Rejected
	    // Other credit card application information, getters, setters
	    
	    
}
