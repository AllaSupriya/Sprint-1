package com.ec.onlineplantnursery.web;

import java.time.LocalDateTime;
import java.util.List;

import javax.validation.Valid;

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


@Validated
@RestController
@RequestMapping("/api")
public class MyRestController {
	
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
	
	@PostMapping("/customer/insert")
	public Customer insertCustomer(@RequestBody @Valid Customer c) {
		return cservice.addCustomer(c);
	}
	
	/*@PostMapping("/order/new/{cid}/{pid}")
	public Order newOrder(@RequestBody Order o,@PathVariable int cid,@PathVariable int pid) {
		return oservice.addOrder(o,cid,pid);
	}*/
	
	@PostMapping("/order/new")
	public Order newOrder(@RequestBody @Valid Order o) throws ResourceNotFoundException {
		return oservice.addOrder(o);
	}
	
	@PostMapping("/insert/planter")
	public Planter insertPlanter(@RequestBody @Valid Planter p) {
		return pservice.addPlanter(p);
	}
	
	@PostMapping("/insert/plant")
	public Plant insertPlant(@RequestBody @Valid Plant p) {
		return ipservice.addPlant(p);
	}
	
	@PostMapping("/insert/seed")
	public Seed insertPlant(@RequestBody @Valid Seed p) {
		return iservice.addSeed(p);
	}
	
	@PutMapping("/customer/update")
	public Customer updateById(@RequestBody Customer c) throws ResourceNotFoundException{
		return cservice.updateCustomer(c);
	}
	
	@PutMapping("/order/update")
	public Order updateByOrder(@RequestBody Order o)throws ResourceNotFoundException {
		return oservice.updateOrder(o);
	}
	
	@PutMapping("/plant/update")
	public Plant updatePlant(@RequestBody Plant p)throws ResourceNotFoundException {
		return ipservice.updatePlant(p);
	}
	
	@PutMapping("/seed/update")
	public Seed updateSeed(@RequestBody Seed s)throws ResourceNotFoundException {
		return iservice.updateSeed(s);
	}
	
	@PutMapping("/planter/update")
	public Planter updatePlanter(@RequestBody Planter p)throws ResourceNotFoundException {
		return pservice.updatePlanter(p);
	}
	
	@DeleteMapping("/customer/delete/{cid}")
	public Customer deleteByCustomerId(@PathVariable int cid) {
		return cservice.deleteCustomer(cid);
	}
	
	@DeleteMapping("/order/delete/{oid}")
	public Order deleteOrder(@PathVariable int oid) {
		return oservice.deleteOrder(oid);
	}
	
	@DeleteMapping("/plant/delete/{pid}")
	public Plant deleteByIdPlant(@PathVariable int pid){
		return ipservice.deletePlant(pid);
	}
	
	@DeleteMapping("/seed/delete/{sid}")
	public Seed deleteByIdSeed(@PathVariable int sid){
		return iservice.deleteSeed(sid);
	}
	
	@DeleteMapping("/planter/delete/{pid}")
	public Planter deleteByIdPlanter(@PathVariable int pid){
		return pservice.deletePlanter(pid);
	}
	
	@GetMapping("/customer/{cid}")
	public Customer viewById(@PathVariable int cid) throws ResourceNotFoundException{
		return cservice.viewCustomer(cid);
	}
	
	@GetMapping("/order/{oid}")
	public Order viewOrderById(@PathVariable int oid) throws OrderIdNotFoundException{
		return oservice.viewOrder(oid);
	}
	
	@GetMapping("/plantById/{pid}")
	public Plant viewByIdPlant(@PathVariable int pid) throws ResourceNotFoundException{
		return ipservice.viewPlantById(pid);
	}
	
	@GetMapping("/plantByName/{pname}")
	public Plant viewByIdPlantName(@PathVariable String pname) throws ResourceNotFoundException{
		return ipservice.viewPlant(pname);
	}
	
	@GetMapping("/seedById/{cid}")
	public Seed viewByIdSeed(@PathVariable int cid) throws SeedIdNotFoundException{
		return iservice.viewSeed(cid);
	}
	
	@GetMapping("/seedByName/{cname}")
	public Seed viewByIdSeedName(@PathVariable String cname)throws ResourceNotFoundException {
		return iservice.viewSeed(cname);
	}
	
	@GetMapping("/planter/{plid}")
	public Planter viewByIdPlanter(@PathVariable int plid)throws ResourceNotFoundException {
		return pservice.viewPlanter(plid);
	}
	
	@GetMapping("/planter/{plshape}")
	public Planter viewByIdPlanter(@PathVariable String plshape) throws ResourceNotFoundException{
		return pservice.viewPlanter(plshape);
	}
	
	@GetMapping("/customers")
	public List<Customer> viewAll(){
		return cservice.viewAllCustomers();
	}
	
	@GetMapping("/orders")
	public List<Order> viewAllOrders(){
		return oservice.viewAllOrders();
	}
	
	@GetMapping("/plants")
	public List<Plant> viewAllPlants(){
		return ipservice.viewAllPlants();
	}
	
	@GetMapping("/seeds")
	public List<Seed> viewAllSeeds(){
		return iservice.viewAllSeeds();
	}
	
	@GetMapping("/planters")
	public List<Planter> viewAllPlanters(){
		return pservice.viewAllPlanters();
	}
	
	@GetMapping("/plants/{ptype}")
	public List<Plant> viewAllPlants(@PathVariable String ptype) throws ResourceNotFoundException{
		return ipservice.viewAllPlants(ptype);
	}
	
	@GetMapping("/seeds/{stype}")
	public List<Seed> viewAllSeeds(@PathVariable String stype) throws ResourceNotFoundException{
		return iservice.viewAllSeeds(stype);
	}
	
	@GetMapping("/planters/{minCost}/{maxCost}")
	public List<Planter> viewAllPlanters(@PathVariable double minCost,@PathVariable double maxCost) throws ResourceNotFoundException{
		return pservice.viewAllPlanters(minCost,maxCost);
	}
	
	@PostMapping("/customer/auth/{userid}/{password}")
	public boolean validateCustomer(@PathVariable String userid, @PathVariable String password ) {
		return cservice.validateCustomer(userid, password);
	}
	
	
}
