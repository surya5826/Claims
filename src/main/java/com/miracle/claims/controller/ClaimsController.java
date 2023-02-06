package com.miracle.claims.controller;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.miracle.claims.beans.Claim;
import com.miracle.claims.exception.ErrorDetails;
import com.miracle.claims.service.ClaimsServiceImpl;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

/**
 * The Class ClaimsController.
 */
@RestController
@CrossOrigin(origins="*")
@RequestMapping("/claims")
public class ClaimsController {

	/** The claims services. */
	@Autowired
	private ClaimsServiceImpl claimsServices;
	
	/**
	 * Gets the all claims.
	 *
	 * @return the all claims
	 */
	@ResponseBody
	@ResponseStatus(HttpStatus.OK)
	@ApiOperation(value = "Returns All Claims", notes = "JSON Supported", response = Claim.class)
	@ApiResponses({ @ApiResponse(code = 200, message = "success", response = Claim.class),
			@ApiResponse(code = 400, message = "bad-request", response = ErrorDetails.class),
			@ApiResponse(code = 401, message = "Unauthorized", response = ErrorDetails.class),
			@ApiResponse(code = 403, message = "Claims service requires authentication - please check username and password", response = ErrorDetails.class),
			@ApiResponse(code = 404, message = "Data not found", response = ErrorDetails.class),
			@ApiResponse(code = 405, message = "Method not allowed", response = ErrorDetails.class),
			@ApiResponse(code = 500, message = "Internal server error", response = ErrorDetails.class) })
	@GetMapping("/")
	public ResponseEntity<List<Claim>> getAllClaims() {
		return claimsServices.getAllClaims();
	}

	/**
	 * Gets the claims by service provider claim id.
	 *
	 * @param serviceProviderClaimId the service provider claim id
	 * @return the claims by service provider claim id
	 */
	@ResponseBody
	@ResponseStatus(HttpStatus.OK)
	@ApiOperation(value = "Get Claim By Service Provider Claim Id", notes = "JSON Supported", response = Claim.class)
	@ApiResponses({ @ApiResponse(code = 200, message = "success", response = Claim.class),
			@ApiResponse(code = 400, message = "bad-request", response = ErrorDetails.class),
			@ApiResponse(code = 401, message = "Unauthorized", response = ErrorDetails.class),
			@ApiResponse(code = 403, message = "Claims service requires authentication - please check username and password", response = ErrorDetails.class),
			@ApiResponse(code = 404, message = "Data not found", response = ErrorDetails.class),
			@ApiResponse(code = 405, message = "Method not allowed", response = ErrorDetails.class),
			@ApiResponse(code = 500, message = "Internal server error", response = ErrorDetails.class) })
	@GetMapping("/{serviceProviderClaimId}")
	public ResponseEntity<Claim> getClaimsByServiceProviderClaimId(
			@ApiParam(value = "Service Provide Claim Id", required = true) @PathVariable Long serviceProviderClaimId) {
		return new ResponseEntity<Claim>(claimsServices.getClaim(serviceProviderClaimId), new HttpHeaders(),
				HttpStatus.OK);
	}

	/**
	 * Creates the claims.
	 *
	 * @param claim the claim
	 * @return the response entity
	 */
	@ResponseBody
	@ResponseStatus(HttpStatus.OK)
	@ApiOperation(value = "Create Claim", notes = "JSON Supported", response = Claim.class)
	@ApiResponses({ @ApiResponse(code = 200, message = "success", response = Claim.class),
			@ApiResponse(code = 400, message = "bad-request", response = ErrorDetails.class),
			@ApiResponse(code = 401, message = "Unauthorized", response = ErrorDetails.class),
			@ApiResponse(code = 403, message = "Claims service requires authentication - please check username and password", response = ErrorDetails.class),
			@ApiResponse(code = 404, message = "Data not found", response = ErrorDetails.class),
			@ApiResponse(code = 405, message = "Method not allowed", response = ErrorDetails.class),
			@ApiResponse(code = 500, message = "Internal server error", response = ErrorDetails.class) })
	@PostMapping("/addclaims")
	public ResponseEntity<Claim> createClaims(
			@ApiParam(value = "Claim Request", required = true) @RequestBody Claim claim) {
		return claimsServices.createClaims(claim);
	}

