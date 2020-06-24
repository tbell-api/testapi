package kr.co.tbell.testapi.controller.api;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import kr.co.tbell.testapi.controller.CrudController;
import kr.co.tbell.testapi.model.entity.OrderGroup;
import kr.co.tbell.testapi.model.network.request.OrderGroupApiRequest;
import kr.co.tbell.testapi.model.network.response.OrderGroupApiResponse;

@RestController
@RequestMapping("/api/orderGroup")
public class OrderGroupApiController extends CrudController<OrderGroupApiRequest, OrderGroupApiResponse, OrderGroup> {


}
