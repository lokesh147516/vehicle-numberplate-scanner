package com.violation.mail.mailingservice.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.violation.mail.mailingservice.mail.SendMail;
import com.violation.mail.mailingservice.model.MailSendingDTO;
import com.violation.mail.mailingservice.model.OwnerDTO;
import com.violation.mail.mailingservice.model.VehclUsrDetailsModel;
import com.violation.mail.mailingservice.model.VehicleDTO;
import com.violation.mail.mailingservice.model.ViolatdVehclModel;
import com.violation.mail.mailingservice.model.ViolationVehicleDTO;
import com.violation.mail.mailingservice.services.RtoVehicleDtlsServiceInterface;
import com.violation.mail.mailingservice.services.VehicleRuleViolnDtlsServiceInterface;

@RestController
public class MailingServiceController {

	@Autowired
	RtoVehicleDtlsServiceInterface proxy;

	@Autowired
	VehicleRuleViolnDtlsServiceInterface proxy2;

	@GetMapping("/hellooo")
	public String hello() {
		return proxy.hello();
	}

	@GetMapping("/vehicleDtls/{violtedVehicleNumber}")
	public List<ViolationVehicleDTO> findByVioltedVehicleNumber(
			@PathVariable(name = "violtedVehicleNumber") String violtedVehicleNumber) {
		return proxy2.findByVioltedVehicleNumber(violtedVehicleNumber);
	}
/*	@GetMapping("/allVehicleDtls/{numberPlates}")
	public List<MailSendingDTO> getAllVehicleDtls(@PathVariable List<String> numberPlates) {
		List<MailSendingDTO> mailSendingDTOs=new ArrayList<MailSendingDTO>();
		for (String numberPlate : numberPlates) {
			mailSendingDTOs.add(getAllMailSendingDtls(numberPlate));
		}
		
		return mailSendingDTOs;
	}*/
	@GetMapping("/mailDetails/{numberPlate}")
	public MailSendingDTO getAllMailSendingDtls(@PathVariable String numberPlate) {
		VehclUsrDetailsModel vehicleUsrDetail = proxy.getVehicleUsrDetail(numberPlate);
		List<ViolatdVehclModel> violatdVehclModels = proxy2.findByVehicleNumber(numberPlate);

		MailSendingDTO mailSendingDTO = new MailSendingDTO();
		mailSendingDTO.setVehicleName(vehicleUsrDetail.getVehicleName());
		mailSendingDTO.setVehicleManufacturer(vehicleUsrDetail.getVehicleManufacturer());
		mailSendingDTO.setNumberPlate(vehicleUsrDetail.getNumberPlate());
		mailSendingDTO.setVehicleOrgnlColor(vehicleUsrDetail.getVehicleOrgnlColor());
		mailSendingDTO.setOwnerName(vehicleUsrDetail.getOwnerName());

		String violatedDates = "";
		String violtnNames = "";
		double totalFineAmt = 0d;
		for (ViolatdVehclModel violatdVehclModel : violatdVehclModels) {
			violatedDates = violatedDates + violatdVehclModel.getViolatedDate().toString() + "  ";
			mailSendingDTO.setViolatedDate(violatedDates);

			violtnNames = violtnNames + violatdVehclModel.getViolationName() + "  ";
			mailSendingDTO.setViolationName(violtnNames);

			totalFineAmt = totalFineAmt + violatdVehclModel.getFineAmt();
			mailSendingDTO.setFineAmt(totalFineAmt);
			
		}
		/*try {
			SendMail.sendMail("lokeshcg516@gmail.com");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
		}*/
		return mailSendingDTO;
	
	}

}
