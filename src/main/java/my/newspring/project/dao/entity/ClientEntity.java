package my.newspring.project.dao.entity;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.*;

@Entity
@Table(name = "clients", schema = "", catalog = "relationship")
public class ClientEntity {
    private Long clientId;
    private String surname;
    private String name;
    private String patron;
    private String passport;
    private String address;
    private Long phone;

    private Set<ContractEntity> contracts = new HashSet<ContractEntity>();
  
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "client_id", nullable = false, insertable = true, updatable = true)
    public Long getClientId() {
		return clientId;
	}

	public void setClientId(Long clientId) {
		this.clientId = clientId;
	}

	@Basic
    @Column(name = "surname", nullable = true, insertable = true, updatable = true, length = 200)
	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	@Basic
    @Column(name = "name", nullable = true, insertable = true, updatable = true, length = 200)
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Basic
    @Column(name = "patron", nullable = true, insertable = true, updatable = true, length = 200)
	public String getPatron() {
		return patron;
	}

	public void setPatron(String patron) {
		this.patron = patron;
	}

	@Basic
    @Column(name = "passport", nullable = true, insertable = true, updatable = true, length = 200)
	public String getPassport() {
		return passport;
	}

	public void setPassport(String passport) {
		this.passport = passport;
	}

	@Basic
    @Column(name = "address", nullable = true, insertable = true, updatable = true, length = 200)
	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	@Basic
    @Column(name = "phone", nullable = true, insertable = true, updatable = true)
	public Long getPhone() {
		return phone;
	}

	public void setPhone(Long phone) {
		this.phone = phone;
	}

    @OneToMany(mappedBy = "client", cascade = CascadeType.ALL, orphanRemoval = true)
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
