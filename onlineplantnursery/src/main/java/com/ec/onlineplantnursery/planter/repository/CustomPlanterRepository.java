package com.ec.onlineplantnursery.planter.repository;

import java.util.List;
import java.util.Optional;

import com.ec.onlineplantnursery.planter.entity.Planter;

public interface CustomPlanterRepository {

	Optional<Planter> getPlanterByPlanterShape(String planterShape);

	Optional<List<Planter>> getPlantersByRange(double minCost,double maxCost);

}