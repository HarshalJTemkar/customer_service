package harshal.temkar.customer_service.model;

import java.io.Serializable;

import org.hibernate.annotations.UuidGenerator;
import org.hibernate.annotations.UuidGenerator.Style;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@SuppressWarnings("serial")
@Entity
@Table(name = "CUSTOMER")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Customer implements Serializable {

	@Id
	@GeneratedValue
    @UuidGenerator(style = Style.TIME)
	@Column(name = "ID")
	private String id;
	
	@NotBlank
	@Column(name = "FIRST_NAME")
	private String firstname;
	
	@NotBlank
	@Column(name = "LAST_NAME")
	private String lastname;
	
	@Email
	@Column(name = "EMAIL")
	private String email;
	
	@NotBlank
	@Column(name = "CONTACT")
	private String contact;
}
