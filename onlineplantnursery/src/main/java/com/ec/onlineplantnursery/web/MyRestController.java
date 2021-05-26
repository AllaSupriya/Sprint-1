package com.ec.onlineplantnursery.web;

import java.time.LocalDateTime;
import java.util.List;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import com.ec.onlineplantnursery.customer.entity.Customer;
import com.ec.onlineplantnursery.customer.service.ICustomerServices;
import com.ec.onlineplantnursery.exceptions.OrderIdNotFoundException;
import com.ec.onlineplantnursery.exceptions.ResourceNotFoundException;
import com.ec.onlineplantnursery.exceptions.SeedIdNotFoundException;
import com.ec.onlineplantnursery.order.entity.Order;
import com.ec.onlineplantnursery.order.service.IOrderService;
import com.ec.onlineplantnursery.plant.entity.Plant;
import com.ec.onlineplantnursery.plant.service.IPlantService;
import com.ec.onlineplantnursery.planter.entity.Planter;
import com.ec.onlineplantnursery.planter.service.IPlanterService;
import com.ec.onlineplantnursery.seed.entity.Seed;
import com.ec.onlineplantnursery.seed.service.ISeedService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;


@Validated
@RestController
@RequestMapping("/api")
@Api(value = "Online Nursery Application",description = "Customer can order planters")
public class MyRestController {
	Logger log = org.slf4j.LoggerFactory.getLogger(MyRestController.class);
	
	@Autowired
	ICustomerServices cservice;
	
	@Autowired
	IOrderService oservice;
	
	@Autowired
	IPlantService ipservice;
	
	@Autowired
	ISeedService iservice;
	
	@Autowired
	IPlanterService pservice;

	@GetMapping("/home")
	public String homeRequest() {
		return "Welcome : "+LocalDateTime.now();
	}
	
	@ApiOperation(value = "Customer post mapping" , response = Customer.class)
	@PostMapping("/customer/insert")
	public Customer insertCustomer(@RequestBody @Valid Customer c) {
		log.info("inside insert customer");
		return cservice.addCustomer(c);
	}
	
	/*@PostMapping("/order/new/{cid}/{pid}")
	public Order newOrder(@RequestBody Order o,@PathVariable int cid,@PathVariable int pid) {
		return oservice.addOrder(o,cid,pid);
	}*/
	
	@ApiOperation(value = "Order post mapping" , response = Order.class)
	@PostMapping("/order/new")
	public Order newOrder(@RequestBody @Valid Order o) throws ResourceNotFoundException {
		log.info("inside insert orders");
		return oservice.addOrder(o);
	}
	
	@ApiOperation(value = "Planter post mapping" , response = Planter.class)
	@PostMapping("/insert/planter")
	public Planter insertPlanter(@RequestBody @Valid Planter p) {
		log.info("inside insert planter");
		return pservice.addPlanter(p);
	}
	
	@ApiOperation(value = "Plant post mapping" , response = Plant.class)
	@PostMapping("/insert/plant")
	public Plant insertPlant(@RequestBody @Valid Plant p) {
		log.info("inside insert plant");
		return ipservice.addPlant(p);
	}
	
	@ApiOperation(value = "seed post mapping" , response = Seed.class)
	@PostMapping("/insert/seed")
	public Seed insertPlant(@RequestBody @Valid Seed p) {
		log.info("inside insert seeds");
		return iservice.addSeed(p);
	}
	
	@ApiOperation(value = "Customer Put mapping to fetch and update customer" , response = List.class)
	@PutMapping("/customer/update")
	public Customer updateById(@RequestBody Customer c) throws ResourceNotFoundException{
		log.info("Update customer");
		return cservice.updateCustomer(c);
	}
	
	@ApiOperation(value = "Order Put mapping to fetch and update order" , response = List.class)
	@PutMapping("/order/update")
	public Order updateByOrder(@RequestBody Order o)throws ResourceNotFoundException {
		log.info("Update order");
		return oservice.updateOrder(o);
	}
	
