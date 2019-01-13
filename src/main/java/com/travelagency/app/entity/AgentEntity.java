package com.travelagency.app.entity;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.*;


@Entity
@Table(name = "agents")
public class AgentEntity {
	
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "agent_id")
    private Long agentId;
	
	@Column(name = "surname", nullable = true, insertable = true, updatable = true, length = 200)
    private String surname;
	
	@Column(name = "name", nullable = true, insertable = true, updatable = true, length = 200)
    private String name;
	
	@Column(name = "patron", nullable = true, insertable = true, updatable = true, length = 200)
    private String patron;
	
	@Column(name = "passport", nullable = true, insertable = true, updatable = true, length = 200)
    private String passport;
	
	@Column(name = "address", nullable = true, insertable = true, updatable = true, length = 200)
    private String address;
	
	@Column(name = "phone", nullable = true, insertable = true, updatable = true)
    private Long phone;
	
	@Column(name = "login", nullable = false, insertable = true, updatable = true, length = 200)
    private String login;
	
	@Column(name = "password", nullable = false, insertable = true, updatable = true, length = 200)
    private String password;
  
	@Transient
    private String confirmPassword;
	
	@OneToMany(mappedBy = "agent", cascade = CascadeType.ALL)
    private Set<ContractEntity> contracts = new HashSet<ContractEntity>();
	
	@ManyToMany
    @JoinTable(name = "agent_roles", joinColumns = @JoinColumn(name = "agent_id"),
            inverseJoinColumns = @JoinColumn(name = "role_id"))
    private Set<RoleEntity> roleEntities = new HashSet<RoleEntity>();

    public Long getAgentId() {
		return agentId;
	}

	public void setAgentId(Long agentId) {
		this.agentId = agentId;
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

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
    public String getConfirmPassword() {
        return confirmPassword;
    }

    public void setConfirmPassword(String confirmPassword) {
        this.confirmPassword = confirmPassword;
    }
	
 	public Set<ContractEntity> getContracts() {
        return this.contracts;
    }

    public void setContracts(Set<ContractEntity> contracts) {
        this.contracts = contracts;
    }

    public void addContract(ContractEntity contract) {
    	contract.setAgent(this);
    	getContracts().add(contract);
    }

    public void removeContract(ContractEntity contract) {
    	getContracts().remove(contract);
    }
	
    public Set<RoleEntity> getRoles() {
        return roleEntities;
    }

    public void setRoles(Set<RoleEntity> roleEntities) {
        this.roleEntities = roleEntities;
    }
    
    public void addRole(RoleEntity roleEntity) {
        roleEntities.add(roleEntity);
    }
    
}
