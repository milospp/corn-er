package ftn.corner.model;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Treatment {
	@Id
	@GeneratedValue
	private Long id;

	private String name;
	private String code;
	private String description;

	@Override
	public String toString() {
		return "Treatment [name=" + name + ", code=" + code + ", description=" + description + "]";
	}
	
	
	
	
}