	@ApiOperation(value = "Plant Put mapping to fetch and update plant" , response = List.class)
	@PutMapping("/plant/update")
	public Plant updatePlant(@RequestBody Plant p)throws ResourceNotFoundException {
		log.info("Update plant");
		return ipservice.updatePlant(p);
	}
	
	@ApiOperation(value = "Seed Put mapping to fetch and update seed" , response = List.class)
	@PutMapping("/seed/update")
	public Seed updateSeed(@RequestBody Seed s)throws ResourceNotFoundException {
		log.info("Update seed");
		return iservice.updateSeed(s);
	}
	
	@ApiOperation(value = "Planter Put mapping to fetch and update planter" , response = List.class)
	@PutMapping("/planter/update")
	public Planter updatePlanter(@RequestBody Planter p)throws ResourceNotFoundException {
		log.info("Update planter");
		return pservice.updatePlanter(p);
	}
	
	@ApiOperation(value = "Customer Delete mapping to delete customer" , response = Customer.class)
	@DeleteMapping("/customer/delete/{cid}")
	public Customer deleteByCustomerId(@PathVariable int cid) {
		log.info("Delete customer");
		return cservice.deleteCustomer(cid);
	}
	
	@ApiOperation(value = "Order Delete mapping to delete order" , response = Order.class)
	@DeleteMapping("/order/delete/{oid}")
	public Order deleteOrder(@PathVariable int oid) {
		log.info("Delete order");
		return oservice.deleteOrder(oid);
	}
	
	@ApiOperation(value = "Plant Delete mapping to delete plant" , response = Plant.class)
	@DeleteMapping("/plant/delete/{pid}")
	public Plant deleteByIdPlant(@PathVariable int pid){
		log.info("Delete plant");
		return ipservice.deletePlant(pid);
	}
	
	@ApiOperation(value = "Seed Delete mapping to delete seed" , response = Seed.class)
	@DeleteMapping("/seed/delete/{sid}")
	public Seed deleteByIdSeed(@PathVariable int sid){
		log.info("Delete seed");
		return iservice.deleteSeed(sid);
	}
	
	@ApiOperation(value = "Planter Delete mapping to delete planter" , response = Planter.class)
	@DeleteMapping("/planter/delete/{pid}")
	public Planter deleteByIdPlanter(@PathVariable int pid){
		log.info("Delete planter");
		return pservice.deletePlanter(pid);
	}
	
	@ApiOperation(value = "Customer Get mapping to fetch customer by id" , response = Customer.class)
	@GetMapping("/customer/{cid}")
	public Customer viewById(@PathVariable int cid) throws ResourceNotFoundException{
		log.info("Get customer information by id");
		return cservice.viewCustomer(cid);
	}
	
	@ApiOperation(value = "Order Get mapping to fetch order by id" , response = Order.class)
	@GetMapping("/order/{oid}")
	public Order viewOrderById(@PathVariable int oid) throws OrderIdNotFoundException{
		log.info("Get order information by id");
		return oservice.viewOrder(oid);
	}
	
	@ApiOperation(value = "Plant Get mapping to fetch plant by id" , response = Plant.class)
	@GetMapping("/plantById/{pid}")
	public Plant viewByIdPlant(@PathVariable int pid) throws ResourceNotFoundException{
		log.info("Get plant information by id");
		return ipservice.viewPlantById(pid);
	}
	
	@ApiOperation(value = "Plant Get mapping to fetch plant by name" , response = Plant.class)
	@GetMapping("/plantByName/{pname}")
	public Plant viewByIdPlantName(@PathVariable String pname) throws ResourceNotFoundException{
		log.info("Get plant information by name");
		return ipservice.viewPlant(pname);
	}
	
