package com.train.service;


import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.train.dao.StationMapper;
import com.train.model.Station;
@Service("stationService")
public class StationServiceImpl implements IStationService {
	/**
	 * 点击变量名称按ctrl+shift+x
	 */
	private static Logger LOGGER=Logger.getLogger(StationServiceImpl.class);
	@Autowired
	private StationMapper stationMapper;
	@Override
	public Double calcuSartToEndPrice(String trainnum, String startStation,
			String endStation) {
		LOGGER.info("calcuStartToEndtinatPrice() 参数：trainnum="+trainnum+","
				+ "startStation="+startStation+",endStation="+endStation);
		Double resultPrice=null;
		// 先查找出发站的车站信息
		Station startStationResult=findByStation(trainnum, startStation);
		if(startStation==null){
			LOGGER.error("calcuStartToEndtinatPrice() startStationResult is null");
			return resultPrice;
		}
		// 查找目的的车站信息
		Station endStationResult=findByStation(trainnum,endStation);
		if(endStationResult==null){
			LOGGER.error("calcuStartToEndtinatPrice() endStationResult is null");
			return resultPrice;
		}
		resultPrice=endStationResult.getStatiprice()-startStationResult.getStatiprice();
		LOGGER.info("calcuStartToEndtinatPrice() resultPrice:"+resultPrice);
		return resultPrice;
	}
	/**
	 * 通過車次+車站名称得到對應價格
	 * @param trainNum
	 * @param Station
	 * @return 
	 * 2016年11月20日
	 */
    public Station findByStation(String trainnum, String station){
		Station stationEntity=new Station();
		stationEntity.setTrainnum(trainnum);
		stationEntity.setStation(station);
		return stationMapper.findByStation(stationEntity);
    	
    }
}
