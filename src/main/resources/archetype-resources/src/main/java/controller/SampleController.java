package ${package}.controller;

import java.util.Map;

import com.xelita.commons.dto.ResponseDTO;
import ${package}.dto.IdentityDTO;
import ${package}.service.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.*;
import org.springframework.transaction.annotation.*;
import org.springframework.web.bind.annotation.*;

import java.util.*;

/**
 * Sample REST controller.
 *
 * @author sempere
 */
@Slf4j
@Transactional(readOnly = true)
@RequestMapping(value = "/api/SampleService_1")
@RestController
public class SampleController {

    @Value("${app.key}")
    public String appKey;

	@Autowired
	private SampleService sampleService;

	// *************************************************************************
	//
	// Rest methods
	//
	// *************************************************************************

	/**
	 * Check access to DB by returning one document from it.
	 *
	 * @return a JSON object
	 */
	@RequestMapping(value = "/check", method = RequestMethod.GET)
	public ResponseDTO<IdentityDTO> check() {
		return new ResponseDTO<IdentityDTO>(this.appKey, this.sampleService.check());
	}
}
