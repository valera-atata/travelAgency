package com.travelagency.app.entity;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.*;

@Entity
@Table(name = "clients")
public class ClientEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "client_id")
    private Long clientId;
	
	@Column(name = "surname", nullable = false, insertable = true, updatable = true, length = 200)
    private String surname;
	
	@Column(name = "name", nullable = false, insertable = true, updatable = true, length = 200)
    private String name;
	
	@Column(name = "patron", nullable = false, insertable = true, updatable = true, length = 200)
    private String patron;
	
	@Column(name = "passport", nullable = false, insertable = true, updatable = true, length = 200)
    private String passport;
	
	@Column(name = "address", nullable = false, insertable = true, updatable = true, length = 200)
    private String address;
	
	@Column(name = "phone", nullable = true, insertable = true, updatable = true)
    private Long phone;

	@OneToMany(mappedBy = "client", cascade = CascadeType.ALL)
    private Set<ContractEntity> contracts = new HashSet<ContractEntity>();
  
    public Long getClientId() {
		return clientId;
	}

	public void setClientId(Long clientId) {
		this.clientId = clientId;
	}

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPatron() {
		return patron;
	}

	public void setPatron(String patron) {
		this.patron = patron;
	}

	public String getPassport() {
		return passport;
	}

	public void setPassport(String passport) {
		this.passport = passport;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public Long getPhone() {
		return phone;
	}

	public void setPhone(Long phone) {
		this.phone = phone;
	}

    public Set<ContractEntity> getContracts() {
        return this.contracts;
    }

    public void setContracts(Set<ContractEntity> contracts) {
        this.contracts = contracts;
    }

    public void addContract(ContractEntity contract) {
    	contract.setClient(this);
    	getContracts().add(contract);
    }

    public void removeContract(ContractEntity contract) {
    	getContracts().remove(contract);
    }
	
}
