package feyz.com.basicApp.Entities.Concretes;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Role {
    @JsonProperty("Id")
    private int Id;
    @JsonProperty("Name")
    private String Name;
}
