package com.ec.onlineplantnursery.order.repository;

import java.util.List;
import java.util.Optional;

import com.ec.onlineplantnursery.planter.entity.Planter;

public interface CustomOrderRepository {

	Optional<List<Planter>> getPlanterByOrderId(int orderId);

}