	@ApiOperation(value = "Seed Get mapping to fetch seed by id" , response = Seed.class)
	@GetMapping("/seedById/{cid}")
	public Seed viewByIdSeed(@PathVariable int cid) throws SeedIdNotFoundException{
		log.info("Get seed information by id");
		return iservice.viewSeed(cid);
	}
	
	@ApiOperation(value = "Seed Get mapping to fetch seed by name" , response = Seed.class)
	@GetMapping("/seedByName/{cname}")
	public Seed viewByIdSeedName(@PathVariable String cname)throws ResourceNotFoundException {
		log.info("Get seed information by name");
		return iservice.viewSeed(cname);
	}
	
	@ApiOperation(value = "Planter Get mapping to fetch planter by id" , response = Planter.class)
	@GetMapping("/planter/{plid}")
	public Planter viewByIdPlanter(@PathVariable int plid)throws ResourceNotFoundException {
		log.info("Get Planter information by id");
		return pservice.viewPlanter(plid);
	}
	
	@ApiOperation(value = "Planter Get mapping to fetch planter by name" , response = Planter.class)
	@GetMapping("/planter/{plshape}")
	public Planter viewByIdPlanter(@PathVariable String plshape) throws ResourceNotFoundException{
		log.info("Get Planter information by id");
		return pservice.viewPlanter(plshape);
	}
	
	@ApiOperation(value = "Customer Get mapping to fetch all customers" , response = List.class)
	@GetMapping("/customers")
	public List<Customer> viewAll(){
		log.info("Get all Customers");
		return cservice.viewAllCustomers();
	}	
	
	@ApiOperation(value = "Order Get mapping to fetch all orders" , response = List.class)
	@GetMapping("/orders")
	public List<Order> viewAllOrders(){
		log.info("Get all Orders");
		return oservice.viewAllOrders();
	}
	
	@ApiOperation(value = "Plant Get mapping to fetch all plants" , response = List.class)
	@GetMapping("/plants")
	public List<Plant> viewAllPlants(){
		log.info("Get all Plants");
		return ipservice.viewAllPlants();
	}
	
	@ApiOperation(value = "Seed Get mapping to fetch all seeds" , response = List.class)
	@GetMapping("/seeds")
	public List<Seed> viewAllSeeds(){
		log.info("Get all seeds");
		return iservice.viewAllSeeds();
	}
	
	@ApiOperation(value = "Planter Get mapping to fetch all Planters" , response = List.class)
	@GetMapping("/planters")
	public List<Planter> viewAllPlanters(){
		log.info("Get all Planters");
		return pservice.viewAllPlanters();
	}
	
	@ApiOperation(value = "Plant Get mapping to fetch all plants by type" , response = List.class)
	@GetMapping("/plants/{ptype}")
	public List<Plant> viewAllPlants(@PathVariable String ptype) throws ResourceNotFoundException{
		return ipservice.viewAllPlants(ptype);
	}
	
	@ApiOperation(value = "Seed Get mapping to fetch all seeds in by type" , response = List.class)
	@GetMapping("/seeds/{stype}")
	public List<Seed> viewAllSeeds(@PathVariable String stype) throws ResourceNotFoundException{
		log.info("Get all seeds in given type");
		return iservice.viewAllSeeds(stype);
	}
	
	@ApiOperation(value = "Planter Get mapping to fetch all Planters in given range" , response = List.class)
	@GetMapping("/planters/{minCost}/{maxCost}")
	public List<Planter> viewAllPlanters(@PathVariable double minCost,@PathVariable double maxCost) throws ResourceNotFoundException{
		log.info("Get all Planters in given range");
		return pservice.viewAllPlanters(minCost,maxCost);
	}
	
	@ApiOperation(value = "Customer Post mapping to auth customer by userid and password")
	@PostMapping("/customer/auth/{userid}/{password}")
	public boolean validateCustomer(@PathVariable String userid, @PathVariable String password ) {
		return cservice.validateCustomer(userid, password);
	}
	
	
}
