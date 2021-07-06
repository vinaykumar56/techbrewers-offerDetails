package com.ibm.offerdetails.controller;

import java.io.IOException;
import java.util.List;

import com.ibm.offerdetails.api.model.OfferDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.cloudant.client.api.Database;
import com.cloudant.client.api.model.Response;

@org.springframework.web.bind.annotation.RestController
@RequestMapping("/offers")
public class RestController {

	@Autowired
	private Database db;
	
	@RequestMapping(method=RequestMethod.POST, path="/add",consumes = "application/json")
	public @ResponseBody String addOffers(@RequestBody List<OfferDetails> tds) {
		System.out.println("add offers..... start");
		Response r= null;
		System.out.println("transaction Details="+tds);
		if(tds!=null) {
			for(OfferDetails td: tds) {
			System.out.println(td.toString());
			r = db.post(td);
			}
		}
		
		System.out.println("add offers.... END");
		return r.getId();
	}

	@RequestMapping(method=RequestMethod.GET, path="/get")
	public ResponseEntity<List<OfferDetails>> getOffers(@RequestParam(required=false) Integer offerId) {
		System.out.println("get offers..... start");
		List<OfferDetails> allDocs = null;
		
			try {
				if(offerId==null) {
				allDocs = db.getAllDocsRequestBuilder().includeDocs(true)
						.build()
						.getResponse()
						.getDocsAs(OfferDetails.class);
				}
				else {
////					db.createIndex("querybycustomerIdView","designdoc","json", new IndexField()[] {new IndexField("",)});
//					allDocs = db.find(TransactionDetails.class, customerId);
//					db.
					
					System.out.println("------------------In else --------");
				}
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
		System.out.println("get offers..... END");
		return new ResponseEntity<>(allDocs, HttpStatus.OK);
	}
	
}
