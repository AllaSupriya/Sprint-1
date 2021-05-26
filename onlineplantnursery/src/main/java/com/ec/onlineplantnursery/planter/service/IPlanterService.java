package com.ec.onlineplantnursery.planter.service;

import java.util.List;

import com.ec.onlineplantnursery.exceptions.ResourceNotFoundException;
import com.ec.onlineplantnursery.planter.entity.Planter;

public interface IPlanterService {
	Planter addPlanter(Planter planter);

	Planter updatePlanter(Planter planter) throws ResourceNotFoundException;

	Planter deletePlanter(int pid);

	Planter viewPlanter(int planterId) throws ResourceNotFoundException;

	Planter viewPlanter(String planterShape) throws ResourceNotFoundException;

	List<Planter> viewAllPlanters();

	List<Planter> viewAllPlanters(double minCost, double maxCost) throws ResourceNotFoundException;
}
