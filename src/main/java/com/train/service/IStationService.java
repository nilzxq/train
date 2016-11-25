package com.train.service;

public interface IStationService {
	/**
	 * 計算出發站到目的地的車票價格
	 * 
	 * @param trainNum
	 *            車次
	 * @param startStation
	 *            出發站
	 * @param endStation
	 *            目的地
	 * @return 2016年11月20日
	 */
	public Double calcuSartToEndPrice(String trainnum, String startStation,
			String endStation);
}
