package kr.co.tbell.testapi.controller.api;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import kr.co.tbell.testapi.controller.CrudController;
import kr.co.tbell.testapi.model.entity.Item;
import kr.co.tbell.testapi.model.network.request.ItemApiRequest;
import kr.co.tbell.testapi.model.network.response.ItemApiResponse;

@RestController
@RequestMapping("/api/item")
public class ItemApiController extends CrudController<ItemApiRequest, ItemApiResponse, Item> {


}
