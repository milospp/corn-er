package ftn.corner.model.dto;

import ftn.corner.model.Pest;
import ftn.corner.model.PestAttribute;
import ftn.corner.model.Symptoms;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Set;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class PlantInputDTO {
    private Long plantId;
    private Set<Symptoms> symptoms;
    private Set<PestAttribute> pestAttributes;
}
