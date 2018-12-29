package my.newspring.project.dao.entity;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.*;


@Entity
@Table(name = "agents", schema = "", catalog = "relationship")
public class AgentEntity {
    private Long agentId;
    private String surname;
    private String name;
    private String patron;
    private String passport;
    private String address;
    private Long phone;
    private String login;
    private String password;
  
    private Set<ContractEntity> contracts = new HashSet<ContractEntity>();
    private Set<RoleEntity> roles = new HashSet<RoleEntity>();
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "agent_id", nullable = false, insertable = true, updatable = true)
    public Long getAgentId() {
		return agentId;
	}

	public void setAgentId(Long agentId) {
		this.agentId = agentId;
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

	@Basic
    @Column(name = "login", nullable = true, insertable = true, updatable = true, length = 200)
	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	@Basic
    @Column(name = "password", nullable = true, insertable = true, updatable = true, length = 200)
	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	@OneToMany(mappedBy = "agent", cascade = CascadeType.ALL, orphanRemoval = true)
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

    @ManyToMany
    @JoinTable(name = "agent_roles", joinColumns = @JoinColumn(name = "agent_id"),
            inverseJoinColumns = @JoinColumn(name = "role_id"))
    public Set<RoleEntity> getRoles() {
        return roles;
    }

    public void setRoles(Set<RoleEntity> roles) {
        this.roles = roles;
    }
    
    public void addRole(RoleEntity role) {
        roles.add(role);
    }
}
