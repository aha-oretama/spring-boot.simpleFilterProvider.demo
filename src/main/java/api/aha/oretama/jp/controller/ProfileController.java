package api.aha.oretama.jp.controller;

import java.time.LocalDate;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import api.aha.oretama.jp.model.Profile;

@RestController
public class ProfileController {

	@RequestMapping(value = "/api/v1/users/me/profile", method = RequestMethod.GET)
	public Profile getV1Profile() {
		Profile profile = new Profile();
		profile.setFirstName("太郎");
		profile.setLastName("山田");
		profile.setBirthDay(LocalDate.of(1986, 1, 1));
		profile.setGender("MALE");

		return profile;
	}

	// @RequestMapping(value = "/api/v2/users/me/profile", method =
	// RequestMethod.GET)
	// public MappingJacksonValue getV2Profile(String[] fields) {
	// Profile profile = new Profile();
	// profile.setFirstName("太郎");
	// profile.setLastName("山田");
	// profile.setBirthDay(LocalDate.of(1986, 1, 1));
	// profile.setGender("MALE");
	//
	// MappingJacksonValue mappingJacksonValue = new
	// MappingJacksonValue(profile);
	// if (fields != null) {
	// FilterProvider filters = new SimpleFilterProvider().addFilter("Profile",
	// SimpleBeanPropertyFilter.filterOutAllExcept(fields));
	// mappingJacksonValue.setFilters(filters);
	// }
	//
	// return mappingJacksonValue;
	// }
}