	/**
	 * Update claim.
	 *
	 * @param claimId the claim id
	 * @param claim   the claim
	 * @return the response entity
	 */
	@ResponseBody
	@ResponseStatus(HttpStatus.OK)
	@ApiOperation(value = "Update Claim", notes = "JSON Supported", response = Claim.class)
	@ApiResponses({ @ApiResponse(code = 200, message = "success", response = Claim.class),
			@ApiResponse(code = 400, message = "bad-request", response = ErrorDetails.class),
			@ApiResponse(code = 401, message = "Unauthorized", response = ErrorDetails.class),
			@ApiResponse(code = 403, message = "Claims service requires authentication - please check username and password", response = ErrorDetails.class),
			@ApiResponse(code = 404, message = "Data not found", response = ErrorDetails.class),
			@ApiResponse(code = 405, message = "Method not allowed", response = ErrorDetails.class),
			@ApiResponse(code = 500, message = "Internal server error", response = ErrorDetails.class) })
	@PutMapping("/{serviceProviderClaimId}")
	public ResponseEntity<Claim> updateClaim(
			@ApiParam(value = "Service Provider Claim Id", required = true) @PathVariable Long serviceProviderClaimId,
			@ApiParam(value = "Claim Request", required = true) @RequestBody Claim claim) {
		return claimsServices.updateClaims(serviceProviderClaimId, claim);
	}

	/**
	 * Delete claims.
	 *
	 * @param claimId the claim id
	 * @return the string
	 */
	@ResponseBody
	@ResponseStatus(HttpStatus.OK)
	@ApiOperation(value = "Delete Claim", notes = "JSON Supported", response = Claim.class)
	@ApiResponses({ @ApiResponse(code = 200, message = "success", response = Claim.class),
			@ApiResponse(code = 400, message = "bad-request", response = ErrorDetails.class),
			@ApiResponse(code = 401, message = "Unauthorized", response = ErrorDetails.class),
			@ApiResponse(code = 403, message = "Claims service requires authentication - please check username and password", response = ErrorDetails.class),
			@ApiResponse(code = 404, message = "Data not found", response = ErrorDetails.class),
			@ApiResponse(code = 405, message = "Method not allowed", response = ErrorDetails.class),
			@ApiResponse(code = 500, message = "Internal server error", response = ErrorDetails.class) })
	@DeleteMapping("/{serviceProviderClaimId}")
	public String deleteClaims(
			@ApiParam(value = "Service Provider Claim Id", required = true) @PathVariable Long serviceProviderClaimId) {
		return claimsServices.deleteClaims(serviceProviderClaimId);
	}

	/**
	 * Gets the claims by customer claim id.
	 *
	 * @param customerClaimId the customer claim id
	 * @return the claims by customer claim id
	 */
	
	@ResponseBody
	@ResponseStatus(HttpStatus.OK)
	@ApiOperation(value = "Get Claims By Customer Claim Id", notes = "JSON Supported", response = Claim.class)
	@ApiResponses({ @ApiResponse(code = 200, message = "success", response = Claim.class),
			@ApiResponse(code = 400, message = "bad-request", response = ErrorDetails.class),
			@ApiResponse(code = 401, message = "Unauthorized", response = ErrorDetails.class),
			@ApiResponse(code = 403, message = "Claims service requires authentication - please check username and password", response = ErrorDetails.class),
			@ApiResponse(code = 404, message = "Data not found", response = ErrorDetails.class),
			@ApiResponse(code = 405, message = "Method not allowed", response = ErrorDetails.class),
			@ApiResponse(code = 500, message = "Internal server error", response = ErrorDetails.class) })
	@GetMapping("/customer/{claimId}")
	public ResponseEntity<Claim> getClaimsByCustomerClaimId(
			@ApiParam(value = "Customer Claim Id", required = true) @PathVariable("claimId") String claimId) {
		return new ResponseEntity<Claim>(claimsServices.getCustomerClaim(claimId),new HttpHeaders(),
				HttpStatus.OK);
	}
	
	
	/**
	 * Gets the claims by facility id.
	 * @param facilityId the facility id
	 * @return the claims by facility id
	 */
	@ResponseBody
	@ResponseStatus(HttpStatus.OK)
	@ApiOperation(value = "Get Claims By Facility Id", notes = "JSON Supported", response = Claim.class)
	@ApiResponses({ @ApiResponse(code = 200, message = "success", response = Claim.class),
			@ApiResponse(code = 400, message = "bad-request", response = ErrorDetails.class),
			@ApiResponse(code = 401, message = "Unauthorized", response = ErrorDetails.class),
			@ApiResponse(code = 403, message = "Claims service requires authentication - please check username and password", response = ErrorDetails.class),
			@ApiResponse(code = 404, message = "Data not found", response = ErrorDetails.class),
			@ApiResponse(code = 405, message = "Method not allowed", response = ErrorDetails.class),
			@ApiResponse(code = 500, message = "Internal server error", response = ErrorDetails.class) })
	@GetMapping("/facility/{facilityId}")
	public ResponseEntity<List<Claim>> getClaimsByFacilityId(
			@ApiParam(value = "Facility Id", required = true) @PathVariable("facilityId") String facilityId) {
		return claimsServices.getFacilityClaim(facilityId);
	}
	
