package feyz.com.basicApp.Views;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class RegisterRequestView {
    private String Email;
    private Date Date_Birthday;
    private String Full_Name;
    private String Password;

}
