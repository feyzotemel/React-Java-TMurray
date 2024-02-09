package feyz.com.basicApp.Entities.Concretes;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "Users")
@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonProperty("Id")
    @Column(name = "Id")
    private int Id;

    @JsonProperty("Email")
    @Column(name = "Email")
    private String Email;

    @JsonProperty("Date_Birthday")
    @Column(name = "Date_Birthday")
    private Date Date_Birthday;

    @JsonProperty("Full_Name")
    @Column(name = "Full_Name")
    private String Full_Name;

    @JsonProperty("Date_Registered")
    @Column(name = "Date_Registered")
    private Date Date_Registered;

    @JsonProperty("RoleId")
    @Column(name = "RoleId")
    private int RoleId;
}