	/**
	 * Gets all the claims by claim status.
	 * @return all the claims by claim status
	 */
	@ResponseBody
	@ResponseStatus(HttpStatus.OK)
	@ApiOperation(value = "Returns All Claims status", notes = "JSON Supported", response = Claim.class)
	@ApiResponses({ @ApiResponse(code = 200, message = "success", response = Claim.class),
			@ApiResponse(code = 400, message = "bad-request", response = ErrorDetails.class),
			@ApiResponse(code = 401, message = "Unauthorized", response = ErrorDetails.class),
			@ApiResponse(code = 403, message = "Claims service requires authentication - please check username and password", response = ErrorDetails.class),
			@ApiResponse(code = 404, message = "Data not found", response = ErrorDetails.class),
			@ApiResponse(code = 405, message = "Method not allowed", response = ErrorDetails.class),
			@ApiResponse(code = 500, message = "Internal server error", response = ErrorDetails.class) })
	@GetMapping("/claim-status")
	public ResponseEntity<List<Claim>> getAllClaimsByClaimStatus(){
		return claimsServices.getAllClaimsByStatus();
	}


	/**
	 * Gets the claims by claim status.
	 *
	 * @param claimStatus the claim status
	 * @return the claims by claim status
	 */
	@ResponseBody
	@ResponseStatus(HttpStatus.OK)
	@ApiOperation(value = "Get Claims By Status", notes = "JSON Supported", response = Claim.class)
	@ApiResponses({ @ApiResponse(code = 200, message = "success", response = Claim.class),
			@ApiResponse(code = 400, message = "bad-request", response = ErrorDetails.class),
			@ApiResponse(code = 401, message = "Unauthorized", response = ErrorDetails.class),
			@ApiResponse(code = 403, message = "Claims service requires authentication - please check username and password", response = ErrorDetails.class),
			@ApiResponse(code = 404, message = "Data not found", response = ErrorDetails.class),
			@ApiResponse(code = 405, message = "Method not allowed", response = ErrorDetails.class),
			@ApiResponse(code = 500, message = "Internal server error", response = ErrorDetails.class) })
	@GetMapping("/claimstatus/{claimStatus}")
	public ResponseEntity<List<Claim>> getClaimsByClaimStatus(
			@ApiParam(value = "Claim Status", required = true) @PathVariable("claimStatus") String claimStatus) {
		return claimsServices.getClaimsByStatus(claimStatus);

	}
	/**
	 * Gets the claims by claim type.
	 *
	 * @param claimType the claim type
	 * @return the claims by claim type
	 */
	@ResponseBody
	@ResponseStatus(HttpStatus.OK)
	@ApiOperation(value = "Get Claims By Type", notes = "JSON Supported", response = Claim.class)
	@ApiResponses({ @ApiResponse(code = 200, message = "success", response = Claim.class),
			@ApiResponse(code = 400, message = "bad-request", response = ErrorDetails.class),
			@ApiResponse(code = 401, message = "Unauthorized", response = ErrorDetails.class),
			@ApiResponse(code = 403, message = "Claims service requires authentication - please check username and password", response = ErrorDetails.class),
			@ApiResponse(code = 404, message = "Data not found", response = ErrorDetails.class),
			@ApiResponse(code = 405, message = "Method not allowed", response = ErrorDetails.class),
			@ApiResponse(code = 500, message = "Internal server error", response = ErrorDetails.class) })
	@GetMapping("/claimtype/{claimType}")
	public ResponseEntity<List<Claim>> getClaimsByClaimType(
			@ApiParam(value = "Claim Type", required = true) @PathVariable("claimType") String claimType) {
		return claimsServices.getClaimsByType(claimType);
	}

