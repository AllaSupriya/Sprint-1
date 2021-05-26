package com.ec.onlineplantnursery.seed.repository;

import java.util.List;

import com.ec.onlineplantnursery.seed.entity.Seed;

public interface CustomSeedRepository {

	Seed getSeedByCommonName(String commonName);

	List<Seed> getSeedsByTypeOfSeed(String typeOfSeeds);

}