package feyz.com.basicApp.Entities.Concretes;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {
    @JsonProperty("Id")
    private int Id;
    @JsonProperty("Email")
    private String Email;
    @JsonProperty("Date_Birthday")
    private Date Date_Birthday;
    @JsonProperty("Full_Name")
    private String Full_Name;
    @JsonProperty("Date_Registered")
    private Date Date_Registered;
    @JsonProperty("RoleId")
    private int RoleId;
}