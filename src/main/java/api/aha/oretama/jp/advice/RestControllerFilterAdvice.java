package api.aha.oretama.jp.advice;

import org.springframework.core.MethodParameter;
import org.springframework.http.MediaType;
import org.springframework.http.converter.json.MappingJacksonValue;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.http.server.ServletServerHttpRequest;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.mvc.method.annotation.AbstractMappingJacksonResponseBodyAdvice;

import com.fasterxml.jackson.databind.ser.FilterProvider;
import com.fasterxml.jackson.databind.ser.impl.SimpleBeanPropertyFilter;
import com.fasterxml.jackson.databind.ser.impl.SimpleFilterProvider;

@ControllerAdvice(annotations = RestController.class)
public class RestControllerFilterAdvice extends AbstractMappingJacksonResponseBodyAdvice {

	public static final String PROFILE_FILTER = "PROFILE_FILTER";

	@Override
	protected void beforeBodyWriteInternal(MappingJacksonValue bodyContainer, MediaType contentType,
			MethodParameter returnType, ServerHttpRequest request, ServerHttpResponse response) {

		// fields パラメータの取得
		String fieldsParamter = ((ServletServerHttpRequest) request).getServletRequest().getParameter("fields");

		String[] fields = fieldsParamter == null ? new String[0] : fieldsParamter.split(",");
		// Filter の設定
		FilterProvider filters = new SimpleFilterProvider().addFilter(PROFILE_FILTER,
				fields.length == 0 ? SimpleBeanPropertyFilter.serializeAllExcept(fields)
						: SimpleBeanPropertyFilter.filterOutAllExcept(fields));
		bodyContainer.setFilters(filters);
	}
}