	/**
	 * Gets the claims by document type.
	 *
	 * @param documentType the document type
	 * @return the claims by document type
	 */
	@ResponseBody
	@ResponseStatus(HttpStatus.OK)
	@ApiOperation(value = "Get Claims By Document Type", notes = "JSON Supported", response = Claim.class)
	@ApiResponses({ @ApiResponse(code = 200, message = "success", response = Claim.class),
			@ApiResponse(code = 400, message = "bad-request", response = ErrorDetails.class),
			@ApiResponse(code = 401, message = "Unauthorized", response = ErrorDetails.class),
			@ApiResponse(code = 403, message = "Claims service requires authentication - please check username and password", response = ErrorDetails.class),
			@ApiResponse(code = 404, message = "Data not found", response = ErrorDetails.class),
			@ApiResponse(code = 405, message = "Method not allowed", response = ErrorDetails.class),
			@ApiResponse(code = 500, message = "Internal server error", response = ErrorDetails.class) })
	@GetMapping("/documenttype/{documentType}")
	public ResponseEntity<List<Claim>> getClaimsByDocumentType(
			@ApiParam(value = "Claim Document Type", required = true) @PathVariable("documentType") String documentType) {
		return claimsServices.getClaimsByDocumentType(documentType);
	}

	/**
	 * Gets the claims by creator id.
	 *
	 * @param creatorId the creator id
	 * @return the claims by creator id
	 */
//	@ResponseBody
//	@ResponseStatus(HttpStatus.OK)
//	@ApiOperation(value = "Get Claims By Creator Id", notes = "JSON Supported", response = Claim.class)
//	@ApiResponses({ @ApiResponse(code = 200, message = "success", response = Claim.class),
//			@ApiResponse(code = 400, message = "bad-request", response = ErrorDetails.class),
//			@ApiResponse(code = 401, message = "Unauthorized", response = ErrorDetails.class),
//			@ApiResponse(code = 403, message = "Claims service requires authentication - please check username and password", response = ErrorDetails.class),
//			@ApiResponse(code = 404, message = "Data not found", response = ErrorDetails.class),
//			@ApiResponse(code = 405, message = "Method not allowed", response = ErrorDetails.class),
//			@ApiResponse(code = 500, message = "Internal server error", response = ErrorDetails.class) })
//	@GetMapping("/claims/creator/{creatorId}")
//	public ResponseEntity<Claim> getClaimsByCreatorId(
//			@ApiParam(value = "Claim Creator Id", required = true) @PathVariable String creatorId) {
//		return new ResponseEntity<Claim>(claimsServices.getClaimByCreator(creatorId),new HttpHeaders(),
//				HttpStatus.OK);
//	}

	/**
	 * Gets the claims by closed date.
	 *
	 * @param closedDate the closed date
	 * @return the claims by closed date
	 */
	@ResponseBody
	@ResponseStatus(HttpStatus.OK)
	@ApiOperation(value = "Get Claims By Closed Date", notes = "JSON Supported", response = Claim.class)
	@ApiResponses({ @ApiResponse(code = 200, message = "success", response = Claim.class),
			@ApiResponse(code = 400, message = "bad-request", response = ErrorDetails.class),
			@ApiResponse(code = 401, message = "Unauthorized", response = ErrorDetails.class),
			@ApiResponse(code = 403, message = "Claims service requires authentication - please check username and password", response = ErrorDetails.class),
			@ApiResponse(code = 404, message = "Data not found", response = ErrorDetails.class),
			@ApiResponse(code = 405, message = "Method not allowed", response = ErrorDetails.class),
			@ApiResponse(code = 500, message = "Internal server error", response = ErrorDetails.class) })
	@GetMapping("/closedate/{closedDate}")
	public ResponseEntity<List<Claim>> getClaimsByClosedDate(
			@ApiParam(value = "Claim Closed Date", required = true) @RequestParam("closedDate") String closedDate) {
		return claimsServices.getClaimsByClosedDate(closedDate);
	}

