package com.rule.violation.zuul.server.controller;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.client.RestTemplate;

import com.rule.violation.zuul.server.model.MailSendingDTO;

@Controller
public class VehicleController {

	@Autowired
	private RestTemplate restTemplate;

	@GetMapping("/testing")
	private String getEmployees(Model model) {
		List<String> vehcleNumbers = Arrays.asList( "KA 22 HK9029");
		List<MailSendingDTO> vehiclelist = new ArrayList<MailSendingDTO>();
		for (String vehcleNumber : vehcleNumbers) {
			final String uri = "http://localhost:8765/mailing-service/mailDetails/"+vehcleNumber;
			MailSendingDTO result = restTemplate.getForObject(uri, MailSendingDTO.class);
			 vehiclelist.add(result);
			try {
				SendMail.sendMail("lokeshcg516@gmail.com");
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		model.addAttribute("vehicleDtls", vehiclelist);

		return "violted-vehicles-dtls";
	}

}
