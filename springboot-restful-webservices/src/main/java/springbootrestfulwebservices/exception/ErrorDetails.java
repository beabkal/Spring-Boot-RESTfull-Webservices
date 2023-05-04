package springbootrestfulwebservices.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class ErrorDetails {

    private LocalDate timeStamp;
    private String message;
    private String path;
    private String errorCode;

}