	/**
	 * Gets the claims by create date.
	 *
	 * @param createDate the create date
	 * @return the claims by create date
	 */
	@ResponseBody
	@ResponseStatus(HttpStatus.OK)
	@ApiOperation(value = "Get Claims By Create Date", notes = "JSON Supported", response = Claim.class)
	@ApiResponses({ @ApiResponse(code = 200, message = "success", response = Claim.class),
			@ApiResponse(code = 400, message = "bad-request", response = ErrorDetails.class),
			@ApiResponse(code = 401, message = "Unauthorized", response = ErrorDetails.class),
			@ApiResponse(code = 403, message = "Claims service requires authentication - please check username and password", response = ErrorDetails.class),
			@ApiResponse(code = 404, message = "Data not found", response = ErrorDetails.class),
			@ApiResponse(code = 405, message = "Method not allowed", response = ErrorDetails.class),
			@ApiResponse(code = 500, message = "Internal server error", response = ErrorDetails.class) })
	@GetMapping("/createddate/{createdDate}")
	public ResponseEntity<List<Claim>> getClaimsByCreateDate(
			@ApiParam(value = "Claim Create Date", required = true) @PathVariable("createdDate") Date createdDate) {
		return claimsServices.getClaimsByCreateDate(createdDate);
	}

	/**
	 * Gets the claims by date range.
	 *
	 * @param startDate the start date
	 * @param endDate   the end date
	 * @return the claims by date range
	 */
//	@ResponseBody
//	@ResponseStatus(HttpStatus.OK)
//	@ApiOperation(value = "Get Claims By Start and End Date", notes = "JSON Supported", response = Claim.class)
//	@ApiResponses({ @ApiResponse(code = 200, message = "success", response = Claim.class),
//			@ApiResponse(code = 400, message = "bad-request", response = ErrorDetails.class),
//			@ApiResponse(code = 401, message = "Unauthorized", response = ErrorDetails.class),
//			@ApiResponse(code = 403, message = "Claims service requires authentication - please check username and password", response = ErrorDetails.class),
//			@ApiResponse(code = 404, message = "Data not found", response = ErrorDetails.class),
//			@ApiResponse(code = 405, message = "Method not allowed", response = ErrorDetails.class),
//			@ApiResponse(code = 500, message = "Internal server error", response = ErrorDetails.class) })
//	@GetMapping("/claims/date-range")
//	public ResponseEntity<List<Claim>> getClaimsByDateRange(
//			@ApiParam(value = "Claim Start and End Date", required = true) @RequestParam("startDate") String startDate,
//			@RequestParam("endDate") String endDate) {
//		return null;
//		
//	}
	
	
//	@ResponseBody
//	@ResponseStatus(HttpStatus.OK)
//	@ApiOperation(value = "Get Claims By Claimed amount and claim status", notes = "JSON Supported", response = Claim.class)
//	@ApiResponses({ @ApiResponse(code = 200, message = "success", response = Claim.class),
//			@ApiResponse(code = 400, message = "bad-request", response = ErrorDetails.class),
//			@ApiResponse(code = 401, message = "Unauthorized", response = ErrorDetails.class),
//			@ApiResponse(code = 403, message = "Claims service requires authentication - please check username and password", response = ErrorDetails.class),
//			@ApiResponse(code = 404, message = "Data not found", response = ErrorDetails.class),
//			@ApiResponse(code = 405, message = "Method not allowed", response = ErrorDetails.class),
//			@ApiResponse(code = 500, message = "Internal server error", response = ErrorDetails.class) })
//	@GetMapping("/claims/")
//	public ResponseEntity<List<Claim>> getClaimsByClaimedAmountAndStatus(String claimedAmount, String claimStatus) {
//		return claimsServices.getClaimsByClaimedAmountAndStatus(claimedAmount,claimStatus);
//	}
}
