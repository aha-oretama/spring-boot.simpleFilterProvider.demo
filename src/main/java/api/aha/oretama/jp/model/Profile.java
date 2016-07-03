package api.aha.oretama.jp.model;

import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonFilter;

import api.aha.oretama.jp.advice.RestControllerFilterAdvice;
import lombok.Data;

@JsonFilter(RestControllerFilterAdvice.PROFILE_FILTER)
@Data
public class Profile {

	private String firstName;
	private String lastName;
	private LocalDate birthDay;
	private String gender;

}
