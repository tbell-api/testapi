package kr.co.tbell.testapi.controller.api;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import kr.co.tbell.testapi.controller.CrudController;
import kr.co.tbell.testapi.model.entity.Partner;
import kr.co.tbell.testapi.model.network.request.PartnerApiRequest;
import kr.co.tbell.testapi.model.network.response.PartnerApiResponse;

@RestController
@RequestMapping("/api/partner")
public class PartnerApiController extends CrudController<PartnerApiRequest, PartnerApiResponse, Partner> {
}
